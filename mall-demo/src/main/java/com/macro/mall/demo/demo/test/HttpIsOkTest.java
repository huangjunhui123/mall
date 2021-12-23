package com.macro.mall.demo.demo.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URL;

/**
 * @author 黄俊辉
 */
@Slf4j
public class HttpIsOkTest {

    private static final String URL = "127.0.0.1";

    public static void main(String[] args) {
        isOk(URL);
    }

    private static boolean isOk(String url) {
        if(StringUtils.isEmpty(url)) {
            return false;
        }
        try {
            URL netUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) netUrl.openConnection();
            connection.setConnectTimeout(3000); //连接主机超时时间ms
            connection.setReadTimeout(3000); //从主机读取数据超时时间ms
            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println("网络联通！");
                return true;
            }
        } catch (IOException e) {
            log.error("连接不通", e.getMessage());
            return false;
        }
        return false;
    }
}
