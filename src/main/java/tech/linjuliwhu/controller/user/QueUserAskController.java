package tech.linjuliwhu.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.linjuliwhu.domain.Parameter;
import tech.linjuliwhu.domain.QueUserAsk;
import tech.linjuliwhu.service.ParameterService;
import tech.linjuliwhu.service.QueUserAskService;
import tech.linjuliwhu.util.MyConstants;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user/ask")
@Component("QueUserAskController")
public class QueUserAskController {
    @Autowired
    private QueUserAskService queUserAskService;

    @Autowired
    private ParameterService parameterService;

    @PostMapping("/addAsk")
    public HashMap<String, Object> addAsk(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        QueUserAsk queUserAsk = JSON.parseObject(body, new TypeReference<QueUserAsk>() {
        });
        Parameter mpVersionParam = parameterService.getParamValueByName(MyConstants.MP_VERSION);
        queUserAskService.addAsk(queUserAsk, mpVersionParam);
        res.put("askId", queUserAsk.getAskId());
        return res;
    }
}
