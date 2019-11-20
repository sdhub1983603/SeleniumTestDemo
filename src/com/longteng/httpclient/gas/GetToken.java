package com.longteng.httpclient.gas;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GetToken {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://www.imooc.com");
        CloseableHttpResponse response=null;

        NameValuePair username = new BasicNameValuePair("username","13641328110");
        NameValuePair password = new BasicNameValuePair("password","sangdan63");

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(username);
        params.add(password);

        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
            post.setEntity(entity);
            try {
                response = client.execute(post);
                System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
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
