package hw4.ex1;

import hw4.AllureTest;
import org.testng.annotations.Test;
import static hw3.Users.roman;

public class ChromeTest1 extends AllureTest {

    @Test(description = "Exercise 1")
    public void testSitePage() {
        //1-4
        logIn(roman,"Home Page");

        //5-11
        String[] expectedItemText = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        assertStep.checkHeaderItems(expectedItemText);
        assertStep.checkImages();
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more\u2026"};
        assertStep.checkImageTexts(expectedImageText);
        assertStep.checkFrame();
        assertStep.checkFrameButton();
        actionStep.switchBack();
        String[] expectedMenuText = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        assertStep.checkLeftItems(expectedMenuText);

        assertStep.assertAll();
    }
}

