package com.logteng.httpclient;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class QueryPage {
    public static void main(String[] args) {

        CloseableHttpClient httpClient = HttpClients.createDefault();//创建httpClient,等于创建了一个客户端
        HttpGet getMethod = new HttpGet("https://www.imooc.com/");//创建ge请求，指定了请求的服务器地址
        try {
            CloseableHttpResponse response = httpClient.execute(getMethod); //执行请求，获取响应
            System.out.println(response.getStatusLine());//获取状态行
            System.out.println(response.getStatusLine().getStatusCode());//获取状态行里响应码
            Header[] headers = response.getAllHeaders();//获取请求头里的所有信息
            for(int i=0;i<headers.length;i++){
                System.out.println(headers[i]);
            }
            System.out.println("===============================================");
            System.out.println(response.getFirstHeader("Content-Type"));
            System.out.println("===============================================");
            System.out.println(response.getFirstHeader("Content-Type").getValue());
            System.out.println("===============================================");
            Header header1 = new BasicHeader("Server","Server1");
            Header header2 = new BasicHeader("Server","Server2");
            Header header3 = new BasicHeader("Server","Server3");

            response.addHeader(header1);//添加头信息
            response.addHeader(header2);
            response.addHeader(header3);
            response.setHeader(header1);//更新添加头信息，name不会重复
            System.out.println("===============================================");
            Header[] headers3=response.getHeaders("Server");
            for(int i=0;i<headers3.length;i++){
                System.out.println(headers3[i]);
            }
            HeaderIterator iterator = response.headerIterator("Server");
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }

            HttpEntity entity =  response.getEntity();//取得响应体
            String html = EntityUtils.toString(entity,"utf-8");//把响应实体转成string类型
            //System.out.println(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
