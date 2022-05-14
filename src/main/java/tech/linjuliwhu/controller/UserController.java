package tech.linjuliwhu.controller;

import tech.linjuliwhu.domain.User;
import tech.linjuliwhu.service.RedisService;
import tech.linjuliwhu.service.UserService;
import tech.linjuliwhu.util.MyConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tech.linjuliwhu.util.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Component("UserController")
public class UserController {
    private final String wxAppId = "wxffe6dfdc18c79379";
    private final String wxAppSecret = "2ea63e168427a7190204111ad5fe0519";
    private final String wxAPI = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/logout")
    public HashMap<String, Object> logout(@RequestBody String body) {
        HashMap<String, Object> ret = new HashMap<>();
        try {
            JSONObject object = JSON.parseObject(body);
            String sessionKey = object.getString("sessionKey");
            redisService.delSessionId(sessionKey);
            ret.put("state", MyConstants.RESULT_OK);
        } catch (Exception e) {
            ret.put("state", MyConstants.RESULT_FAIL);
        }
        return ret;
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody String body) {
        HashMap<String, Object> ret = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);

        String openId = object.getString("userId");

        if(Util.isEmpty(openId)){
            openId = this.getOpenIdByCode(object.getString("code"));
            if (openId == null) {
                ret.put("state", MyConstants.RESULT_FAIL);
                return ret;
            }
        }

        User user = userService.getUserById(openId);

        if (user == null) {  // 新用户注册
            user = this.createUser(object, openId);
            if (userService.insertUser(user) != 1) {
                ret.put("state", MyConstants.RESULT_FAIL);
                ret.put("info", MyConstants.RESULT_INSERT_FAIL);
                return ret;
            }
        } else {  // 老用户登录
            log.info("user " + user.getUserId() + "/" + user.getUserName() + " login at " + new Date());
            this.updateOldUser(object, user);
            if (userService.updateUser(user) != 1) {
                ret.put("state", MyConstants.RESULT_FAIL);
                ret.put("info", MyConstants.RESULT_UPDATE_FAIL);
                return ret;
            }
        }

        ret.put("state", MyConstants.RESULT_OK);
        ret.put("openId", user.getUserId());
        ret.put("sessionKey", user.getUserSession());
        ret.put("userType", user.getUserType());
        return ret;
    }

    private String getOpenIdByCode(String code) {
        String response = "";
        try {
            RestTemplate restTemplate = new RestTemplate();
            String params = "?appid=" + wxAppId + "&secret=" + wxAppSecret + "&js_code=" + code + "&grant_type=authorization_code";
            String url = wxAPI + params;
            response = restTemplate.getForObject(url, String.class);

            JsonNode node = this.objectMapper.readTree(response);
            return node.get("openid").asText();
        } catch (Exception ex) {
            log.error("Something Wrong When Get OpenId from code: " + code + "\n" + ex.getMessage() + "\n" +
                    " the real response is: " + response);
            return null;
        }
    }

    private User createUser(JSONObject object, String openId) {
        User user = new User();
        user.setUserId(openId);
        user.setUserTime(MyConstants.DATETIME_FORMAT.format(new Date()));

        this.updateOldUser(object, user);
        return user;
    }

    private void updateOldUser(JSONObject object, User user) {
        JSONObject userInfo = (JSONObject) object.get("userInfo");
        if (userInfo != null) {
            user.setUserName(userInfo.getString("nickName"));
            user.setUserGender(userInfo.getInteger("gender"));
            user.setUserAvatar(userInfo.getString("avatarUrl"));
        }

        String userSessionKey = UUID.randomUUID().toString();
        user.setUserSession(userSessionKey);

        try {
            redisService.delSessionId(user.getUserSession());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        redisService.saveUserOrAdminBySessionId(user.getUserSession(), user);
    }

    @PostMapping("/loginWithCode")
    public HashMap<String, Object> loginWithCode(@RequestBody String body) {
        HashMap<String, Object> ret = new HashMap<>();
        JSONObject object = JSONObject.parseObject(body);

        String openId = this.getOpenIdByCode(object.getString("code"));
        if (openId == null) {
            ret.put("state", MyConstants.RESULT_FAIL);
            return ret;
        }

        User user = userService.getUserById(openId);
        ret.put("openId", openId);

        if (user == null) {  // 新用户
            ret.put("state", MyConstants.RESULT_FAIL);
            return ret;
        }
        log.info("user " + user.getUserId() + "/" + user.getUserName() + " login at " + new Date());
        UserInfo userInfo = new UserInfo(user.getUserAvatar(), user.getUserName(), user.getUserGender());
        ret.put("userInfo", userInfo);

        ret.put("state", MyConstants.RESULT_OK);
        ret.put("sessionKey", user.getUserSession());
        ret.put("userType", user.getUserType());

        try {
            redisService.delSessionId(user.getUserSession());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        redisService.saveUserOrAdminBySessionId(user.getUserSession(), user);
        return ret;
    }
}


class UserInfo {
    private String avatarUrl;
    private String nickName;
    private int gender;

    public UserInfo(String _avatarUrl, String _nickName, int _gender) {
        this.avatarUrl = _avatarUrl;
        this.nickName = _nickName;
        this.gender = _gender;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
