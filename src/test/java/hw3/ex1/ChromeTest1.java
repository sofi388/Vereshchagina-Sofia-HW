package hw3.ex1;

import hw3.TestChromeBrowser;
import hw3.UserData;
import hw3.elements.Page;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ChromeTest1 extends TestChromeBrowser {
    @Test
    public void chromeTest1() {
        logIn(new UserData("", "login", "password"), "Home Page");

        //5 - 7
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<WebElement> headerItems = Page.getFirstMenu().getHeaderItems();
        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new),
                expectedItemText);
        for (WebElement current : Page.getImages()) {
            softAssert.assertTrue(current.isDisplayed());
        }
        String[] expectedImageText = {"To include good practices\nand ideas from successful" +
                "\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects)," +
                        "\nwish to get more…"};
        var imageTexts = Page.getImageTexts();
        for (WebElement current : imageTexts) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new),
                expectedImageText);

        //8-11
        softAssert.assertTrue(Page.getFrame().isDisplayed());
        softAssert.assertTrue(Page.getFrameButton().isDisplayed());
        driver.switchTo().parentFrame();
        String[] expectedMenuText = {"Home", "Contact form", "Service", "Metals & Colors",
                "Elements packs"};
        var leftItems = Page.getSecondMenu().getLeftItems();
        for (WebElement current : leftItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new),
                expectedMenuText);

        softAssert.assertAll();
    }
    //12 in parent class in after method
}