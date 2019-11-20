package com.longteng.httpclient.gas;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        String s = "{\n" +
                "                \"dataSourceId\":\"df7fd8fd87f8df\",\n" +
                "                \"methodId\":\"012A\",\n" +
                "                \"cardUser\":{\n" +
                "            \"username\":\"longteng\",\n" +
                "                    \"idType\":\"ll\",\n" +
                "                    \"idNumber\":\"longtengtest\"\n" +
                "        },\n" +
                "        \"cardInfo\":{\n" +
                "            \"cardNumber\":\"3232afdf343\"\n" +
                "        }\n" +
                "}";

//        JSONObject json2 = new JSONObject(s);
//        JSONObject carduser=(JSONObject)json2.get("cardUser");
//        System.out.println(carduser.get("username"));
        //定位层级的json
        JSONObject json3 = new JSONObject(s);
        JSONObject cardinfo = (JSONObject) json3.get("cardInfo");
        System.out.println(cardinfo.get("cardNumber"));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataSourceId", "df7fd8fd87f8df");
        map.put("methodId", "012A");
        //map转成json格式
        String o = JSONObject.valueToString(map);
        System.out.println(o);
        System.out.println("===================================");
        json2();
    }
        public static void json2() {
            String s2 ="{\n" +
                    "\"code\":200,\n" +
                    "\"msg\":\"成功返回\",\n" +
                    "\"result\":{\n" +
                    "\"cardBalance\":\"20123\",\n" +
                    "\"cardNumber\":\"fd323dd\",\n" +
                    "\"cardStatus\":\"已经被绑定，正常使用中\",\n" +
                    "\"consumptionDetails\":[\n" +
                    "\"消费金额:100,时间:2019-10-26 18:12:12\"\n" +
                    "],\n" +
                    "\"rechargeDetails\":[\n" +
                    "\"充值金额:200,时间:2019-10-27 22:45:23\",\n" +
                    "\"充值金额:300,时间:2019-09-13 08:45:23\",\n" +
                    "\"充值金额:400,时间:2019-08-06 16:45:23\"\n" +
                    "]\n" +
                    "},\n" +
                    "\"succcess\":true\n" +
                    "}";
            //取json数组的值
        JSONObject json4 = new JSONObject(s2);
        JSONObject result = json4.getJSONObject("result");
        String n=result.getString("cardNumber");
            System.out.println(n);
            JSONArray rechargeDetails = result.getJSONArray("rechargeDetails");
            for(int i=0;i<rechargeDetails.length();i++){
                System.out.println(rechargeDetails.get(i));
            }
            //把数组变成json字符串
            List list = new ArrayList();
            list.add("1");
            list.add("2");
            list.add("3");
            JSONArray ary = new JSONArray(list);
            System.out.println(ary.toString());
        }
    }
