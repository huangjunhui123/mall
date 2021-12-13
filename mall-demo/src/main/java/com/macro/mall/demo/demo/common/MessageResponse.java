package com.macro.mall.demo.demo.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * 响应结果内容
 * @author 黄俊辉
 */
public class MessageResponse<T> {

    public MessageResponse() {
    }

    public MessageResponse(int code) {
        this.code = code;
    }

    public MessageResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code = MessageCode.CODE_OK;
    private String msg = "success";
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void set(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> MessageResponse data(T data) {
        MessageResponse response = new MessageResponse();
        response.setData(data);
        return response;
    }
    /**
     * 获得响应的Json字符串
     * @return
     */
    public String toJSONString() {
        return JSONObject.toJSONString(this);
    }

    public static MessageResponse data() {
        MessageResponse response = new MessageResponse();
        response.setData(true);
        return response;
    }

    public static MessageResponse fail() {
        return fail(MessageCode.CODE_SYSTEM_ERROR, null, null);
    }

    public static MessageResponse fail(String message) {
        return fail(MessageCode.CODE_SYSTEM_ERROR, message, null);
    }

    public static MessageResponse fail(String message, Object data) {
        return fail(MessageCode.CODE_SYSTEM_ERROR, message, data);
    }

    public static MessageResponse fail(Integer code, String message, Object data) {
        if (StringUtils.isBlank(message)){
            message = "系统繁忙，请重试";
        }
        MessageResponse response = new MessageResponse(code, message);
        response.setData(data);
        return response;
    }

    public static MessageResponse fail(Integer code, String message) {
        if (StringUtils.isBlank(message)){
            message = "系统繁忙，请重试";
        }
        MessageResponse response = new MessageResponse(code, message);
        return response;
    }
}
