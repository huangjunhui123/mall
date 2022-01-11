package com.macro.mall.demo.demo.test;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 黄俊辉
 */
@Slf4j
public class OpenConnectionTest {

    public static void main(String[] args) {
        String url = "http://www.baidu.com/index.html";
        String url1 = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=";
        try {
            System.out.println("=============================== 使用openStream()方法 ===============================");
            openStream(url1);
            System.out.println("=============================== 使用openConnection()方法 ===============================");
            openConnection(url1);
        } catch (Exception e) {
            System.err.println("URL协议、格式或者路径错误！");
        }
    }

    public static void openStream(String url1) throws Exception {
        URL url = new URL(url1);
        // 使用openStream()方法
        BufferedReader get = new BufferedReader(new InputStreamReader(url.openStream()));
        String sb;
        while ((sb = get.readLine()) != null) {
            // 按行读取输出到控制台
            System.out.println(sb);
        }
        System.out.println();
    }

    public static void openConnection(String url1) throws Exception {
        URL url = new URL(url1);
        // 使用openConnection()方法
        URLConnection conn = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String sb;
        while ((sb = in.readLine()) != null) {
            // 按行读取输出到控制台
            System.out.println(sb);
        }
    }
    // 1700 + 1300 总共 3000  按每月盈利5%计算，需要和本金60000*2 = 120000
    // 预计一年累计91000不等，大概在2022年完成120000资金，也就是从2023年开始实施计划
    // 2023年开始计划大概在2025年结束后资金为500000，这时我的年龄26
    // 在用2到3年几计划结束剩下的500000计划，在30岁来临钱完成1000000计划
    // 在30岁后年薪期望在200000左右，这样可以在4到5年内还完房贷，自此我的青春也就结束了。

}
