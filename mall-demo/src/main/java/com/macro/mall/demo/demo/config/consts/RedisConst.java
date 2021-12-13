package com.macro.mall.demo.demo.config.consts;

/**
 * @author 黄俊辉
 */
public interface RedisConst {

    /** 用户登陆缓存前缀 */
    String USER_LOGIN = "logon:user-";

    /** 登录token有效期前缀 */
    Integer USER_TOKEN_TIME = 2;
}
