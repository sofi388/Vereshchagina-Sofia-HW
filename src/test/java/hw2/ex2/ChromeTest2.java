package hw2.ex2;

import hw2.browser.TestChromeBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ChromeTest2 extends TestChromeBrowser {
    @Test
    public void chromeTest2() {
        //1-4
        logIn();

        //5.1
        WebElement service = driver.findElement(By.cssSelector("header .nav .dropdown"));
        service.click();

        //5.2
        WebElement diffElements = service.findElement(By.xpath("//*[text()='Different elements']"));
        diffElements.click();

        //6
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("label.label-checkbox"));
        checkBoxes.removeIf(x -> !x.getText().equals("Water") && !x.getText().equals("Wind"));
        softAssert.assertEquals(checkBoxes.size(), 2);
        for (WebElement box : checkBoxes) {
            box.findElement(By.tagName("input")).click();
        }

        //7
        List<WebElement> radios = driver.findElements(By.cssSelector("label.label-radio"));
        radios.removeIf(x -> !x.getText().equals("Selen"));
        softAssert.assertEquals(radios.size(), 1);
        for (WebElement button : radios) {
            button.findElement(By.tagName("input")).click();
        }

        //8
        WebElement yellow = driver.findElement(By.xpath("//select/option[text()='Yellow']"));
        yellow.click();

        //9
        String[] expectedLogs = {"Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true"
        };

        List<WebElement> log = driver.findElements(By.cssSelector(".info-panel-body-log li"));

        softAssert.assertEquals(log.size(), expectedLogs.length);
        for (int i = 0; i < log.size() && i < expectedLogs.length; i++) {
            WebElement current = log.get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expectedLogs[i]));
        }
        softAssert.assertAll();
        
        //10 in parent class in after method
    }
}
