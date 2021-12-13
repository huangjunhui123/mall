package com.macro.mall.demo.demo.common;

/**
 * 消息响应结果码
 * @author 黄俊辉
 */
public class MessageCode {

    // 消息响应结果码
    public static final int CODE_OK = 200; 			       // 响应成功
    public static final int CODE_ERROR_PARAM = 512;        // 请求参数错误
    public static final int CODE_ERROR_FORBBIDEN = 406;    // 请求阻止
    public static final int CODE_ERROR_NO_RESOURCE = 404;  // 资源不存在
    public static final int CODE_SERVER_ERROR = 501; 	    // 业务异常-前端显示
    public static final int CODE_SYSTEM_ERROR = 500; 	    // 非业务异常-前端显示默认信息

    // 业务响应码
    public static final int CODE_UNLOGIN = 10000;          // 未登录
    // 前端参数传入错误
    public static final int ERROR_PARAM = 600;          // 参数错误

    public static final int CODE_EXPIRED_CODE = 5001;        // 验证码失效
    public static final int FILE_NOT_EXIST = 5002;        // 文件不存在
    public static final int KEY_WORD_REPEAT = 5003;        // 已报名

}
