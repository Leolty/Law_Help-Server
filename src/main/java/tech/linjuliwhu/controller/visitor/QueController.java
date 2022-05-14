package tech.linjuliwhu.controller.visitor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.linjuliwhu.domain.Parameter;
import tech.linjuliwhu.domain.QueAnswer;
import tech.linjuliwhu.domain.QueRoot;
import tech.linjuliwhu.domain.Question;
import tech.linjuliwhu.service.ParameterService;
import tech.linjuliwhu.service.QueService;
import tech.linjuliwhu.util.MyConstants;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/visitor/que")
@Component("VisitorQueController")
public class QueController {
    @Autowired
    private QueService queService;

    @Autowired
    private ParameterService parameterService;


    @PostMapping("/getIconList")
    public HashMap<String, Object> getIconList(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
//        JSONObject object = JSONObject.parseObject(body);
//        String paramName = object.getString("paramName");

        Parameter mpVersionParam = parameterService.getParamValueByName(MyConstants.MP_VERSION);
        List<QueRoot> queRootList = queService.getQueRootByVersion(Integer.parseInt(mpVersionParam.getParamValue()));

        res.put("iconList", queRootList);
        return res;
    }

    @PostMapping("/getQueList")
    public HashMap<String, Object> getQueList(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);
        String queId = object.getString("queId");

        Question question = queService.getQuestionById(queId);
        if(question == null){
            res.put("state", MyConstants.RESULT_FAIL);
            return res;
        }

        if (question.getQueIfLeaf() == MyConstants.QUE_LEVEL_NODE || question.getQueIfLeaf() == MyConstants.QUE_LEVEL_ROOT) {
            List<Question> optionList = queService.getSubsById(queId);
            res.put("ops", optionList);
        } else if (question.getQueIfLeaf() == MyConstants.QUE_LEVEL_LEAF) {
            QueAnswer queAnswer = queService.getAnsByQueId(queId);
            if (queAnswer != null)
                res.put("ans", queAnswer);
        }

        res.put("que", question);
        return res;
    }

}
