package tech.linjuliwhu.controller.admin;

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
import tech.linjuliwhu.domain.QueRoot;
import tech.linjuliwhu.domain.Question;
import tech.linjuliwhu.service.QueService;
import tech.linjuliwhu.util.MyConstants;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/admin/que")
@Component("AdminQueController")
public class QueController {
    @Autowired
    private QueService queService;

    @PostMapping("/newQueRoot")
    public HashMap<String, Object> getIconList(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);
        String userId = object.getString("userId");
        String queText = object.getString("queText");

        String rootName = object.getString("rootName");
        String rootVersion = object.getString("rootVersion");
        String queId = UUID.randomUUID().toString();

        queService.addQueRoot(rootName, rootVersion, queId);
        queService.addQueWithRootLocation(userId, queText, queId);

        return res;
    }

    @PostMapping("/newAns")
    public HashMap<String, Object> newAns(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        Question question = JSON.parseObject(body, new TypeReference<Question>() {
        });
        queService.addQueLeaf(question);
        String ansStr = JSONObject.parseObject(body).getString("queAnswer");
        queService.addQueAnswer(question, ansStr);

        return res;
    }

    @PostMapping("/newQue")
    public HashMap<String, Object> newQue(@RequestBody String body) {
        HashMap<String, Object> res = new HashMap<>();
        Question question = JSON.parseObject(body, new TypeReference<Question>() {
        });
        queService.addQueNode(question);

        return res;
    }
}
