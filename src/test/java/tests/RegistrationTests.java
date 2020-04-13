package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {
    @Test
    public void registerAccount() {
        registration.openPage();
        registration.isPageOpened();
        registration.register();
// Not able to bypass reCaptcha = disabling the step

    }
}
