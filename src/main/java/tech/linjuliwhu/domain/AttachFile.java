package tech.linjuliwhu.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import tech.linjuliwhu.util.MyConstants;

public class AttachFile {
    /** 主键ID */
    @TableId
    private String fileId ;
    /** 文件类型 */
    private String fileType ;
    /** 链接地址 */
    private String fileUrl ;
    /** 链接类型;0语音;1答案附件 */
    private Integer linkType = MyConstants.FILE_LINK_TYPE_ANS_DOC;
    /** 链接ID */
    private String linkId ;

    /** 主键ID */
    public String getFileId(){
        return this.fileId;
    }
    /** 主键ID */
    public void setFileId(String fileId){
        this.fileId = fileId;
    }
    /** 文件类型 */
    public String getFileType(){
        return this.fileType;
    }
    /** 文件类型 */
    public void setFileType(String fileType){
        this.fileType = fileType;
    }
    /** 链接地址 */
    public String getFileUrl(){
        return this.fileUrl;
    }
    /** 链接地址 */
    public void setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
    }
    /** 链接类型;0语音;1答案附件 */
    public Integer getLinkType(){
        return this.linkType;
    }
    /** 链接类型;0语音;1答案附件 */
    public void setLinkType(Integer linkType){
        this.linkType = linkType;
    }
    /** 链接ID */
    public String getLinkId(){
        return this.linkId;
    }
    /** 链接ID */
    public void setLinkId(String linkId){
        this.linkId = linkId;
    }
}
