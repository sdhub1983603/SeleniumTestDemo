package com.longteng.httpclient.gas;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

public class UploadTest3 {
    public static void main(String[] args) {
        //从Postman里拿到cookie设置到客户端里
        CookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID","23232323fdfdfdf232fdf");
        cookie.setDomain("");
        cookieStore.addCookie(cookie);
    }
}
