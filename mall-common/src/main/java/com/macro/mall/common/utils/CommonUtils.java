package com.macro.mall.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用工具类
 *
 * @author panhong.
 * @time 2020/4/14 0014.
 */
public class CommonUtils {

    private static Pattern MOBILE_PATTERN = Pattern.compile("^1(3|4|5|7|8|9)\\d{9}$");

    private static Pattern NATURAL_NUMBER_PATTERN = Pattern.compile("/^[1-9]+\\d*$");

    private static Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public static boolean isEmpty(String str) {
        if (null == str || "".equals(str)) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isOneEmpty(String one, String two) {
        if (isEmpty(one) || isEmpty(two)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证字符串是否手机号码
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        boolean ret = false;
        if (!isEmpty(str) && str.length() == 11) {
            Matcher m = MOBILE_PATTERN.matcher(str);
            ret = m.find();
        }
        return ret;
    }

    public static String md5Low(String str) {
        if (isEmpty(str)) {
            return "";
        }
        return DigestUtils.md5Hex(str).toLowerCase();
    }


    public static String makeRandomStr(String str, int len) {
        StringBuffer sb = new StringBuffer();
        if (!isEmpty(str)) {
            Random r = new Random();
            char[] ch = str.toCharArray();
            int index, chLen = ch.length;
            for (int i = 0; i < len; i++) {
                index = r.nextInt(chLen);
                sb.append(ch[index]);
            }
        }
        return sb.toString();
    }

    public static boolean isNaturalNumber(String str) {
        Matcher m = NATURAL_NUMBER_PATTERN.matcher(str);
        return m.find();
    }

    public static boolean isNumber(String str) {
        Matcher m = NUMBER_PATTERN.matcher(str);
        return m.find();
    }

    /**
     * 将分为单位的价格转成元,保留两位小数
     *
     * @param fen 以分为单位的数值
     */
    public static String convertFenToYuan(Integer fen) {
        if (fen != null) {
            return new DecimalFormat("#0.00").format(0.01 * fen);
        }
        else {
            return null;
        }
    }

    /**
     * 元转分
     *
     * @param yuan 元
     */
    public static int convertYuanToFen(String yuan) {
        if (StringUtils.isBlank(yuan)) {
            return 0;
        }
        BigDecimal de = new BigDecimal(yuan);
        return de.multiply(BigDecimal.valueOf(100)).intValue();
    }

    /**
     * 生成uuid
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }

}
