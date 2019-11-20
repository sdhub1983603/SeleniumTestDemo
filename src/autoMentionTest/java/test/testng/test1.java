package autoMentionTest.java.test.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class test1 {
    public  WebDriver driver;
    public  void st1() {
       driver.get("");
       WebElement el1 = driver.findElement(By.id("drag"));
        WebElement el2 = driver.findElement(By.id("drag1"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(el1).moveToElement(el2).release(el1).perform();
    }
    public void st2(){
        driver.get("");
        WebElement select = driver.findElement(By.id("selectWith"));
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultiple\"]"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        actions.keyDown(Keys.CONTROL).click(list.get(0)).click(list.get(2)).keyUp(Keys.CONTROL).perform();

    }

    public void st3(){
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        //设置火狐的默认下载文件夹，0表示桌面  1表示我的下载  2表示自定义文件夹
        firefoxProfile.setPreference("browser.download.folderList","2");
        //设置自定义文件夹位置
        firefoxProfile.setPreference("browser.download.dir","D:\\oft");
        //设置无需确认下周的文件格式
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream,application/vnd.ms-excel,text-csv,application/zip,application/exe");
        WebDriver driver = new FirefoxDriver((Capabilities) firefoxProfile);
        driver.get("");


    }
}
