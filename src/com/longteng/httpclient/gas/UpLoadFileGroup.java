package com.longteng.httpclient.gas;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class UpLoadFileGroup {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://www.imooc.com");
        CloseableHttpResponse response=null;

        NameValuePair username = new BasicNameValuePair("username","13641328110");
        NameValuePair password = new BasicNameValuePair("password","sangdan63");

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(username);
        params.add(password);

        String resString = null;
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
            post.setEntity(entity);
            try {
                response = client.execute(post);
                //获取到json格式的参数
                 resString = EntityUtils.toString(response.getEntity(),"utf-8");
                System.out.println(resString);
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
        //json解析
        JSONObject json = new JSONObject(resString);
        System.out.println(json.get("token"));
        System.out.println(json.get("code"));

        String token = (String) json.get("token");




        CloseableHttpClient client2 = HttpClients.createDefault();
        CloseableHttpResponse res2 = null;
        HttpPost post2 = new HttpPost("http://www.imooc.com"+token);//把token拼接到url
        String filePath="D:\\ll.txt";//文件路径
        //文件上传实体
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("file",new StringBody("filePath", ContentType.MULTIPART_FORM_DATA));//文件名称
        builder.addPart("file",new FileBody(new File(filePath))); //加入文件
        //把实体放到post里
        post2.setEntity(builder.build());
        try {
            res2 = client.execute(post);
            System.out.println(EntityUtils.toString(res2.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(res2!=null){
                try {
                    res2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
