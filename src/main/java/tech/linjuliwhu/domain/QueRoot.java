package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import tech.linjuliwhu.util.MyConstants;

public class QueRoot {
    /** 主键ID */
    @TableId
    private String queRootId ;
    /** 图标样式 */
    private String rootIcon = MyConstants.QUE_ROOT_DEFAULT_ICON;
    /** 图表颜色 */
    private String rootColor = MyConstants.QUE_ROOT_DEFAULT_COLOR;
    /** 类别名称 */
    private String rootName ;
    /** 版本;0审核，1上线版，2测试版 */
    private Integer rootVersion = MyConstants.QUE_ROOT_TYPE_TEST;

    /** 主键ID */
    public String getQueRootId(){
        return this.queRootId;
    }
    /** 主键ID */
    public void setQueRootId(String queRootId){
        this.queRootId = queRootId;
    }
    /** 图标样式 */
    public String getRootIcon(){
        return this.rootIcon;
    }
    /** 图标样式 */
    public void setRootIcon(String rootIcon){
        this.rootIcon = rootIcon;
    }
    /** 图表颜色 */
    public String getRootColor(){
        return this.rootColor;
    }
    /** 图表颜色 */
    public void setRootColor(String rootColor){
        this.rootColor = rootColor;
    }
    /** 类别名称 */
    public String getRootName(){
        return this.rootName;
    }
    /** 类别名称 */
    public void setRootName(String rootName){
        this.rootName = rootName;
    }
    /** 版本;0审核，1上线版，2测试版 */
    public Integer getRootVersion(){
        return this.rootVersion;
    }
    /** 版本;0审核，1上线版，2测试版 */
    public void setRootVersion(Integer rootVersion){
        this.rootVersion = rootVersion;
    }
}
