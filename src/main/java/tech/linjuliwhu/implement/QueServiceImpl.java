package tech.linjuliwhu.implement;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.linjuliwhu.domain.QueAnswer;
import tech.linjuliwhu.domain.QueRoot;
import tech.linjuliwhu.domain.Question;
import tech.linjuliwhu.mapper.QueAnswerMapper;
import tech.linjuliwhu.mapper.QueRootMapper;
import tech.linjuliwhu.mapper.QuestionMapper;
import tech.linjuliwhu.service.QueService;
import tech.linjuliwhu.util.FatherQue;
import tech.linjuliwhu.util.MyConstants;
import tech.linjuliwhu.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("QueServiceImpl")
public class QueServiceImpl implements QueService {
    @Autowired
    private QueRootMapper queRootMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QueAnswerMapper queAnswerMapper;

    @Override
    public List<QueRoot> getQueRootByVersion(int rootVersion) {
        return queRootMapper.selectList(new EntityWrapper<QueRoot>()
                .eq("ROOT_VERSION", rootVersion));
    }

    @Override
    public Question getQuestionById(String queId) {
        return questionMapper.selectById(queId);
    }

    @Override
    public List<Question> getSubsById(String queId) {
        return questionMapper.selectList(new EntityWrapper<Question>()
                .eq("QUE_FATHER_ID", queId)
                .eq("IF_DELETE", MyConstants.QUE_IF_DELETE_FALSE)
                .orderBy("UP_TIME"));
    }

    @Override
    public QueAnswer getAnsByQueId(String queId) {
        List<QueAnswer> queAnswerList = queAnswerMapper.selectList(new EntityWrapper<QueAnswer>()
                .eq("QUE_ID", queId)
                .eq("IF_DELETE", MyConstants.QUE_IF_DELETE_FALSE));
        if (queAnswerList.size() == 0) {
            return null;
        } else {
            return queAnswerList.get(0);
        }
    }

    @Override
    public int addQueRoot(String rootName, String rootVersion, String queId) {
        QueRoot queRoot = new QueRoot();
        queRoot.setQueRootId(queId);
        queRoot.setRootName(rootName);

        queRoot.setRootVersion(Integer.parseInt(rootVersion));

        return queRootMapper.insert(queRoot);
    }

    @Override
    public int addQueWithRootLocation(String userId, String queText, String queId) {
        Question question = new Question();
        question.setQueId(queId);
        question.setUpId(userId);
        question.setQueText(queText);
        question.setQueIfLeaf(MyConstants.QUE_LEVEL_ROOT);
        question.setUpTime(MyConstants.DATETIME_FORMAT.format(new Date()));

        return questionMapper.insert(question);
    }

    @Override
    public int addQueNode(Question question) {
        question.setQueId(UUID.randomUUID().toString());
        question.setQueIfLeaf(MyConstants.QUE_LEVEL_NODE);
        question.setUpTime(MyConstants.DATETIME_FORMAT.format(new Date()));
        return questionMapper.insert(question);
    }

    @Override
    public int addQueLeaf(Question question) {
        question.setQueId(UUID.randomUUID().toString());
        question.setQueIfLeaf(MyConstants.QUE_LEVEL_LEAF);
        question.setUpTime(MyConstants.DATETIME_FORMAT.format(new Date()));
        return questionMapper.insert(question);
    }

    @Override
    public int addQueAnswer(Question question, String ansStr) {
        // 新增时与question 基本数据大都保持一致，
        // 但防止出现修改的情况，届时原有的会失效 IF_DELETE = 1，queAns 与 que 基本数据就不一样了
        QueAnswer queAnswer = new QueAnswer();
        queAnswer.setAnsId(UUID.randomUUID().toString());
        queAnswer.setQueId(question.getQueId());
        queAnswer.setUpId(question.getUpId());
        queAnswer.setUpTime(MyConstants.DATETIME_FORMAT.format(new Date()));
        queAnswer.setAnsText(ansStr);
        return queAnswerMapper.insert(queAnswer);
    }

    @Override
    public List<FatherQue> getFatherQuesByQueId(String queId) {
        List<Question> questions = new ArrayList<>();
        List<FatherQue> fatherQuesRes = new ArrayList<>();

        while (!Util.isEmpty(queId)) {
            Question question = questionMapper.selectById(queId);
            queId = question.getQueFatherId();
            questions.add(question);
        }

        // 最后一个是rootQue,应倒序; 第i个问题应是 i+1 的题干加上 i 的选项
        for (int i = questions.size() - 2; i >= 0; --i) {
            FatherQue fatherQue = new FatherQue(questions.get(i + 1).getQueText(), questions.get(i).getQueOption());
            fatherQuesRes.add(fatherQue);
        }
        return fatherQuesRes;
    }
}
