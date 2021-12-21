package com.macro.mall.demo.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 黄俊辉
 */
public class RegexTest {

    public static void main(String[] args) {
        String sb = "共计4个账号，10场视频监测，违法违规账号1个，违法视频1场";
        System.out.println("分析结果为：" + number(sb));
    }

    public static String number(String str) {
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = null;
        m = p.matcher(str);
        do {
            if (m.find()) {
                String sb = m.group(0);
                return sb;
            } else {
                break;
            }
        } while (true);
        return str;
    }

}

//    public static String setNumberFontColor(String str, HSSFRichTextString ob, Font font){
//        // 控制正则表达式的匹配行为的参数(小数)
//        Pattern p = Pattern.compile("(\\d+)");
//        Matcher m = null;
//        int index = 0;
//        int coordinate = 0;
//        do {
//            m = p.matcher(str);
//            if (m.find()) {
//                index = str.indexOf(m.group(0));
//                if(index != -1){
//                    ob.applyFont(index + coordinate, index + m.group().length() + coordinate,font);
//                    index++;
//                    coordinate += index + m.group(0).length();
//                    if (index + m.group().length() >= str.length()){
//                        break;
//                    }
//                    str = str.substring(index + m.group().length());
//                }else{
//                    break;
//                }
//            } else {
//                break;
//            }
//        }while (true);
//        return str;
//    }
