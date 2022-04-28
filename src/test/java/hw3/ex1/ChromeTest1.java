package hw3.ex1;

import hw3.TestChromeBrowser;
import hw3.elements.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

import static hw3.Users.roman;

public class ChromeTest1 extends TestChromeBrowser {
    @Test
    public void chromeTest1() {
        //1-4
        logIn(roman, "Home Page");

        //5 - 7
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        List<WebElement> headerItems = HomePage.getFirstMenu().getHeaderItems();
        SoftAssert softAssert = new SoftAssert();

        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expectedItemText);
        for (WebElement current : HomePage.getImages()) {
            softAssert.assertTrue(current.isDisplayed());
        }
        String[] expectedImageText = {"To include good practices\nand ideas from successful" +
                "\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects)," +
                        "\nwish to get more…"};
        var imageTexts = HomePage.getImageTexts();
        for (WebElement current : imageTexts) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(imageTexts.stream().map(WebElement::getText).toArray(String[]::new), expectedImageText);

        //8-11
        softAssert.assertTrue(HomePage.getFrame().isDisplayed());
        softAssert.assertTrue(HomePage.getFrameButton().isDisplayed());
        driver.switchTo().parentFrame();
        String[] expectedMenuText = {"Home", "Contact form", "Service", "Metals & Colors",
                "Elements packs"};
        var leftItems = HomePage.getSecondMenu().getLeftItems();
        for (WebElement current : leftItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(leftItems.stream().map(WebElement::getText).toArray(String[]::new), expectedMenuText);
        softAssert.assertAll();
    }
    //12 in parent class in after method
}