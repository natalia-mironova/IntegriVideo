package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Severity(SeverityLevel.NORMAL) //Severity for report
    @Test(description = "User loggs in into account", priority = 1) //название теста
    @Description("Check if user is able to login into account")
    @Link("https://dev.integrivideo.com/login") //Link
    @Issue("linkToBugReport") //Link from allure.properties + то, что в кавычках тут
    @TmsLink("linkToTestCaseInTmsSystem") //Link from allure.properties + то, что в кавычках тут
    public void loginIntoAccount() {
        steps.loginIntoAccountStep("natalia16@mailinator.com", "admin123");

        //The following was used when we did not use Steps
//        loginPage
//                .openLoginPage()
//                .enterEmail("natalia16@mailinator.com")
//                .enterPassword("admin123")
//                .clickLoginButton();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Check if login successful", priority = 2) //название теста
    @Description("Validation of successful login")
    @Issue("linkToBugReport") //Link from allure.properties + то, что в кавычках тут
    @TmsLink("linkToTestCaseInTmsSystem") //Link from allure.properties + то, что в кавычках тут
    public void checkIfLoggedIn() {
        steps.loginIntoAccountStep("natalia16@mailinator.com", "admin123");
        steps.loginValidationStep();

        //The following was used when we did not use Steps
//        loginIntoAccount();
//        loginPage.checkSuccessfulLogin();
    }

}
