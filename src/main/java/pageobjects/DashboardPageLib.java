package pageobjects;

import common.utilities.Logging;
import common.utilities.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import common.utilities.WebDriverRoot;


public class DashboardPageLib extends WebDriverRoot {

	/*@Author-Avinash M(AVM031)
	 * This class has the page level code for selenium
	 */
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'About us')]")
	private WebElement clickOnAboutUsLink;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Allow all')]")
	private WebElement clickOnAllowAll;

	@FindBy(how = How.XPATH, using = "//img[contains(@src,'our-core-values')]")
	private WebElement clickOnCoreValues;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Humbleness')]")
	private WebElement Humbleness;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Uprightness')]")
	private WebElement Uprightness;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Our employees')]")
	private WebElement ourEmployees;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Our name')]")
	private WebElement ourName;
	
	public DashboardPageLib(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void clickOnAboutUs() {
		SeleniumUtils.waitforDomcomplete(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",clickOnAboutUsLink );
		SeleniumUtils.clickElement(clickOnAboutUsLink);
		Logging.info("Clicked on About Us Link");
    }
	public void clickOnAllow() {
		SeleniumUtils.clickElement(clickOnAllowAll);
		Logging.info("Clicked on Allow Button from pop up");
	}
	public void clickOnCoreValues() {
		SeleniumUtils.waitforDomcomplete(driver);
		SeleniumUtils.clickElement(clickOnCoreValues);
		Logging.info("Clicked on Core Values");
	}
	public void verifyCoreValues() {
		SeleniumUtils.getLabelText(Humbleness);
		SeleniumUtils.getLabelText(Uprightness);
		SeleniumUtils.getLabelText(ourEmployees);
		SeleniumUtils.getLabelText(ourName);
		Logging.info("All 4 values are shown in portal");
	}
}
