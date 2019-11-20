package autoMentionTest.java.test.panel;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class LtSelenium {
    public WebDriver driver;
    private  String loginElement="//a[@id='js-signin-btn']";
    private  String loginBtn="//input[@class='moco-btn moco-btn-red moco-btn-lg btn-full xa-login']" ;

//    public LtSelenium(WebDriver driver) {
//        this.driver = driver;
//    }

    public static void main(String[] args) {
        LtSelenium ls = new LtSelenium();
        ls.initDriver();
        ls.login();
    }
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("http://demo.guru99.com/test/newtours/register.php ");
        driver.get("http://www.imooc.com ");

    }
    public void login(){
        initDriver();
//        String present=driver.getWindowHandle();
//        Set<String> handles=driver.getWindowHandles();
//        for(String handle:handles){
//            if(!handle.equals(present)){
//                driver.switchTo().window(handle);
//            }
//        }
        WebElement loginElementBtn=driver.findElement(By.xpath(loginElement));
        loginElementBtn.click();
        WebElement inputUserName=driver.findElement(By.name("email"));
        inputUserName.sendKeys("13641328110");
        WebElement inputPassWord=driver.findElement(By.name("password"));
        inputPassWord.sendKeys("sangdan63");
        WebElement clickLoginBtn=driver.findElement(By.xpath(loginBtn));
        clickLoginBtn.click();
    }
    public void selectDemo(){
        Select select = new Select(driver.findElement(By.name("country")));
        //select.selectByVisibleText("ANTARCTICA");
        List<WebElement> options= driver.findElements(By.tagName("option"));
        for(WebElement option:options){
            System.out.println(option.getText());
        }
    }
    public void alertDemo() throws InterruptedException {
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).submit();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(3000);
        alert.accept();
    }

    public void selectDemo2(){

    }
    public void upLoadFile(){
        driver.get("https://www.imooc.com/user/setbindsns");
        WebElement headPng=driver.findElement(By.className("avator-mode"));
        Actions actions = new Actions(driver);
        actions.moveToElement(headPng).perform();
    }
    public void mouseAction(){
        driver.get("https://www.imooc.com");
        WebElement loginBtn = driver.findElement(By.id("js-signin-btn"));
        Actions actions = new Actions(driver);
        actions.click(loginBtn).perform();
        List<WebElement> menuElementList=driver.findElements(By.className("item"));
        WebElement mobileElement=menuElementList.get(1);
        actions.moveToElement(mobileElement).perform();
        driver.findElement(By.linkText("小程序")).click();
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.close();
    }
}
