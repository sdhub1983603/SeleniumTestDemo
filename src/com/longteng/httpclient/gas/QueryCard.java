package com.longteng.httpclient.gas;

import com.sun.jndi.toolkit.url.Uri;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class QueryCard {
    public static void main(String[] args) throws URISyntaxException, IOException {
        //http://115.28.108.130.8080/longtengserver/LoginController/login
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet();
        URI uri = new URI("http://115.28.108.130.8080/longtengserver/gasStation/process");
        get.setURI(uri);

        CloseableHttpResponse res = client.execute(get);
        System.out.println(EntityUtils.toString(res.getEntity()));
    }
}
