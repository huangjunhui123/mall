package com.macro.mall.demo.demo.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by shkstart on 2020/4/16 0016.
 *
 * @author panhong.
 * @time 2020/4/16 0016.
 */
public class OkHttpUtils {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * 模拟http get请求
     * @param url url路径
     * @return
     * @throws IOException
     */
    public static JSONObject doGet(String url) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return JSONObject.parseObject(response.body().string());
    }

    /**
     * 模拟http post请求
     * @param url url路径
     * @param json post提交参数
     * @return
     * @throws IOException
     */
    public static JSONObject doPost(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        return JSONObject.parseObject(response.body().string());
    }


    /**
     * 模拟http post请求
     * @param url url路径
     * @param json post提交参数
     * @return
     * @throws IOException
     */
    public static JSONObject doPost(String url, String json, Map<String,String> params) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, json);

        // 封装请求头参数
        Request.Builder builder = new Request.Builder();
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            Iterator<String> it = keys.iterator();
            for (; it.hasNext(); ) {
                String key = it.next();
                String val = params.get(key);
                builder.addHeader(key,val);
            }
        }

        Request request = builder
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        return JSONObject.parseObject(response.body().string());
    }

    /**
     * 模拟http post请求
     * @param url url路径
     * @param json post提交参数
     * @return
     * @throws IOException
     */
    public static String doPostHeader(String url, String json,Map<String,String> reqHeader) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, json);

        // 封装请求头参数
        Request.Builder builder = new Request.Builder();
        if (reqHeader != null && reqHeader.size() > 0) {
            Set<String> keys = reqHeader.keySet();
            Iterator<String> it = keys.iterator();
            for (; it.hasNext(); ) {
                String key = it.next();
                String val = reqHeader.get(key);
                builder.addHeader(key,val);
            }
        }

        Request request = builder
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();

        Headers headers = response.headers();
        String token = headers.get("X-Subject-Token");

        return token;
        //return JSONObject.parseObject(token);
    }
}
