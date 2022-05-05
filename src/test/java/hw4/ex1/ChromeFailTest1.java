package hw4.ex1;

import hw4.AllureTest;
import org.testng.annotations.Test;
import static hw3.Users.roman;

//fail test
public class ChromeFailTest1 extends AllureTest{
    @Test
    public void chromeTest1() {
        logIn(roman,"Not home page");

        //5-11
        String[] expectedItemText = {"Home", "Contact Form", "Service", "Metals & Colors"};
        assertStep.checkHeaderItems(expectedItemText);
        assertStep.checkImages();
        String[] expectedImageText = {"To include good practices\nand ideas from successful\nEPAM proj",
                "To be flex and\ncustomizable",
                "To be multi",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more"};
        assertStep.checkImageTexts(expectedImageText);
        assertStep.checkFrame();
        assertStep.checkFrameButton();
        actionStep.switchBack();
        String[] expectedMenuText = {"Home", "Contact", "Serv", "Metal & Color", "Elem pack"};
        assertStep.checkLeftItems(expectedMenuText);

        assertStep.assertAll();
    }
}


