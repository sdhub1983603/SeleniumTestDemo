package autoMentionTest.java.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyWebDriver implements org.openqa.selenium.WebDriver, org.openqa.selenium.TakesScreenshot
{
	org.openqa.selenium.WebDriver driver;
	private Hashtable<String, String> properties;
	public MyWebDriver(org.openqa.selenium.WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * Get the driver this WebDriver represents
	 * @return
	 */
	public org.openqa.selenium.WebDriver getDriver()
	{
		return driver;
	}

	/**
	 * Set the properties from testng xml file
	 * @param properties
	 */
	public void setProperties(Hashtable<String, String> properties)
	{
		this.properties = properties;
	}

	/**
	 * Get a property
	 * @param propName
	 * @return
	 */
	public String getVariable(String propName)
	{
		return (String)properties.get(propName);
	}

	@Override
	public MyWebElement findElement(By by) {
		//System.out.println("driver findElement called " );
		return new MyWebElement(driver.findElement(by), driver);
	}

	public boolean existElement(By by) {

		try{
			driver.findElement(by);
			return true;
		}catch(org.openqa.selenium.NoSuchElementException ignored){
			return false;
		}

	}

	public List<MyWebElement> findAll(By by) {
		//System.out.println("driver findElements called " );
		List<MyWebElement> elements = new ArrayList<MyWebElement>();
		for(org.openqa.selenium.WebElement element : driver.findElements(by))
		{
			elements.add(new MyWebElement(element, driver));
		}

		return elements;
	}
	@Override
	public void close() {
		driver.close();
	}
	@Override
	public List<WebElement> findElements(By arg0) {
		return driver.findElements(arg0);
	}
	@Override
	public void get(String arg0) {
		driver.get(arg0);
        if (arg0.toLowerCase().startsWith("https://") && "1".equals(System.getProperty("slowInput"))) {
            System.out.println("这是一个https网站");
            sleep(3000);
            String title = driver.getTitle();
            if (title.startsWith("证书错误")) {
                System.out.println("被拦截了,强制通过");
                driver.get("javascript:document.getElementById('overridelink').click();");
                sleep(1000);
//                _checkAlert();
//                sleep(1000);
            } else {
                System.out.println("html title: " + title);
            }
        }
	}

	private void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void _checkAlert() {
        Reporter.log("<br>在alert上点确定");
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
            e.printStackTrace();
        }
    }


	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}
	@Override
	public String getTitle() {
		return driver.getTitle();
	}
	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}
	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}
	@Override
	public Options manage() {
		return driver.manage();
	}
	@Override
	public Navigation navigate() {
		return driver.navigate();
	}
	@Override
	public void quit() {
		driver.quit();
	}
	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		if (driver instanceof InternetExplorerDriver)
			return ((InternetExplorerDriver)driver).getScreenshotAs(arg0);
		else if (driver instanceof FirefoxDriver)
			return ((FirefoxDriver)driver).getScreenshotAs(arg0);
		else if (driver instanceof RemoteWebDriver)
			return ((RemoteWebDriver)driver).getScreenshotAs(arg0);
		else if (driver instanceof ChromeDriver)
			return ((ChromeDriver)driver).getScreenshotAs(arg0);
		else
			return ((FirefoxDriver)driver).getScreenshotAs(arg0);
	}
	public void setImplicitWait(int sec){
		this.driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(sec, TimeUnit.SECONDS);
	}

	public org.openqa.selenium.JavascriptExecutor JSExecutor(){
		return ((org.openqa.selenium.JavascriptExecutor)driver);
	}
	
	public void maxWindow()
	{
		//driver.maximize_window();
	}

	public void switchWindowHandle() {
		sleep(3000);
		String winHandleBefore = this.getWindowHandle();
		for(String winHandle : this.getWindowHandles()) {
			if (winHandle.equals(winHandleBefore)) {
				continue;
			}
			this.switchTo().window(winHandle);
			String currenturl = this.getCurrentUrl();
			if (currenturl.equals("data:,")){
				continue;
			}
			break;
		}
	}
	//关闭当前页签
	public void closeCurrentWindowAndSwitchNewWindowHandle() {
		String winHandleBefore = this.getWindowHandle();
		for(String winHandle : this.getWindowHandles()) {
			if (winHandle.equals(winHandleBefore)) {
				continue;
			}
			close();
			this.switchTo().window(winHandle);
			break;
		}
		sleep(3000);
	}
}
