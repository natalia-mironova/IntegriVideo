package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.UUID;

import static org.testng.Assert.assertTrue;

public class Registration extends BasePage {
    public Registration(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/signup");
    }

    public void register() {

        driver.findElement(By.name("email")).sendKeys(UUID.randomUUID().toString() + "@mailinator.com");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        WebElement notification = driver.findElement(By.xpath("//*[text()='Message with instructions was sent']"));
        assertTrue(notification.isDisplayed(), "Message is not displayed");
    }
}
