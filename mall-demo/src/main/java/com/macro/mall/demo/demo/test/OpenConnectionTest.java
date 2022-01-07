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

}
