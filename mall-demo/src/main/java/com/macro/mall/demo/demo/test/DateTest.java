package com.macro.mall.demo.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄俊辉
 */

@Slf4j
public class DateTest {

    public static void main(String[] args) {
        String date = "00:02:12";
        System.out.println(date(date));
    }

    public static String date(String date){
        StringBuilder dateOne = new StringBuilder();
        StringBuilder dateTow = new StringBuilder();
        StringBuilder dateThree = new StringBuilder();

        String[] arr = date.split(":");
        dateOne.append(arr[0]).append(":").append(arr[1]).append("'").append(arr[2]).append("\"");
        String str = Integer.valueOf(arr[0]) >= 10 ? arr[0] : String.valueOf(Integer.valueOf(arr[0]) % 10);
        String str1 = Integer.valueOf(arr[1]) >= 10 ? arr[1] : String.valueOf(Integer.valueOf(arr[1]) % 10);
        String str2 = Integer.valueOf(arr[2]) >= 10 ? arr[2] : String.valueOf(Integer.valueOf(arr[2]) % 10);

        List<String> list = new ArrayList<>();
        for(String sb : date.split(":")) {
            String sbs = Integer.valueOf(sb) >= 10 ? sb : String.valueOf(Integer.valueOf(sb) % 10);
            list.add(sbs);
        }
        dateTow.append(list.get(0)).append(":").append(list.get(1)).append("'").append(list.get(2)).append("\"");
        dateThree.append(list.get(0)).append("时").append(list.get(1)).append("分").append(list.get(2)).append("秒");
        return dateThree.toString();
    }

}
