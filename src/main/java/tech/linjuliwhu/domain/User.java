package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import tech.linjuliwhu.util.MyConstants;

import java.io.Serializable;

public class User implements Serializable {
    /** 主键ID */
    @TableId
    private String userId ;
    /** 用户昵称 */
    private String userName ;
    /** 用户头像 */
    private String userAvatar ;
    /** 用户性别 */
    private Integer userGender ;
    /** 注册时间 */
    private String userTime ;
    /** 用户类型;0普通;1运维;2管理;3开发 */
    private Integer userType = MyConstants.USER_TYPE_USER;
    /** 登陆状态校验码 */
    private String userSession ;

    /** 主键ID */
    public String getUserId(){
        return this.userId;
    }
    /** 主键ID */
    public void setUserId(String userId){
        this.userId = userId;
    }
    /** 用户昵称 */
    public String getUserName(){
        return this.userName;
    }
    /** 用户昵称 */
    public void setUserName(String userName){
        this.userName = userName;
    }
    /** 用户头像 */
    public String getUserAvatar(){
        return this.userAvatar;
    }
    /** 用户头像 */
    public void setUserAvatar(String userAvatar){
        this.userAvatar = userAvatar;
    }
    /** 用户性别 */
    public Integer getUserGender(){
        return this.userGender;
    }
    /** 用户性别 */
    public void setUserGender(Integer userGender){
        this.userGender = userGender;
    }
    /** 注册时间 */
    public String getUserTime(){
        return this.userTime;
    }
    /** 注册时间 */
    public void setUserTime(String userTime){
        this.userTime = userTime;
    }
    /** 用户类型;0普通;1运维;2管理;3开发 */
    public Integer getUserType(){
        return this.userType;
    }
    /** 用户类型;0普通;1运维;2管理;3开发 */
    public void setUserType(Integer userType){
        this.userType = userType;
    }
    /** 登陆状态校验码 */
    public String getUserSession(){
        return this.userSession;
    }
    /** 登陆状态校验码 */
    public void setUserSession(String userSession){
        this.userSession = userSession;
    }
}
