package com.longteng.httpclient.gas;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    public static void main(String[] args) {
        //提交表单,普通创建一个客户端
       // CloseableHttpClient client= HttpClients.createDefault();
        //创建带cookie的客户端
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost post = new HttpPost("http://114.55.199.104:7991/login");
        CloseableHttpResponse response = null;

        //表单内容用户名
        NameValuePair username=new BasicNameValuePair("userName","root");
        //表单内容密码
        NameValuePair password=new BasicNameValuePair("password","admin");
        //把表单内容放到list里
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(username);
        params.add(password);
        //提交表单的实体UrlEncodedFormEntity

        try {
            //建立表单实体，放入参数List
            UrlEncodedFormEntity uef = new UrlEncodedFormEntity(params);
            //把实体放入请求中
             post.setEntity(uef);
             response = client.execute(post);
             System.out.println(EntityUtils.toString(response.getEntity()));
             List<Cookie>cookies=cookieStore.getCookies();
             for(Cookie cookie:cookies){
                 System.out.println(cookie);
             }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
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
