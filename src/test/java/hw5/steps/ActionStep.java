package hw5.steps;

import hw3.elements.DifferentElementsPage;
import hw5.steps.MainStep;
import hw3.elements.HomePage;
import hw5.Table;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ActionStep extends MainStep {

    @When("I click on {string} in Header Menu->Service")
    public void clickServiceItem(String subitem) {
        HomePage.getFirstMenu().getSubitemByText("SERVICE", subitem).click();
    }

    @When("User switch back to parent window")
    public void switchBack() {
        driver.switchTo().parentFrame();
    }

    @When("I choose checkbox {string}")
    public void selectCheckBox(String checkName) {
        DifferentElementsPage.clickCheckBox(checkName);
    }

    @When("I choose radio button {string}")
    public void selectRadio(String radioName) {
        DifferentElementsPage.clickRadioButton(radioName);
    }

    @When("I choose {string} in dropdown")
    public void selectColor(String color) {
        DifferentElementsPage.clickDropdown(color);
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectCheckboxByUserName(String name) {
        Table.clickCheckboxByUserName(name);
    }
}
