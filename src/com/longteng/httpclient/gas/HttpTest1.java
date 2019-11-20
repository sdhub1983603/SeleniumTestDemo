package com.longteng.httpclient.gas;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpTest1 {
    public static void main(String[] args) throws IOException {
//        NameValuePair username = new BasicNameValuePair("username","13641328110");
//        NameValuePair password = new BasicNameValuePair("password","sangdan63");
//
        CloseableHttpClient clients = HttpClients.createDefault();
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        params.add(new BasicNameValuePair("username","root"));
        params.add(new BasicNameValuePair("password","admin"));
        //实体类型
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, Consts.UTF_8);
        HttpPost post = new HttpPost("www.baidu.com");
        post.setEntity(entity);
        CloseableHttpResponse response =clients.execute(post);
    }
}
