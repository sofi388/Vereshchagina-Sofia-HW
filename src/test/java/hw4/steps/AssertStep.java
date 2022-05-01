package hw4.steps;

import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AssertStep extends MainStep {

    SoftAssert softAssert;

    public AssertStep(WebDriver driver) {
        super(driver);
        softAssert = new SoftAssert();
    }

    @Step(value = "Check that title is '{expTitle}'")
    public void checkTitle(String expectedTitle) {
        softAssert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Step(value = "Check that user is logged in")
    public void checkUser(String expectedName) {
        softAssert.assertEquals(HomePage.getUser().getUserName(), expectedName);
    }

    @Step(value = "Header items are displayed and have proper texts")
    public void checkHeaderItems(String[] expectedText) {
        var headerItems = HomePage.getFirstMenu().getHeaderItems();
        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expectedText);
    }

    @Step(value = "Images are displayed")
    public void checkImages() {
        var images = HomePage.getImages();
        for (WebElement current : images) {
            softAssert.assertTrue(current.isDisplayed());
        }
    }

    @Step(value = "Texts under images are displayed and have proper values")
    public void checkImageTexts(String[] expectedText) {
        var imageTexts = HomePage.getImageTexts();
        for (WebElement current : imageTexts) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new), expectedText);
    }

    @Step(value = "Iframe is displayed")
    public void checkFrame() {
        softAssert.assertTrue(HomePage.getFrame().isDisplayed());
    }

    @Step(value = "Frame button in iframe is displayed")
    public void checkFrameButton() {

        softAssert.assertTrue(HomePage.getFrameButton().isDisplayed());
    }

    @Step(value = "Item in left menu are displayed and have proper texts")
    public void checkLeftItems(String[] expText) {
        var leftItems = HomePage.getSecondMenu().getLeftItems();
        for (WebElement current : leftItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new), expText);
    }

    @Step("Logs are displayed and have proper texts")
    public void checkLogs(String[] expText) {
        var logs = DifferentElementsPage.getLogs();
        for (int i = 0; i < expText.length; i++) {
            WebElement current = logs.get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expText[i]));
        }
    }

    public void assertAll() {
        softAssert.assertAll();
    }
}
