import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.simetrik.pages.GeneralPage;
import com.simetrik.utils.DriverUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(retryCount = 0)
@CucumberOptions(
        features = {"src/java/test/resources/features"},
        glue = {"com.simetrik.stepdefs"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "json:target/cucumber.json"})
public class RunCucumberFirefox {
    @BeforeClass
    public static void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/java/test/resources/webdriver/geckodriver.exe");
        DriverUtil.getDefaultDriver("firefox");
    }

    @AfterClass
    public static void closeWebDriver(){
        if (GeneralPage.driver != null){
            DriverUtil.closePage();
        }
    }
}
