package autoMentionTest.java.test.panel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class SeleniumMaven {
    public WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void initDriver() throws InterruptedException {
        driver.get("https://www.imooc.com/");
        sleep(3000);
        driver.navigate().refresh();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.imooc.com/");

    }

    public void userLogin() throws IOException, InterruptedException {
        ProUtil pro = new ProUtil("user.properties");
        String user=null;
        String userName;
        String passWord;
        int lines = pro.GetLines();
        for(int i=0;i<lines;i++){
            openChrome();
            initDriver();
            WebElement submit = driver.findElement(By.id("//a[@id='js-signin-btn']"));
            submit.click();
             user = pro.GetPro("user"+i);
            userName = user.split(">")[0];
            passWord = user.split(">")[1];
            WebElement emailElement = GetElement("userName");
            WebElement passWordElement = GetElement("passWord");
            WebElement loginButtonElement = GetElement("loginbutton");
            emailElement.sendKeys(userName);
            passWordElement.sendKeys(passWord);
            loginButtonElement.click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Actions ac = new Actions(driver);
                WebElement userPng = GetElement("headpng");
                ac.moveToElement(userPng).perform();
                String userNameInfo = GetElement("userinfo").getText();
                if (userName.equals("13641328110")) {
                    System.out.println("登录成功");
                } else {
                    System.out.println("用户信息不匹配"+userName);
                }
            }catch(Exception e){
                System.out.println("登录失败");
            }
        }
    }

    public By GetByLocal(String key) throws IOException {
        ProUtil proUtil = new ProUtil("element.properties");
        String locator = proUtil.GetPro(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        if(locatorBy.equals("id")){
            return By.id(locatorValue);
        }else if(locatorBy.equals("name")){
            return By.name(locatorValue);
        }else if(locatorBy.equals("className")){
            return  By.className(locatorValue);
        }else{
            return By.xpath(locatorValue);
        }
    }

    public WebElement GetElement(String key) throws IOException {
        WebElement element = driver.findElement(this.GetByLocal(key));
        return element;
    }
    public void GetLocal(String key) throws IOException {

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        SeleniumMaven sm=new SeleniumMaven();
        sm.userLogin();
    }
}
