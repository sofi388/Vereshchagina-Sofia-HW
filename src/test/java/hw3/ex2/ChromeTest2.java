package hw3.ex2;

import hw3.TestChromeBrowser;
import hw3.elements.DifferentElementsPage;
import hw3.elements.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static hw3.Users.roman;


public class ChromeTest2 extends TestChromeBrowser {
    @Test
    public void chromeTest2() {
        //1-4
        logIn(roman, "Home Page");

        //5-9
        HomePage.getFirstMenu().getSubitemByText("SERVICE", "DIFFERENT ELEMENTS").click();
        DifferentElementsPage.clickCheckBox("Water");
        DifferentElementsPage.clickCheckBox("Wind");
        DifferentElementsPage.clickRadioButton("Selen");
        DifferentElementsPage.clickDropdown("Yellow");

        String[] expectedLogs = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i < expectedLogs.length; i++) {
            WebElement current = DifferentElementsPage.getLogs().get(i);
            softAssert.assertTrue(current.isDisplayed());
            softAssert.assertTrue(current.getText().contains(expectedLogs[i]));
        }
        softAssert.assertAll();
    }
}
