package stepDefinitions.Pages;

import common.utilities.SeleniumUtils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;



public class CucumberHooks {

	/*@Author-Avinash M(AVM031)
	 * This class has the implementation for adding screen shot for failed scenarios in html report
	 */

	@After
    public void screenshot(Scenario scenario) {
		System.out.println("Scenarios which is failed before condition loop");
    	if(scenario.isFailed()) {
    		System.out.println("Scenarios which is failed" +scenario.getName());
 		   byte[] screenshot= SeleniumUtils.captureScreenshot();
 		   scenario.embed(screenshot, "image/png",scenario.getName());
 	   }
	}	
}
