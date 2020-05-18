package cucumberRunner;

import common.utilities.SeleniumUtils;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


/*@Author-Avinash M(AVM031)
 * This runner file is used to run failed scenarios captured during actual test execution.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@rerun/failed_scenarios.txt"
    ,glue= {"stepDefinitions"}
    ,monochrome = true
	,strict = true
	,dryRun = false
    , plugin = {
    	"pretty",
		"html:target/reports/MaerskTeam-reports/rerun/html",
		"json:target/reports/MaerskTeam-reports/rerun/cucumber.json",
		"pretty:target/reports/MaerskTeam-reports/rerun/cucumber-pretty.txt"}
		)

public class FailedScenarios {
	@AfterClass
	public static void teardown() {
		SeleniumUtils.quitDriver();
	}
}