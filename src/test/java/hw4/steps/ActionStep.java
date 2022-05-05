package hw4.steps;

import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends MainStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Step(value = "Open the site's home page")
    public void openSite(String url) {
        driver.get(url);
    }

    @Step(value = "Log in with login: {login}; password: {password}")
    public void logIn(String login, String password) {
        HomePage.getUser().authorization(login, password);
    }

    @Step(value = "Switch to parent page")
    public void switchBack() {
        driver.switchTo().parentFrame();
    }

    @Step("Open page by SERVICE -> {subitem}")
    public void clickServiceItem(String subitem) {
        HomePage.getFirstMenu().getSubitemByText("SERVICE", subitem).click();
    }

    @Step("Select checkbox {checkName}")
    public void selectCheckBox(String checkName) {
        DifferentElementsPage.clickCheckBox(checkName);
    }

    @Step("Select radio button {radioName}")
    public void selectRadio(String radioName) {
        DifferentElementsPage.clickRadioButton(radioName);
    }

    @Step("Select {color} color")
    public void selectColor(String color) {
        DifferentElementsPage.clickDropdown(color);
    }

    @Step(value = "Close Browser")
    public void quitBrowser() {
        driver.quit();
    }
}
