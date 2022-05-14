package tech.linjuliwhu.controller.visitor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.linjuliwhu.domain.AttachFile;
import tech.linjuliwhu.domain.Parameter;
import tech.linjuliwhu.domain.QueUserAsk;
import tech.linjuliwhu.service.AttachFileService;
import tech.linjuliwhu.service.ParameterService;
import tech.linjuliwhu.service.QueService;
import tech.linjuliwhu.service.QueUserAskService;
import tech.linjuliwhu.util.FatherQue;
import tech.linjuliwhu.util.MyConstants;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/visitor/ask")
@Component("VisitorQueUserAskController")
public class QueUserAskController {
    @Autowired
    private ParameterService parameterService;

    @Autowired
    private QueUserAskService queUserAskService;

    @Autowired
    private QueService queService;

    @Autowired
    private AttachFileService attachFileService;

    @PostMapping("/getRepliedPublicAsk")
    public HashMap<String, Object> getRepliedPublicAsk(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        Parameter mpVersionParam = parameterService.getParamValueByName(MyConstants.MP_VERSION);
        List<QueUserAsk> queUserAskList =
                queUserAskService.getPublicAskBySAV(MyConstants.QUE_ASK_STATUS_COMPLETE, mpVersionParam);

        res.put("queUserAskList", queUserAskList);
        return res;
    }


    @PostMapping("/getAskFatherQues")
    public HashMap<String, Object> getAskFatherQues(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);
        String askId = object.getString("askId");

        QueUserAsk queUserAsk = queUserAskService.getAskById(askId);

        List<FatherQue> fatherQueList = queService.getFatherQuesByQueId(queUserAsk.getQueId());
        List<AttachFile> attachFileList = attachFileService.getFilesBuyLinkId(queUserAsk.getAskId());

        res.put("queUserAsk", queUserAsk);
        res.put("fatherQueList", fatherQueList);
        res.put("attachFileList", attachFileList);
        return res;
    }

    @PostMapping("/getMyAskByStatus")
    public HashMap<String, Object> getMyAskByStatus(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);
        String userId = object.getString("userId");
        int askStatus = object.getInteger("askStatus");
        Parameter mpVersionParam = parameterService.getParamValueByName(MyConstants.MP_VERSION);
        List<QueUserAsk> queUserAskList = queUserAskService.getMyAskBySAV(userId, askStatus, mpVersionParam);

        res.put("queUserAskList", queUserAskList);
        return res;
    }

    @PostMapping("/getMyAskAll")
    public HashMap<String, Object> getMyAskAll(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);
        String userId = object.getString("userId");
        Parameter mpVersionParam = parameterService.getParamValueByName(MyConstants.MP_VERSION);
        List<QueUserAsk> queUserAskList = queUserAskService.getMyAskAll(userId, mpVersionParam);

        res.put("queUserAskList", queUserAskList);
        return res;
    }
}
