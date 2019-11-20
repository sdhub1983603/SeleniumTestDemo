package com.longteng.httpclient.gas;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class BindCard {
    public static void main(String[] args)  {
        //创建一个客户端
        CloseableHttpClient client = HttpClients.createDefault();
        //http://115.28.108.130.8080/longtengserver/gasStation/process
        //https://www.imooc.com/search/hotwords
        //创建Post请求，指定请求地址
        HttpPost post = new HttpPost("http://115.28.108.130:8080/longtengserver/gasStation/process");
        //创建实体，String类型的实体
       // StringEntity requestEntity = new StringEntity();
        //把实体放到post请求里面
       // post.setEntity(requestEntity);
        CloseableHttpResponse response = null;
        try {
            response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
            String entity= EntityUtils.toString(response.getEntity());//把响应实体解析成字符串
            System.out.println(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
             if(response!=null){
                 try {
                     response.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }
    }
}
