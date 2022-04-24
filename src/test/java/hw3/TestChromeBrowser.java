package hw3;

import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import hw3.elements.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestChromeBrowser {
    protected WebDriver driver;
    protected String homeUrl;

    @BeforeSuite
    public void initSystem() {
        String path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    @BeforeMethod
    public void initBrowser() {
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        new HomePage(driver);
        new DifferentElementsPage(driver);
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/test/resources/data.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logIn(UserData userData, String expTitle) {
        driver.get(homeUrl);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), expTitle);
        User user = HomePage.getUser();
        user.authorization(userData.getLogin(), userData.getPassword());
        softAssert.assertEquals(user.getUserName(), userData.getName());
        softAssert.assertAll();
    }

    //выход из браузера
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
