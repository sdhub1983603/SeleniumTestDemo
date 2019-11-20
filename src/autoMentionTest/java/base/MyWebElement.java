package autoMentionTest.java.base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MyWebElement implements org.openqa.selenium.WebElement
{
	org.openqa.selenium.WebElement element;
	org.openqa.selenium.WebDriver driver;
	ChromeDriver cdriver;
	org.openqa.selenium.WebElement chrome_element;

	public MyWebElement(org.openqa.selenium.WebElement element, org.openqa.selenium.WebDriver driver)
	{
		this.element = element;
		this.driver = driver;
		cdriver = null;
	}

	public MyWebElement(org.openqa.selenium.WebElement element, ChromeDriver driver)
	{
		this.chrome_element = element;
		this.driver = driver;
		driver = null;
		element = null;
	}

	/**
	 * Get the element this WebElement represents
	 * @return
	 */
	public org.openqa.selenium.WebElement getElement()
	{
		return element;
	}

	/**
	 * Get the driver this WebElement came from
	 * DO NOT use findElement/s on this object. Create a new com.selenium.utils.WebElement first
	 * @return
	 */
	public MyWebDriver getDriver()
	{
		return new MyWebDriver(driver);
	}

	@Override
	public MyWebElement findElement(By by) {
		return new MyWebElement(element.findElement(by), driver);
	}

	/**
	 * Find the visible element
	 * @param by
	 * @param retryTimes - times to search again if no visible element is found.
	 * @param waitTime - time to wait between 2 searches.
	 * @return
	 */
	public MyWebElement findVisibleElement(By by, int retryTimes, int waitTime)
	{
		for(int i = 0; i < retryTimes; i++)
		{
			List<MyWebElement> list = findAll(by);
			for(MyWebElement e : list)
			{
				if(e.isDisplayed() == true)
					return e;
			}
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		// if no visible element is found, find first one by xpath
		return findElement(by);
	}

	public MyWebElement findVisibleElement(By by)
	{
		return findVisibleElement(by, 5, 1000);
	}

	public List<MyWebElement> findAll(By by)
	{
		List<MyWebElement> elements = new ArrayList<MyWebElement>();
		for(org.openqa.selenium.WebElement e : element.findElements(by))
		{
				elements.add(new MyWebElement(e, driver));
		}
		return elements;
	}

	public void performContextClickAndSelectItem(String itemToSelect)
	{
		Actions action = new Actions(this.driver);
		action.contextClick(this.getElement()).perform();
		WebDriverWait wait = new WebDriverWait(this.driver, 60);
//		By locator = By.xpath(".//td[contains(text(), '" + MessagesReader.get(itemToSelect) + "')]");
		By locator = By.xpath("//div[contains(@id, 'popup_')][not(contains(@style,'display:none') or contains(@style,'display: none'))]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		org.openqa.selenium.WebElement contextMenu = this.getElement().findElement(locator);
		org.openqa.selenium.WebElement itemElement = contextMenu.findElement(By.xpath(".//td[contains(text(), '" + itemToSelect + "')]"));
		action.moveToElement(itemElement).perform();
		action.click().build().perform();
	}

	@Override
	public void clear() {
		element.clear();
	}

	@Override
	public void click() {
		//AjaxHelper.waitForAjax(this.getDriver(), 50000, 1000);
		element.click();
		sleep(1000);
//		AjaxHelper.waitForAjax(this.getDriver(), 60000, 1000);
	}

//	public void cclick(){
//		AjaxHelper.waitForAjax_Chrome(this.cdriver, 50000, 1000);
//		chrome_element.click();
//		AjaxHelper.waitForAjax_Chrome(this.cdriver, 60000, 1000);
//	}

	public void clickNoAjax(){
		element.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickwithoutwait() {
		//AjaxHelper.waitForAjax(this.getDriver(), 50000, 1000);
		sleep(1000);
		element.click();
	}

	public void doubleClick(MyWebElement we){
		(new Actions(this.driver)).doubleClick(we.getElement()).perform();
	}

	public void clickAndDrag(int xOffset, int yOffset){
		Actions builder = new Actions(this.driver);

		Action clickDrag = builder.clickAndHold(this.element).moveByOffset(xOffset, yOffset).release().build();

		clickDrag.perform();
	}

	public void rightClick(){
		Actions builder = new Actions(this.driver);

		Action action = builder.contextClick(this.element).build();

		action.perform();
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		return element.findElements(arg0);
	}

	@Override
	public String getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return element.getAttribute(arg0);
	}

	@Override
	public String getCssValue(String arg0) {
		return element.getCssValue(arg0);
	}

	@Override
	public Point getLocation() {
		return element.getLocation();
	}

	@Override
	public Dimension getSize() {
		return element.getSize();
	}

	@Override
	public String getTagName() {
		return element.getTagName();
	}

	@Override
	public String getText() {
		return element.getText();
	}

	@Override
	public boolean isDisplayed() {
		return element.isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		return element.isEnabled();
	}

	@Override
	public boolean isSelected() {
		return element.isSelected();
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		element.sendKeys(arg0);
	}

	@Override
	public void submit() {
		element.submit();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return element.getRect();
	}
	
    public void sleep(long millis)
    {
    	try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    //一步选中、清除、输入文本
    //by Alex 03/04/2017 
    public void quickInputText(String arg0){
    	element.click();
        element.clear();
        int ms = 10;

        if ("1".equals(System.getProperty("slowInput")))
        {
            for (int i=0; i<arg0.length(); i++)
            {
                String letter = arg0.substring(i,i+1);
                element.sendKeys(letter);
                sleep(ms);
            }
        }
        else
        {
            element.sendKeys(arg0);
        }

        String tagName = element.getTagName().toLowerCase();

        if (tagName.equals("input")) {
            if (element.getAttribute("type").toLowerCase().equals("file"))
                return;
            String typedStr = element.getAttribute("value");
            //IE10上有时候输入的内容会不对，做个判断
            while (!typedStr.equals(arg0)) {
                System.out.println("设计输入的内容是："+arg0 +"\n实际输入的内容是："+typedStr);
                element.clear();
                for (int i=0; i<arg0.length(); i++)
                {
                    String letter = arg0.substring(i,i+1);
                    element.sendKeys(letter);
                    sleep(ms);
                }
                typedStr = element.getAttribute("value");
            }
        }
    }
    
}
