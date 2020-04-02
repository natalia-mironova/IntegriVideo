package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

import static org.testng.Assert.assertTrue;

public class Registration extends BasePage {
    public Registration(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    WebElement registerEmail;
    @FindBy(name = "password")
    WebElement registerPassword;
    @FindBy(css = ".btn.btn-primary")
    WebElement registerClick;
    @FindBy(xpath = "//*[text()='Message with instructions was sent']")
    WebElement notification;
    @FindBy(css = ".iv-icon")
    WebElement icon;

    public Registration isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(icon));
        return this;
    }

    public Registration openPage() {
        driver.get("https://dev.integrivideo.com/signup");
        return this;
    }

    public void register() {
        registerEmail.sendKeys(UUID.randomUUID().toString() + "@mailinator.com");
        registerPassword.sendKeys("admin123");
        registerClick.click();
        assertTrue(notification.isDisplayed(), "Message is not displayed");
    }
}
