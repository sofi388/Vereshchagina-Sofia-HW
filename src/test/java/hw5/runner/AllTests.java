package hw5.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = {"src/test/resources/AllTest.feature"},
        glue = {"hw5.steps"}
)
public class AllTests extends AbstractTestNGCucumberTests {
    @BeforeSuite(description = "Set path to chrome driver")
    public void initSystem() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }
}
