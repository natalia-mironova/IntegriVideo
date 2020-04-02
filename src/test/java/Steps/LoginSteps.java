package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage page;

    public LoginSteps(WebDriver driver) {
        page = new LoginPage(driver);
    }

    @Step("User loggs in into the account Step")
    public LoginSteps loginIntoAccountStep(String email, String password) {
        page
                .openLoginPage()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
        return this;
    }

    @Step("Successful Login Validation Step")
    public LoginSteps loginValidationStep() {
        page.checkSuccessfulLogin();
        return this;
    }
}


