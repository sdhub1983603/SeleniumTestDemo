package autoMentionTest.java.test.panel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class CourseList {
   public WebDriver driver;
//    public CourseList(){}
//    public CourseList(WebDriver driver) {
//        this.driver = driver;
//    }

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chromer.driver","D://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://coding.imooc.com");
    }
    @Test
    public void test1(){
        List<WebElement> coureList = driver.findElements(By.xpath("//p[@class='shizan-name']"));
        for(WebElement courseName:coureList){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            courseName.click();
            driver.navigate().back();
            System.out.println(courseName.getText());
        }
    }
}
