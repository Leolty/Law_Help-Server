package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

public class Parameter implements Serializable{
    /** 主键ID;本表主键ID */
    @TableId
    private String paramId ;
    /** 参数 */
    private String paramKey ;
    /** 参数值 */
    private String paramValue ;

    /** 主键ID */
    public String getParamId(){
        return this.paramId;
    }
    /** 主键ID */
    public void setParamId(String paramId){
        this.paramId = paramId;
    }
    /** 参数 */
    public String getParamKey(){
        return this.paramKey;
    }
    /** 参数 */
    public void setParamKey(String paramKey){
        this.paramKey = paramKey;
    }
    /** 参数值 */
    public String getParamValue(){
        return this.paramValue;
    }
    /** 参数值 */
    public void setParamValue(String paramValue){
        this.paramValue = paramValue;
    }
}
