package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsModal extends BasePage {

    public SettingsModal(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void openSettingsModal() {
        driver.findElement(By.className("iv-icon-cog")).click();
    }

    public void editName() {
        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
        name.sendKeys(Keys.CONTROL, "a");
        name.sendKeys(Keys.DELETE);
        name.sendKeys("Natalia");
    }

    public void enterEmail() {
        driver.findElement(By.cssSelector("[type='email']")).sendKeys("natalia@tut.by");
    }

    public void enterPhotoUrl() {
        driver.findElement(By.cssSelector("[type='url']")).sendKeys("https://pixabay.com/images/search/dog/");
    }

    public void clickSaveSettings() {
        driver.findElement(By.className("integri-user-settings-save"));
    }
}
