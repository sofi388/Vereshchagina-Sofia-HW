package hw3.elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
public class DifferentElementsPage {
    @FindBy(css = "label.label-checkbox")
    static List<WebElement> checkBoxes;
    @FindBy(css = "label.label-radio")
    static List<WebElement> radioButtons;
    @FindBy(tagName = "option")
    static List<WebElement> dropdown;
    @FindBy(css = ".info-panel-body-log li")
    static List<WebElement> logs;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static void clickCheckBox(String textCheckBox) {
        for (WebElement box : checkBoxes) {
            if (box.getText().equals(textCheckBox)) {
                box.click();
                return;
            }
        }
    }

    public static void clickRadioButton(String textRadioButton) {
        for (WebElement radio : radioButtons) {
            if (radio.getText().equals(textRadioButton)) {
                radio.click();
                return;
            }
        }
    }

    public static void clickDropdown(String textDropdown) {
        for (WebElement option : dropdown) {
            if (option.getText().equals(textDropdown)) {
                option.click();
                return;
            }
        }
    }

    public static List<WebElement> getLogs() {
        return logs;
    }
}
