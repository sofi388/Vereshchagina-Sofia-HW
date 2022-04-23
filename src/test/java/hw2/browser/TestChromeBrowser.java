package hw2.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestChromeBrowser {
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected String homeUrl;

    private String login = "Roman";
    private String password = "Jdi1234";
    private String name = "ROMAN IOVLEV";

    @BeforeMethod
    public void startBrowser() {
        //настройка драйвера && браузера
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        softAssert = new SoftAssert();
        homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    public void logIn() {
        //проверка страницы
        driver.get(homeUrl);
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        driver.findElement(By.cssSelector(".uui-profile-menu .dropdown-toggle")).click();
        //авторизация
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        //проверка user a
        WebElement userName = driver.findElement(By.id("user-name"));
        softAssert.assertEquals(userName.getText(), name);
    }

    @AfterMethod
    public void closeBrowser() {
        //выход из браузера
        driver.quit();
    }
}
