package hw4.ex2;

import hw4.AllureTest;
import org.testng.annotations.Test;

import static hw3.Users.roman;

public class ChromeTest2 extends AllureTest {
    @Test
    public void chromeTest2() {
        //1-4
        logIn(roman, "Home Page");

        //5-9
        actionStep.clickServiceItem("DIFFERENT ELEMENTS");
        actionStep.selectCheckBox("Water");
        actionStep.selectCheckBox("Wind");
        actionStep.selectRadio("Selen");
        actionStep.selectColor("Yellow");

        String[] expectedLogs = {"Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true"
        };
        assertStep.checkLogs(expectedLogs);
        assertStep.assertAll();
    }
}
