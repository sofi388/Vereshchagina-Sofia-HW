package hw5.steps;

import hw5.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class CucumberHook {

    @Before
    public void initBrowser() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        TestContext.getInstance().putTestObject("driver", driver);
    }

    @After
    public void closeBrowser() {
        ((WebDriver) TestContext.getInstance().getTestObject("driver")).quit();
        TestContext.getInstance().clear();
    }
}
