package hw5.steps;

import hw3.elements.HomePage;
import hw5.steps.MainStep;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class GivenStep extends MainStep {

    @Given("I open Home Page {string}")
    public void openSite(String url) {
        driver.get(url);
    }

    @Given("I log in with login: {string} and password: {string}")
    public void logIn(String login, String password) {
        HomePage.getUser().authorization(login, password);
    }
}