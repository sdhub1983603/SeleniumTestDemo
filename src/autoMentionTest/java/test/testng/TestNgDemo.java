package autoMentionTest.java.test.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNgDemo {
    WebDriver driver;
    WebElement element;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
        driver=new ChromeDriver();
    }
    @Test
    public void assertNotEquale(){
        String a="aaa";
        String b="bbb";
        Assert.assertEquals(a,b,"a不等于b");
    }
    //java剪切板
    public void UpFile() throws AWTException {
        StringSelection stringSelection=new StringSelection("");
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        sysc.setContents(stringSelection,null);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.close();
    }
    public void AutoUpFile() throws AWTException {
        driver.get("https://www.imooc,com");
        WebElement headPng = driver.findElement(By.className("avator-mode"));
        Actions actions = new Actions(driver);
        actions.moveToElement(headPng).perform();
        driver.findElement(By.className("js-avator-link")).click();
        //使用java剪切板
        StringSelection stringSelection = new StringSelection("c:\\users");
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        sysc.setContents(stringSelection,null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    public void MoseAciton(){
        driver.get("http://www.imooc.com");
        Actions actions = new  Actions(driver);
        List<WebElement> menElementList = driver.findElements(By.className("className"));
        WebElement mobileElement = menElementList.get(1);
        actions.moveToElement(mobileElement).perform();
        driver.findElement(By.linkText("小程序"));

    }
    public void AlertWindows() throws InterruptedException {
        driver.get("");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("three")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Mushishi");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }

    public void test5() throws InterruptedException {
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.getCurrentUrl();
        driver.getTitle();
        Actions actions = new Actions(driver);
        WebElement drag=driver.findElement(By.xpath("/html/div/bod[1]"));
        actions.dragAndDropBy(drag,122,344).perform();
        //下拉框多选
        WebElement select = driver.findElement(By.xpath("selectWithMultipleEqualsMultiple"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        Action multipleSelect=actions.keyDown(Keys.SHIFT).click(options.get(1)).click(options.get(2)).build();
        multipleSelect.perform();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"执行js\")");
        driver.quit();
        driver.get("http://www.imooc.com");
        driver.switchTo().frame("aa");
        WebElement iframe = driver.findElement(By.tagName("ifame"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.linkText("baidu")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登录界面")).click();
    }
    public void test6(){
        //下拉框的操作
        WebElement select1 = driver.findElement(By.id("moreSelect"));
        Select select = new Select(select1);
        select.selectByIndex(2);
        select.selectByValue("vivo");
        select.selectByVisibleText("vivo");

        //切换窗口的操作
        String handle = driver.getWindowHandle();
        //获取当前浏览器所有的句柄值
        Set<String> handles = driver.getWindowHandles();
        if(!handles.isEmpty()){
            for(String newHandle:handles){
                if(!newHandle.equals(handle)){
                    driver.switchTo().window(newHandle);
                }
            }
        }
        driver.findElement(By.linkText("open new window")).click();

        //全局等待
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for Display");
        //全局等待
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("//*[@id=\"display\"]/div ")));



    }
}
