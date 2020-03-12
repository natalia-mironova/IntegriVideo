package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {
    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void openLoginPage(){
        driver.get("https://dev.integrivideo.com/login");
    }

    public void login(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public void checkSuccessfulLogin() {
        WebElement projectsTitle = driver.findElement(By.cssSelector(".nav-link"));
        assertTrue(projectsTitle.isDisplayed(), "Looks like you are not logged in");
    }
}
