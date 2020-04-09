package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

import static org.testng.Assert.assertTrue;

public class Registration extends BasePage {
    public Registration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//*[@id='recaptcha-anchor']")
    WebElement reCaptcha;

    public Registration openPage() {
        driver.get("https://dev.integrivideo.com/signup");
        return this;
    }

    public Registration isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(icon));
        return this;
    }

//    public void register() {
//        registerEmail.sendKeys(UUID.randomUUID().toString() + "@mailinator.com");
//        registerPassword.sendKeys("admin123");
//        driver.switchTo().frame(driver.findElement(By.xpath("//div[contains(@class,'g-recaptcha')]//iframe")));
//        reCaptcha.click();
//        driver.switchTo().defaultContent();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        registerClick.click();
//        assertTrue(notification.isDisplayed(), "Message is not displayed");
//    }
}
