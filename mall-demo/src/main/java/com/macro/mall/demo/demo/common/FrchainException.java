package com.macro.mall.demo.demo.common;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

/**
 * 通用异常处理
 * @author 黄俊辉
 */
public class FrchainException extends RuntimeException {

    private MessageResponse response;

    public FrchainException(Integer code, String msg) {
        super(msg);
        response = new MessageResponse();
        response.setCode(code);
        response.setMsg(msg);
    }

    public FrchainException(String msg) {
        super(msg);
        response = new MessageResponse();
        response.setCode(MessageCode.CODE_SYSTEM_ERROR);
        response.setMsg(msg);
    }

    public FrchainException(Integer code, String msg, Object obj) {
        super(msg);
        response = new MessageResponse();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(obj);
    }

    public FrchainException() {
        response = new MessageResponse();
        response.setCode(MessageCode.CODE_SYSTEM_ERROR);
        response.setMsg("服务器异常");
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new FrchainException(message);
        }
    }

    public static void isNull(@Nullable Object object, String message) {
        if (object != null) {
            throw new FrchainException(message);
        }
    }

    public static void notNull(@Nullable Object object, String message) {
        if (object == null) {
            throw new FrchainException(message);
        }
    }

    public static void hasText(@Nullable String text, String message) {
        if (!StringUtils.hasText(text)) {
            throw new FrchainException(message);
        }
    }

    public MessageResponse getResponse() {
        return response;
    }

    public void setResponse(MessageResponse response) {
        this.response = response;
    }
}
