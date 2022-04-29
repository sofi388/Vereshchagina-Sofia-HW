package hw5;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Table {

        @FindBy(css = "table select")
        static
        List<WebElement> dropdowns;
        @FindBy(css = "table a")
        static
        List<WebElement> names;
        @FindBy(css = "table .user-descr span")
        static
        List<WebElement> descriptions;
        @FindBy(css = "table input")
        static
        List<WebElement> checkboxes;
        @FindBy(css = "table tr")
        static
        List<WebElement> tableLines;
        @FindBy(css = "div.info-panel-section")
        static
        WebElement log;

        public Table(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        public static List<WebElement> getDropdowns() {
            return dropdowns;
        }

        public static List<WebElement> getNames() {
            return names;
        }

        public static List<WebElement> getDescriptions() {
            return descriptions;
        }

        public static List<WebElement> getCheckboxes() {
            return checkboxes;
        }

        public static List<String> getTableLineContent(int line) {
            List<String> result = new ArrayList<>();
            result.add(tableLines.get(line + 1).findElement(By.tagName("td")).getText());
            result.add(names.get(line).getText());
            result.add(descriptions.get(line).getText());
            return result;
        }

        public static List<WebElement> getDropListValues(int line) {
            return dropdowns.get(line).findElements(By.tagName("option"));
        }

        public static void clickCheckboxByUserName(String name) {
            for (int i = 0; i < 6; i++) {
                if (names.get(i).getText().equals(name)) {
                    checkboxes.get(i).click();
                    return;
                }
            }
        }

        public static WebElement getLog() {
            return log;
        }
}
