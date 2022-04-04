package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import hw2.browser.TestChromeBrowser;
import org.testng.annotations.Test;

import java.util.List;

public class ChromeTest1 extends TestChromeBrowser {
    @Test
    public void chromeTest1() {
        logIn();
        //5
        List<WebElement> headerItems = driver.findElements(By.cssSelector("header .nav>li"));
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};

        softAssert.assertEquals(headerItems.size(), expectedItemText.length);
        for (WebElement current : headerItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(headerItems.stream().map(WebElement::getText).toArray(String[]::new), expectedItemText);

        //6
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(images.size(), 4);
        for (WebElement currImage : images) {
            softAssert.assertTrue(currImage.isDisplayed());
        }

        //7
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM project", "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};

        softAssert.assertEquals(texts.size(), expectedImageText.length);
        for (WebElement imageText : texts) {
            softAssert.assertTrue(imageText.isDisplayed());
        }
        softAssert.assertEquals(texts.stream().map(WebElement::getText).toArray(String[]::new), expectedImageText);

        //8
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        softAssert.assertTrue(iframe.isDisplayed());

        //9
        driver.switchTo().frame(iframe);
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        softAssert.assertTrue(frameButton.isDisplayed());

        //10
        driver.switchTo().parentFrame();

        //11
        String[] expectedMenuText = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softAssert.assertEquals(menuItems.size(), expectedMenuText.length);
        for (WebElement current : menuItems) {
            softAssert.assertTrue(current.isDisplayed());
        }
        softAssert.assertEquals(menuItems.stream().map(WebElement::getText).toArray(String[]::new), expectedMenuText);

        softAssert.assertAll();
    }
    //12 in parent class in after method
}