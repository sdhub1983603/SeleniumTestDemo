package com.logteng.httpclient;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicHeader;

public class HeaderTest {
    public static void main(String[] args) {
        Header header1 = new BasicHeader("Server","Server1");
        Header header2 = new BasicHeader("Server","Server2");
        Header header3 = new BasicHeader("Server","Server3");

        Header[] headers = {header1,header2,header3};

    }
}
