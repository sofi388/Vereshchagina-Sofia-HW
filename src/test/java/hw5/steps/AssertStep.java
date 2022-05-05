package hw5.steps;

import hw3.elements.DifferentElementsPage;
import hw5.steps.MainStep;
import hw3.elements.HomePage;
import hw5.Table;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AssertStep extends MainStep {
    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Then("Title of page is {string}")
    public void checkTitle(String expTitle) {
        Assert.assertEquals(driver.getTitle(), expTitle);
    }

    @Then("User's name is {string}")
    public void checkUser(String expName) {
        Assert.assertEquals(HomePage.getUser().getUserName(), expName);
    }

    @Then("User can see items in header menu with proper text")
    public void checkHeaderItems(List<String> expText) {
        var headerItems = HomePage.getFirstMenu().getHeaderItems();
        for (WebElement current : headerItems) {
            Assert.assertTrue(current.isDisplayed());
        }
        Assert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expText.toArray());
    }

    @Then("User can see images on Home Page")
    public void checkImages() {
        var images = HomePage.getImages();
        for (WebElement current : images) {
            Assert.assertTrue(current.isDisplayed());
        }
    }

    @Then("User can see proper texts under images")
    public void checkImageTexts(List<String> expText) {
        var imageTexts = HomePage.getImageTexts();
        for (WebElement current : imageTexts) {
            Assert.assertTrue(current.isDisplayed());
        }
        Assert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new), expText.toArray());
    }

    @Then("User can see iframe")
    public void checkIframe() {
        Assert.assertTrue(HomePage.getFrame().isDisplayed());
    }

    @Then("User can see frame button in iframe")
    public void checkFrameButton() {
        Assert.assertTrue(HomePage.getFrameButton().isDisplayed());
    }

    @Then("User can see items in left menu with proper text")
    public void checkLeftItems(List<String> expText) {
        var leftItems = HomePage.getSecondMenu().getLeftItems();
        for (WebElement current : leftItems) {
            Assert.assertTrue(current.isDisplayed());
        }
        Assert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new), expText.toArray());
    }

    @Then("I can see logs with proper text")
    public void checkLogs(List<String> expText) {
        String[] expected = expText.toArray(String[]::new);
        var logs = DifferentElementsPage.getLogs();
        for (int i = 0; i < expected.length; i++) {
            WebElement current = logs.get(i);
            Assert.assertTrue(current.isDisplayed());
            Assert.assertTrue(current.getText().contains(expected[i]));
        }
    }

    private void checkNumberAndDisplay(List<WebElement> webElements) {
        Assert.assertEquals(webElements.size(), 6);
        for (WebElement element : webElements) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkDropdowns() {
        checkNumberAndDisplay(Table.getDropdowns());
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkUserNames() {
        checkNumberAndDisplay(Table.getNames());
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkUserDescriptions() {
        checkNumberAndDisplay(Table.getDescriptions());
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxes() {
        checkNumberAndDisplay(Table.getCheckboxes());
    }
    @Then("Table should contain following values:")
    public void checkTableContent(List<List<String>> expValues) {
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(Table.getTableLineContent(i), expValues.get(i + 1));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void checkDroplist(List<String> expValues) {
        Assert.assertEquals(Table.getDropListValues(0).stream().map(WebElement::getText).toArray(String[]::new), expValues.subList(1, 4).toArray());
    }

    @Then("1 log row has {string} text in log section")
    public void checkLog(String expText) {
        Assert.assertTrue(Table.getLog().getText().contains(expText));
    }
}
