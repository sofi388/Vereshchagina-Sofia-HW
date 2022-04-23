package hw3.elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Page {
    private static FirstMenu firstMenu;
    private static User user;
    private static SecondMenu secondMenu;
    private static WebDriver driver;

    @FindBy(className = "benefit-icon")
    private static List<WebElement> images;
    @FindBy(className = "benefit-txt")
    private static List<WebElement> imageTexts;
    @FindBy(tagName = "iframe")
    private static WebElement frame;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        firstMenu = new FirstMenu(driver);
        user = new User(driver);
        secondMenu = new SecondMenu(driver);
    }

    public static FirstMenu getFirstMenu() {
        return firstMenu;
    }

    public static User getUser() {

        return user;
    }

    public static SecondMenu getSecondMenu() {

        return secondMenu;
    }

    public static List<WebElement> getImages() {

        return images;
    }

    public static List<WebElement> getImageTexts() {

        return imageTexts;
    }

    public static WebElement getFrame() {

        return frame;
    }

    public static WebElement getFrameButton() {
        driver.switchTo().frame(frame);
        return driver.findElement(By.id("frame-button"));
    }
}

