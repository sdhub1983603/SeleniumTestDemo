package autoMentionTest.java.test.panel;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProUtil {
    public Properties pro;
    public ProUtil(String filePath) throws IOException {
         pro =  RedProptries(filePath);
    }

    public Properties RedProptries(String filePath) throws IOException {
        Properties properties = new Properties();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        properties.load(bis);
        return properties;
    }

    public String GetPro(String key){
        String value;
        if(pro.containsKey(key)){
            value=pro.getProperty(key);
            return value;
        }else{
            return null;
        }
    }
    public int GetLines(){
       return pro.size();  //获取配置文件中user的行数
    }
    public static void main(String[] args) throws IOException {
        ProUtil pu = new ProUtil("element.properties");
        System.out.println( pu.GetPro("username"));

    }
}
