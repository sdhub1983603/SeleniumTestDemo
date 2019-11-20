package com.longteng.httpclient.gas;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

public class UpoldTest1 {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse res = null;
        HttpPost post = new HttpPost("http://www.imooc.com");
        String filePath="D:\\ll.txt";//文件路径
        //文件上传实体
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("file",new StringBody("filePath", ContentType.MULTIPART_FORM_DATA));//文件名称
        builder.addPart("file",new FileBody(new File(filePath))); //加入文件
        //把实体放到post里
        post.setEntity(builder.build());
        try {
            res = client.execute(post);
            System.out.println(EntityUtils.toString(res.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(res!=null){
                try {
                    res.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
