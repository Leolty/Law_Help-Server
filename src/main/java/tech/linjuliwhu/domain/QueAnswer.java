package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import tech.linjuliwhu.util.MyConstants;

public class QueAnswer {
    /** 主键ID */
    @TableId
    private String ansId ;
    /** 问题ID */
    private String queId ;
    /** 答案文本 */
    private String ansText ;
    /** 点击次数 */
    private Integer clickTimes = 0;
    /** 上传时间 */
    private String upTime ;
    /** 上传者ID */
    private String upId ;
    /** 是否失效 */
    private Integer ifDelete = MyConstants.QUE_IF_DELETE_FALSE;

    /** 主键ID */
    public String getAnsId(){
        return this.ansId;
    }
    /** 主键ID */
    public void setAnsId(String ansId){
        this.ansId = ansId;
    }
    /** 问题ID */
    public String getQueId(){
        return this.queId;
    }
    /** 问题ID */
    public void setQueId(String queId){
        this.queId = queId;
    }
    /** 答案文本 */
    public String getAnsText(){
        return this.ansText;
    }
    /** 答案文本 */
    public void setAnsText(String ansText){
        this.ansText = ansText;
    }
    /** 点击次数 */
    public Integer getClickTimes(){
        return this.clickTimes;
    }
    /** 点击次数 */
    public void setClickTimes(Integer clickTimes){
        this.clickTimes = clickTimes;
    }
    /** 上传时间 */
    public String getUpTime(){
        return this.upTime;
    }
    /** 上传时间 */
    public void setUpTime(String upTime){
        this.upTime = upTime;
    }
    /** 上传者ID */
    public String getUpId(){
        return this.upId;
    }
    /** 上传者ID */
    public void setUpId(String upId){
        this.upId = upId;
    }
    /** 是否失效 */
    public Integer getIfDelete(){
        return this.ifDelete;
    }
    /** 是否失效 */
    public void setIfDelete(Integer ifDelete){
        this.ifDelete = ifDelete;
    }
}
