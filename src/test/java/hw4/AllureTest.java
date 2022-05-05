package hw4;
import hw3.UserData;
import hw4.steps.ActionStep;
import hw4.steps.AssertStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AllureTest extends TestListenerAdapter{
    protected String homeUrl;
    protected Properties properties;
    protected ActionStep actionStep;
    protected AssertStep assertStep;

    public WebDriver getDriver() {
        return actionStep.getDriver();
    }

    @BeforeSuite(description = "Set path to chrome driver")
    public void initSystem() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod(description = "Initialization of class fields and driver's configurations")
    public void initBrowser() {
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        actionStep = new ActionStep(driver);
        assertStep = new AssertStep(driver);
        properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/data.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Check that title is '{expTitle}' and authorization of user '{userData.name}'")
    public void logIn(UserData userData, String expTitle) {

        actionStep.openSite(homeUrl);
        assertStep.checkTitle(expTitle);
        actionStep.logIn(userData.getLogin(), userData.getPassword());
        assertStep.checkUser(userData.getName());
    }

    @AfterMethod(description = "Finish browser's work")
    public void closeBrowser() {
        actionStep.quitBrowser();
    }
}
