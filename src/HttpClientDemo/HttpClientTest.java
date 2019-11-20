package HttpClientDemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class HttpClientTest {
    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get = new HttpGet("http://114.55.199.104:8080/#/");
        //这个是用来执行get方法的
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }
    @Test
    public void test2() throws IOException {
        String result;
        HttpPost httpPost=new HttpPost("https://www.imooc.com/");
        List<NameValuePair> list=new ArrayList<NameValuePair>();
        BasicNameValuePair bnv1=new BasicNameValuePair("username","13641328110");
        BasicNameValuePair bnv2=new BasicNameValuePair("password","sangdan63");
        list.add(bnv1);
        list.add(bnv2);

        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
        httpPost.setEntity(formEntity);

        HttpClient client=new DefaultHttpClient();
        HttpResponse response = client.execute(httpPost);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }
}
