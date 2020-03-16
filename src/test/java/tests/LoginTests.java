package tests;

import models.User;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test
    public void loginIntoAccount() {
        loginPage
                .openLoginPage()
                .enterEmail("natalia16@mailinator.com")
                .enterPassword("admin123")
                .clickLoginButton();
    }

    @Test
    public void checkIfLoggedIn(){
        loginPage.checkSuccessfulLogin();
    }

    @Test
    public void login(){
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .openLoginPage()
                .login(user);
    }
}
