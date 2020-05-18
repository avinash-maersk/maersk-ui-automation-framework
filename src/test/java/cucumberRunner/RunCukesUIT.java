package cucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import common.utilities.SeleniumUtils;

/*@Author-Avinash M(AVM031)
 * This runner file has feature tag and step definitions info along with report configurations.
 */

@RunWith(Cucumber.class)

@CucumberOptions(
    features = "src/test/resources/features",
    tags = "not @ignore",
    glue = {"stepDefinitions"},
        monochrome = true,
        strict = true,
    plugin = {
        "pretty",
        "rerun:rerun/failed_scenarios.txt",
        "html:target/reports/MaerskTeam-reports/html",
         "json:target/reports/MaerskTeam-reports/cucumber.json",
         "pretty:target/reports/MaerskTeam-reports/cucumber-pretty.txt"
    }
)

public class RunCukesUIT {

    @AfterClass
    public static void teardown() {
        SeleniumUtils.quitDriver();
    }
}