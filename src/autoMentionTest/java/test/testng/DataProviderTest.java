package autoMentionTest.java.test.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name="+name+"; age="+age);
    }
    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"jordan",23},
                {"iverson",3},
                {"kobe",8}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test111方法 name="+name+"; age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test222方法 name="+name+"; age="+age);
    }
    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result= null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"messi",10},
                    {"ronaldo",7}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
            {"zidane",10},
            {"riquelme",8}
            };
        }
        return result;
    }
}
