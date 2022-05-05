package hw5.steps;

import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class MainStep {
    protected WebDriver driver;// = new ChromeDriver();
    protected HomePage homePage;
    static protected String path;// = "src/main/resources/chromedriver.exe";


    @BeforeSuite(description = "Set path to chrome driver")
    public void initSystem() {
        path = "src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
    }

    public MainStep(org.openqa.selenium.WebDriver driver) {
        this.driver = driver;//new ChromeDriver();;
    }

}
