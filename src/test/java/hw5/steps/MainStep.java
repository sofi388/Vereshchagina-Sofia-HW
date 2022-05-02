package hw5.steps;

import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import hw5.Table;
import hw5.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainStep {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected Table userTablePage;

    public MainStep() {
        driver = TestContext.getInstance().getTestObject("driver");
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new Table(driver);
    }

}
