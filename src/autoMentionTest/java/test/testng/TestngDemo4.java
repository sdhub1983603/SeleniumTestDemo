package autoMentionTest.java.test.testng;

import com.longteng.httpclient.gas.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDemo4 {
    public WebDriver driver;

    @DataProvider(name="loginUser")
    public Object[][]data(){
        return new Object[][]{
                {"user1","pwd1"},
                {"user2","pwd2"},
                {"user3","pwd3"} };
    }
    @Test(dataProvider = "loginUser")
    public void loginTest(String user,String pwd){
        System.out.println(user+pwd);
    }
    @Test(dataProvider = "loginUser")
    public void loginSuccess(String username,String pwd){
        TestngDemo4.login(driver,username,pwd);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String logout=driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(logout,"退出");

    }
    @Test(dataProvider = "loginUser")
    public void loginError(String username,String pwd){
        TestngDemo4.login(driver,username,pwd);
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("密码错误")));
        String logout=driver.findElement(By.linkText("密码错误")).getText();
        Assert.assertEquals(logout,"密码错误");
    }
    public static void login(WebDriver driver,String user,String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(user);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
    @Test()
    public void sendEmail(){
        TestngDemo4.login(driver,"aa","12");
        driver.findElement(By.xpath(".//*[@aria-label='邮件主体输入框，请输入邮件']/input")).sendKeys("啦啦啦");
        driver.findElement(By.xpath(".//*[@title='换一次可发送200张图片']/input")).sendKeys("嘟嘟嘟");
        WebElement ifame = driver.findElement(By.className("APP-editor-iframe"));
        //转交控制权
        driver.switchTo().frame(ifame);
        driver.findElement(By.xpath("/html/body")).sendKeys("快点快点快点");
        //转交控制权
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//[text()='发送']")).click();
        //判断页面是否有“发送成功”字样的展示
        Boolean a = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(a);

    }
}
