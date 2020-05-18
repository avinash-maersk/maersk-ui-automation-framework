package stepDefinitions.Pages.dashboard;

import common.utilities.WebDriverRoot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DashboardPage extends WebDriverRoot {

	/*@Author-Avinash M(AVM031)
	 * This class has the step definitions for the test written in corresponding feature file
	 */

	@Given("user launched {string} browser for the brand {string} in the environment {string}")
	public void user_launched_browser_for_the_brand_in_the_environment(String browser, String brand, String env) throws Exception {
		setup(browser,brand,env);
	}

	@Given("click on Allow All button from pop up")
	public void click_on_Allow_All_button_from_pop_up() {
		pageFactory().dashboardPage.clickOnAllow();
	}

	@When("click on About us link from dashboard")
	public void click_on_About_us_link_from_dashboard() {
		pageFactory().dashboardPage.clickOnAboutUs();
	}
	@And("click on Our Core values link")
	public void click_on_Our_Core_values_link() {
		pageFactory().dashboardPage.clickOnCoreValues();

	}
	@Then("user should be able to view Core values of maersk")
	public void user_should_be_able_to_view_Core_values_of_maersk() {
		pageFactory().dashboardPage.verifyCoreValues();

	}


}