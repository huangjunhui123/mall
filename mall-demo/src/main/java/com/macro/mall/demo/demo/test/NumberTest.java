package com.macro.mall.demo.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 黄俊辉
 */
@Slf4j
public class NumberTest {

    public static void main(String[] args) {
        String sb = "132.2w";
        System.out.println(numberTrans(sb));
    }


    public static Integer numberTrans(String number) {
        Integer abb = null;
        if(StringUtils.isNotBlank(number)) {
            String str = number.substring(number.length() - 1);
            String sb = number.substring(0,number.length() - 1);
            System.out.println(sb);
            if (str.equals("w")) {
//                abb = (double)Double.valueOf(sb) * 10000;
            } else {

            }
        }
        return abb;
    }

}
