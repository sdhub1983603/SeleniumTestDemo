package autoMentionTest.java.test.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngDemo3 {
    @Test(dataProvider = "data")
    public void test1(String i1,String i2){
        System.out.println(Integer.valueOf(i1)+Integer.valueOf(i2));
    }
    //多个账号密码运行
    @DataProvider(name="data")
    public Object[][] test2(){
        return  new Object[][]{
                {"user1","123"},{"user2","123"},{"user3","123"}
        };
    }
}
