package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {
    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(css = ".btn")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    //это дублирует openLoginPage
    public LoginPage openPage() {
        return this;
    }

    public LoginPage openLoginPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        return this;
    }

    public LoginPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public ProjectsPage clickLoginButton() {
        loginButton.click();
        ProjectsPage projects = new ProjectsPage(driver);
        projects.isPageOpened();
        return projects;
    }

    public void checkSuccessfulLogin() {
        WebElement projectsTitle = driver.findElement(By.cssSelector(".nav-link"));
        assertTrue(projectsTitle.isDisplayed(), "Looks like you are not logged in");
    }

    public void login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
    }
}
