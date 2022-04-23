package hw3.ex2;

import hw3.TestChromeBrowser;
import hw3.UserData;
import hw3.elements.Elements;
import hw3.elements.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ChromeTest2 extends TestChromeBrowser {
    @Test
    public void chromeTest2() {
        //1-4
        logIn(new UserData("", "login", "password"), "Home Page");

        //5-9

        //this doesn't work
        //even manually opening page and clicking - doesn't work

        Page.getFirstMenu().getSubitemByText("SERVICE", "DIFFERENT ELEMENTS").click();


        Elements diffElem = new Elements(driver);

        diffElem.clickCheckBox("Water");
        diffElem.clickCheckBox("Wind");
        diffElem.clickRadioButton("Selen");
        diffElem.clickDropdown("Yellow");

        String[] expectedLogs = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        for (int i = 0; i < expectedLogs.length; i++) {
            WebElement current = diffElem.getLogs().get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expectedLogs[i]));
        }

        softAssert.assertAll();
    }
}
