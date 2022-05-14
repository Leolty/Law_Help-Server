package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import tech.linjuliwhu.util.MyConstants;

public class Question {
    /** 主键ID */
    @TableId
    private String queId ;
    /** 父问题ID */
    private String queFatherId ;
    /** 父问题的选项 */
    private String queOption ;
    /** 问题内容 */
    private String queText ;
    /** 问题层次;0root1node2leaf */
    private Integer queIfLeaf = MyConstants.QUE_LEVEL_NODE;
    /** 是否允许其他;0、1 */
    private Integer queHasOther ;
    /** 点击次数 */
    private Integer clickTimes = 0;
    /** 上传时间 */
    private String upTime ;
    /** 上传者 */
    private String upId ;
    /** 是否删除;0、1 */
    private Integer ifDelete = MyConstants.QUE_IF_DELETE_FALSE;

    /** 主键ID */
    public String getQueId(){
        return this.queId;
    }
    /** 主键ID */
    public void setQueId(String queId){
        this.queId = queId;
    }
    /** 父问题ID */
    public String getQueFatherId(){
        return this.queFatherId;
    }
    /** 父问题ID */
    public void setQueFatherId(String queFatherId){
        this.queFatherId = queFatherId;
    }
    /** 父问题的选项 */
    public String getQueOption(){
        return this.queOption;
    }
    /** 父问题的选项 */
    public void setQueOption(String queOption){
        this.queOption = queOption;
    }
    /** 问题内容 */
    public String getQueText(){
        return this.queText;
    }
    /** 问题内容 */
    public void setQueText(String queText){
        this.queText = queText;
    }
    /** 问题层次;0root1node2leaf */
    public Integer getQueIfLeaf(){
        return this.queIfLeaf;
    }
    /** 问题层次;0root1node2leaf */
    public void setQueIfLeaf(Integer queIfLeaf){
        this.queIfLeaf = queIfLeaf;
    }
    /** 是否允许其他;0、1 */
    public Integer getQueHasOther(){
        return this.queHasOther;
    }
    /** 是否允许其他;0、1 */
    public void setQueHasOther(Integer queHasOther){
        this.queHasOther = queHasOther;
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
    /** 上传者 */
    public String getUpId(){
        return this.upId;
    }
    /** 上传者 */
    public void setUpId(String upId){
        this.upId = upId;
    }
    /** 是否删除;0、1 */
    public Integer getIfDelete(){
        return this.ifDelete;
    }
    /** 是否删除;0、1 */
    public void setIfDelete(Integer ifDelete){
        this.ifDelete = ifDelete;
    }
}
