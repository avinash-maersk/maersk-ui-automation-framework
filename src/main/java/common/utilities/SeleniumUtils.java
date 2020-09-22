package common.utilities;


import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class SeleniumUtils extends WebDriverRoot {
	
	/*@Author-Avinash M(AVM031)
	 * This class has all the global functions defined.
	 */
	
	private final static long waitTimeout=30;
	private final static long pollingTimeout=1;
	public static FluentWait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(waitTimeout)).pollingEvery(Duration.ofSeconds(pollingTimeout));
	
	/**
	 * Method will checDuratiok the status of Dom Load
	 * @param driver
	 */
	public static void waitforDomcomplete(WebDriver driver) {
		ExpectedCondition<Boolean> pageloadStatus=new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver driver) {
				return((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		fluentwait.until(pageloadStatus);
	}

	/**
	 * Method will be used to wait for page to load
	 * @param driver
	 * @param byType
	 */
	public static void waitForPageToLoad(WebDriver driver, final By byType) {
		Wait<WebDriver> wait1;
		wait1 = new WebDriverWait(driver, waitTimeout);
		wait1.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(byType) !=null;
			}
		});
	}

	/**
	 * Method is used to click on Element
	 * @param element
	 */
	
	
	public static void clickElement(WebElement element) {
		
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		element.click();
			
	}
	/**
	 * Method is used to send text in the field
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
		
	}
	/**
	 * Method is used to send keys to the field
	 * @param element
	 * @param key
	 */
	public static void sendText(WebElement element, Keys key) {
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(key);
	}
	
	/**
	 * Method is used to scroll to the view
	 * @param element
	 */
	public static void scrollIntoView(WebElement element) {
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
	/**
	 * Method is used to check for the presence of Elements
	 * @param element
	 * @return
	 */
	public static boolean isPresent(WebElement element) {
		if (element.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		
	}
	/**
	 * Method is used to check if the Element is enabled.
	 * @param element
	 * @return
	 */
	public static boolean isEnabled(WebElement element) {

		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Method is used to fetch the label text
	 * @param element
	 * @return
	 */
	public static String getLabelText(WebElement element) {
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	/**
	 * Method is used to validate the text ignoring the case of the characters.
	 * @param element
	 * @param expectedText
	 * @return
	 */
	public static Boolean validateTextIgnoreCase(WebElement element, String expectedText) {
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		if(element.getText().equalsIgnoreCase(expectedText))
			return true;
		else
			return false;
	}
	
	/**
	 * Method is used to validate the text along with case
	 * @param element
	 * @param expectedText
	 * @return
	 */
	
	public static Boolean validateText(WebElement element, String expectedText) {
		fluentwait.until(ExpectedConditions.visibilityOf(element));
		if(element.getText().equals(expectedText))
			return true;
		else
			return false;
	}
	/**
	 * Method is used to provide wait.
	 * @param millis
	 */
	public static void waitformilli(long millis) {
		try {
		Thread.sleep(millis);
		}catch(Exception e) {
			
		}
	}
	/**
	 * Method is used to switch to the window Handle 
	 */
	public static void switchHandle() {
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	/**
	 * Below method is used to close the driver.
	 */
	public static void closeDriver() {
		driver.close();
	}
	/**
	 * Method is used to Quit Driver
	 */
	public static void quitDriver() {
		driver.quit();
	}
	
	/**
	 * Method captures screenshot and returns in byte format.
	 * @return
	 */
	public static byte[] captureScreenshot() {
			byte[] srcBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			return srcBytes;
	}
}