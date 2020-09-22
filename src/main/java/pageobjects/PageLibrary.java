package pageobjects;

import org.openqa.selenium.WebDriver;

/*@Author-Avinash M(AVM031)
 * This class initializes page objects with driver instances.
 * 
 */
public class PageLibrary {

	public DashboardPageLib dashboardPage;
	/*
	 * Below constructor initializes the page object with WebDriver object.
	 */
	public PageLibrary(WebDriver driver) {
		dashboardPage = new DashboardPageLib(driver);
	}
}
