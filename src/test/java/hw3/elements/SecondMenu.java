package hw3.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SecondMenu {
    @FindBy(css = ".sidebar-menu>li")
    List<WebElement> leftItems;

    public SecondMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getLeftItems() {
        return leftItems;
    }
}
