package autoMentionTest.java.test.testng;

import org.testng.annotations.*;

public class TestngDemo2 {
    @Test
    public void test1(){
        System.out.println("testNG1");
    }
    @Test
    public void test2(){
        System.out.println("tesgNG2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite");
    }
    //数据驱动的方式
    @Test(dataProvider = "data")
    public void test3(String i1,String i2){
        System.out.println(Integer.valueOf(i1)+Integer.valueOf(i2));
    }
   //dataprovider是数据提供者
    @DataProvider(name ="data")
    public String[][] data(){
        String [][] s={{"10","15"},{"22","23"},{"200","300"}};
        return s;
    }
}
