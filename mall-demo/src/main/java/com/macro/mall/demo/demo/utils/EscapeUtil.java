package com.macro.mall.demo.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @Author gaohao
 * @Date 2020/5/11 17:10
 */
public class EscapeUtil {

    public static String escapeChar(String before){
        if(StringUtils.isNotBlank(before)){
            before = before.replaceAll("\\\\", "\\\\\\\\");
            before = before.replaceAll("_", "\\\\_");
            before = before.replaceAll("%", "\\\\%");
            before = before.replaceAll("　", "\\\\　");
        }
        return before ;
    }

    public static String trim(String s){
        String result = "";
        if(null!=s && !"".equals(s)){
            result = s.replaceAll("[\\u00A0]+", "").trim();
        }
        return result;
    }

    /**
     * 手机号脱敏
     * @param mobile
     * @return
     */
    public static String mobileEncrypt(String mobile){
        if(StringUtils.isEmpty(mobile) || (trim(mobile).length() < 7)){
            return mobile;
        }
        if (trim(mobile).length() < 10) {
            return trim(mobile).replaceAll("(.{2}).*(.{3})","$1****$2");
        }
        return trim(mobile).replaceAll("(.{3}).*(.{4})","$1****$2");
    }

    /**
     * 身份证脱敏
     * @param id
     * @return
     */
    public static String idEncrypt(String id){
        if(StringUtils.isEmpty(id) || (trim(id).length() != 18)){
            return id;
        }
        return trim(id).replaceAll("(?<=\\w{6})\\w(?=\\w{4})", "*");
    }

    /**
     * 验证手机号
     * @param mobile
     * @return
     */
    public static Boolean verifyMobile(String mobile){
        if (StringUtils.isBlank(mobile) || !Pattern.matches("^[1][3456789][0-9]{9}$", mobile)) {
            return false;
        }
        return true;
    }
}
