package tests;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test
    public void loginIntoAccount() {
        loginPage.openLoginPage();
        loginPage.login("natalia16@mailinator.com", "admin123");
        loginPage.checkSuccessfulLogin();
    }
}
