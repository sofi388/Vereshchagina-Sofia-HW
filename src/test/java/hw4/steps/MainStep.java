package hw4.steps;

import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import org.openqa.selenium.WebDriver;

public class MainStep {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage diffElem;

    public MainStep(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        diffElem = new DifferentElementsPage(driver);
    }
}
