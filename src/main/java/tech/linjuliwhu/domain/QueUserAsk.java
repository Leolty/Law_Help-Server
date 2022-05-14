package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import tech.linjuliwhu.util.MyConstants;

public class QueUserAsk {
    /** 主键ID */
    @TableId
    private String askId ;
    /** 问题ID */
    private String queId ;
    /** 提问者 */
    private String userId ;
    /** 提问标题 */
    private String queTitle ;
    /** 提问内容 */
    private String queContent ;
    /** 提问时间 */
    private String askTime ;
    /** 提问状态;0提交待回复；1提交已回复；2回复不了 */
    private Integer askStatus = MyConstants.QUE_ASK_STATUS_SUBMIT;
    /** 回答 */
    private String queAnswer ;
    /** 回答时间 */
    private String answerTime ;
    /** 回答者 */
    private String answerUserId ;
    /** 提问类型;0审核用；1正式用 */
    private Integer answerVersion = MyConstants.QUE_ASK_TYPE_EXAM;
    /** 是否公开;0/1 */
    private Integer publicState = MyConstants.QUE_ASK_IS_PUBLIC_TRUE;
    /** 是否已读;0/1 */
    private Integer userHasRead = MyConstants.QUE_ASK_USER_HAS_READ_FALSE;

    /** 主键ID */
    public String getAskId(){
        return this.askId;
    }
    /** 主键ID */
    public void setAskId(String askId){
        this.askId = askId;
    }
    /** 问题ID */
    public String getQueId(){
        return this.queId;
    }
    /** 问题ID */
    public void setQueId(String queId){
        this.queId = queId;
    }
    /** 提问者 */
    public String getUserId(){
        return this.userId;
    }
    /** 提问者 */
    public void setUserId(String userId){
        this.userId = userId;
    }
    /** 提问标题 */
    public String getQueTitle(){
        return this.queTitle;
    }
    /** 提问标题 */
    public void setQueTitle(String queTitle){
        this.queTitle = queTitle;
    }
    /** 提问内容 */
    public String getQueContent(){
        return this.queContent;
    }
    /** 提问内容 */
    public void setQueContent(String queContent){
        this.queContent = queContent;
    }
    /** 提问时间 */
    public String getAskTime(){
        return this.askTime;
    }
    /** 提问时间 */
    public void setAskTime(String askTime){
        this.askTime = askTime;
    }
    /** 提问状态;0提交待回复；1提交已回复；2回复不了 */
    public Integer getAskStatus(){
        return this.askStatus;
    }
    /** 提问状态;0提交待回复；1提交已回复；2回复不了 */
    public void setAskStatus(Integer askStatus){
        this.askStatus = askStatus;
    }
    /** 回答 */
    public String getQueAnswer(){
        return this.queAnswer;
    }
    /** 回答 */
    public void setQueAnswer(String queAnswer){
        this.queAnswer = queAnswer;
    }
    /** 回答时间 */
    public String getAnswerTime(){
        return this.answerTime;
    }
    /** 回答时间 */
    public void setAnswerTime(String answerTime){
        this.answerTime = answerTime;
    }
    /** 回答者 */
    public String getAnswerUserId(){
        return this.answerUserId;
    }
    /** 回答者 */
    public void setAnswerUserId(String answerUserId){
        this.answerUserId = answerUserId;
    }
    /** 提问类型;0审核用；1正式用 */
    public Integer getAnswerVersion(){
        return this.answerVersion;
    }
    /** 提问类型;0审核用；1正式用 */
    public void setAnswerVersion(Integer answerVersion){
        this.answerVersion = answerVersion;
    }
    /** 是否公开;0/1 */
    public Integer getPublicState(){
        return this.publicState;
    }
    /** 是否公开;0/1 */
    public void setPublicState(Integer publicState){
        this.publicState = publicState;
    }
    /** 是否已读;0/1 */
    public Integer getUserHasRead(){
        return this.userHasRead;
    }
    /** 是否已读;0/1 */
    public void setUserHasRead(Integer userHasRead){
        this.userHasRead = userHasRead;
    }
}
