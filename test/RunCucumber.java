@RunWith(Cucumber.class)
@ExtendedCucumberOptions(retryCount = 0)
@CucumberOptions(
        features = {"test/resources/features"},
        glue = {"com.saucedemo.stepdefs"})

public class RunCucumber {

    @BeforeClass
    public static void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "test/resources/webdriver/chromedriver");
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.timeout = 30000;
    }

    @AfterClass
    public static void closeWebDriver() {
        if (WebDriverRunner.hasWebDriverStarted()){
            Logger.debug("Cerrando webdriver");
            WebDriverRunner.getWebDriver().quit();
        }
    }

}
