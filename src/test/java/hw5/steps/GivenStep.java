package hw5.steps;

import hw3.elements.HomePage;
import hw5.steps.MainStep;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GivenStep extends MainStep {

    //class hw5.steps1.ConditionStep does not have a public zero-argument constructor.
    public GivenStep(WebDriver driver) {
        super(driver);
    }

    @Given("I open Home Page {string}")
    public void openSite(String url) {
        driver.get(url); //why driver is null
    }

    @Given("I log in with login: {string} and password: {string}")
    public void logIn(String login, String password) {
        HomePage.getUser().authorization(login, password);

    }
}