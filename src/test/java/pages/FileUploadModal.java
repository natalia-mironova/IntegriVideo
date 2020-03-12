package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadModal extends BasePage {

    public FileUploadModal(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
    }

    public void fileUploadModalOpen() {
        driver.findElement(By.cssSelector(".integri-chat-manual-upload.integri-pointer")).click();
    }

    public void uploadFile(String... files) {
        WebElement upload = driver.findElement(By.cssSelector("[accept='*']"));
        for(int i = 0; i < files.length; i ++) {
            upload.sendKeys(System.getProperty("user.dir") + files[i]);
        }
    }

    public void startClick() {
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }

}
