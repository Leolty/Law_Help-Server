package tech.linjuliwhu.implement;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.linjuliwhu.domain.Parameter;
import tech.linjuliwhu.domain.QueUserAsk;
import tech.linjuliwhu.mapper.QueUserAskMapper;
import tech.linjuliwhu.service.QueUserAskService;
import tech.linjuliwhu.util.MyConstants;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("QueUserAskServiceImpl")
public class QueUserAskServiceImpl implements QueUserAskService {
    @Autowired
    private QueUserAskMapper queUserAskMapper;

    @Override
    public int addAsk(QueUserAsk queUserAsk, Parameter mpVersionParam) {
        queUserAsk.setAskId(UUID.randomUUID().toString());
        // 可能是直接提问的，不是针对某层问题，没有queId,此时为null
        queUserAsk.setAskTime(MyConstants.DATETIME_FORMAT.format(new Date()));
        queUserAsk.setAnswerVersion(Integer.parseInt(mpVersionParam.getParamValue()));
        return queUserAskMapper.insert(queUserAsk);
    }

    @Override
    public int replyAsk(String askId, String answerUserId, String queAnswer) {
        QueUserAsk queUserAsk = queUserAskMapper.selectById(askId);
        queUserAsk.setAskStatus(MyConstants.QUE_ASK_STATUS_COMPLETE);
        queUserAsk.setAnswerUserId(answerUserId);
        queUserAsk.setQueAnswer(queAnswer);
        queUserAsk.setAnswerTime(MyConstants.DATETIME_FORMAT.format(new Date()));

        return queUserAskMapper.updateById(queUserAsk);
    }

    @Override
    public List<QueUserAsk> getMyAskBySAV(String userId, int askStatus, Parameter mpVersionParam) {
        return queUserAskMapper.selectList(new EntityWrapper<QueUserAsk>()
                .eq("USER_ID", userId)
                .eq("ANSWER_VERSION", mpVersionParam.getParamValue())
                .eq("ASK_STATUS", askStatus));
    }

    @Override
    public List<QueUserAsk> getMyAskAll(String userId, Parameter mpVersionParam) {
        return queUserAskMapper.selectList(new EntityWrapper<QueUserAsk>()
                .eq("USER_ID", userId)
                .eq("ANSWER_VERSION", mpVersionParam.getParamValue()));
    }

    @Override
    public List<QueUserAsk> getAskBySAV(int queAskStatus, Parameter mpVersionParam) {
        return queUserAskMapper.selectList(new EntityWrapper<QueUserAsk>()
                .eq("ANSWER_VERSION", mpVersionParam.getParamValue())
                .eq("ASK_STATUS", queAskStatus));
    }

    @Override
    public List<QueUserAsk> getPublicAskBySAV(int queAskStatus, Parameter mpVersionParam) {
        return queUserAskMapper.selectList(new EntityWrapper<QueUserAsk>()
                .eq("ANSWER_VERSION", mpVersionParam.getParamValue())
                .eq("ASK_STATUS", queAskStatus)
                .eq("PUBLIC_STATE", MyConstants.QUE_ASK_IS_PUBLIC_TRUE));
    }

    @Override
    public List<QueUserAsk> getAllAsks(Parameter mpVersionParam) {
        return queUserAskMapper.selectList(new EntityWrapper<QueUserAsk>()
                .eq("ANSWER_VERSION", mpVersionParam.getParamValue()));
    }

    @Override
    public QueUserAsk getAskById(String askId) {
        return queUserAskMapper.selectById(askId);
    }
}
