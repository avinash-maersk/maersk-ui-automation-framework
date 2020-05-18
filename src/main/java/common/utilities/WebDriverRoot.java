package common.utilities;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import pageobjects.PageLibrary;


/*@Author-Avinash M(AVM031)
 * This class has code related to browser setup and URL look for different environments and brand.
 */

public class WebDriverRoot {

    protected static WebDriver driver;
    protected String hostURL;
    public PageLibrary engine;
    public static ConfigProperties mconfigProperties = new ConfigProperties();


    public String getReportConfigPath() {

        String reportConfigPath = ConfigProperties.getreportConfigPath();
        if (reportConfigPath != null) return reportConfigPath;
        else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public void setup(String browser, String brand, String env) throws IOException, Exception {


        try {
            if (browser.equalsIgnoreCase("firefox")) {

                System.out.println("Browser is identified and the test is getting executed in Firefox Browser");
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/drivers/geckodriver.exe");

                driver = new FirefoxDriver();
                Logging.info("Firefox Browser is launched");
            } else if (browser.equalsIgnoreCase("chrome")) {

                System.out.println("Browser is identified and the test is getting executed in Chrome Browser");
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/drivers/chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                options.addArguments("test-type");
                options.addArguments("--disable-web-security");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("dir = C:~/chromeTemp");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver(options);
                Logging.info("Chrome Browser is launched");
            } else if (browser.equalsIgnoreCase("ie")) {
                System.out.println("Browser is identified and the test is getting executed in IE Browser");
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/drivers/IEDriverServer.exe");

                driver = new InternetExplorerDriver();
                Logging.info("IE  Browser is launched");
            } else if (browser.equalsIgnoreCase("edge")) {
                System.out.println("Browser is identified and the test is getting executed in Microsoft Edge Browser");
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/drivers/MicrosoftWebDriver.exe");

                driver = new EdgeDriver();
                Logging.info("Microsoft Edge Browser is launched");
            } else if (browser.equalsIgnoreCase("safari")) {

                System.out.println("Browser is identified and the test is getting executed in Safari Browser");
                System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "/src/main/drivers/safari.exe");

                driver = new SafariDriver();
                Logging.info("Safari Browser is launched");

            }
            hostURL = ConfigProperties.getHostUrl(env, brand);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(hostURL);
            Logging.info("Host URL Launched in browser");

        } catch (Exception e) {
            Logging.error("Something went wrong with the host url");
            Logging.warn("Browser Exception thrown");
            Logging.fatal("Exception thrown");
        }
    }

    public PageLibrary pageFactory() {
        engine = new PageLibrary(driver);
        return engine;
    }
}