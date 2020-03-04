package tests;

import org.testng.annotations.Test;

public class SettingsModalTests extends BaseTest {
    @Test
    public void manageSettings() {
        //open page
        //open settings modal
        //edit name
        //enter email
        //enter photo URL
        //click save
        settingsModal.openPage();
        settingsModal.openSettingsModal();
        settingsModal.editName();
        settingsModal.enterEmail();
        settingsModal.enterPhotoUrl();
        settingsModal.clickSaveSettings();
    }


}
