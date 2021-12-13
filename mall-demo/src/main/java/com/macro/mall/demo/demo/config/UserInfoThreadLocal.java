package com.macro.mall.demo.demo.config;

import com.macro.mall.demo.demo.bo.ConsumerInfoResVo;

/**
 * @author 黄俊辉
 */
public class UserInfoThreadLocal {

    private static final ThreadLocal<ConsumerInfoResVo> userInfo = new ThreadLocal<>();

    public static void clean() {userInfo.remove();}

    public static void set(ConsumerInfoResVo userResVo) {userInfo.set(userResVo);}

    public static ConsumerInfoResVo get() {return userInfo.get();}
}
