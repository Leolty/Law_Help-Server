package tech.linjuliwhu.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class MyConstants {
    // 基本返回
    public static final String RESULT_OK = "ok";
    public static final String RESULT_FAIL = "fail";

    //时间、数据格式
    private static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_DATE = "yyyy-MM-dd";
    private static final String FORMAT_TIME = "HH:mm:ss";

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(MyConstants.FORMAT_DATE);
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(MyConstants.FORMAT_TIME);
    public static final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat(MyConstants.FORMAT_DATETIME);

    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("00%");

    // 特殊意思的返回
    public static final String RESULT_INSERT_FAIL = "insertFail";
    public static final String RESULT_UPDATE_FAIL = "updateFail";
    public static final String RESULT_DELETE_FAIL = "deleteFail";
    public static final String RESULT_UNKNOWN_ERR = "未知错误";

    // 运维人员身份相关
    public static final int USER_TYPE_USER = 0; // 用户
    public static final int USER_TYPE_OPERATION = 1; // 运营
    public static final int USER_TYPE_OPERATION_ADMIN = 2; // 运营管理员
    public static final int USER_TYPE_DEV_ADMIN = 3; // 开发管理员

    // 问题选项是否有其他
    public static final int QUE_HAS_OTHER_TRUE = 1;
    public static final int QUE_HAS_OTHER_FALSE = 0;

    // 问题、答案在运营中是否已经失效
    public static final int QUE_IF_DELETE_TRUE = 1;
    public static final int QUE_IF_DELETE_FALSE = 0;

    // 附件类型
    public static final int FILE_LINK_TYPE_VOICE = 0;
    public static final int FILE_LINK_TYPE_ANS_DOC = 1;
    public static final int FILE_LINK_TYPE_ASK_IMAGE = 2;

    // QUE_ROOT_VERSION
    public static final int QUE_ROOT_TYPE_EXAM = 0;  // 审核版
    public static final int QUE_ROOT_TYPE_USE = 1;  // 上线版
    public static final int QUE_ROOT_TYPE_TEST = 2;  // 内部测试，未发布

    // QUE_ROOT_VERSION
    public static final int QUE_LEVEL_ROOT = 0;  // 根
    public static final int QUE_LEVEL_NODE = 1;  // 中间问题
    public static final int QUE_LEVEL_LEAF = 2;  // 最终答案问题

    // QUE_USER_ASK_STATUS
    public static final int QUE_ASK_STATUS_SUBMIT = 0;  // 提交待回复
    public static final int QUE_ASK_STATUS_COMPLETE = 1;  // 已回复
    public static final int QUE_ASK_STATUS_OTHER = 2;  // 回复不了

    // QUE_USER_ASK_VERSION
    public static final int QUE_ASK_TYPE_EXAM = 0;
    public static final int QUE_ASK_TYPE_USE = 1;

    // 用户是否已读回复
    public static final int QUE_ASK_USER_HAS_READ_FALSE = 0;
    public static final int QUE_ASK_USER_HAS_READ_TRUE = 1;

    // 回复以及用户提问的问题是否公开
    public static final int QUE_ASK_IS_PUBLIC_FALSE = 0;
    public static final int QUE_ASK_IS_PUBLIC_TRUE = 1;

    // param 相关
    public static final String MP_VERSION = "version";

    public static final String QUE_ROOT_DEFAULT_ICON = "roundcheckfill";
    public static final String QUE_ROOT_DEFAULT_COLOR = "blue";
}
