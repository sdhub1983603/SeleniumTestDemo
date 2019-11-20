package com.longteng.httpclient.gas;

import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CookieTest {
    public static void main(String[] args) {
        //设置cookie
        CookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID","212kj21jk21j4j32k3j2k3jk2");
        cookie.setDomain("115.28.108.130");
        cookieStore.addCookie(cookie);

        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        HttpPost post = new HttpPost("http://114.55.199.104:7991/login");

        NameValuePair username=new BasicNameValuePair("username","root");
        NameValuePair  password=new BasicNameValuePair("password","admin");
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(username);
        list.add(password);
        try {
            //建立表单实体,把list放到表单中
            UrlEncodedFormEntity form = new UrlEncodedFormEntity(list);
            post.setEntity(form);
            CloseableHttpResponse response = client.execute(post);
            System.out.println(EntityUtils.toString(response.getEntity()));
            List<Cookie> cookies = cookieStore.getCookies();
            for(Cookie cookie1:cookies){
                System.out.println(cookie1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
