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

    public void uploadFile() {
        WebElement upload = driver.findElement(By.cssSelector("[accept='*']"));
        upload.sendKeys("C:/Users/Lenovo/IdeaProjects/IntegriVideo/src/main/resources/Homework1.docx");
        //НЕ работает с относительным путем "src/main/resources/bug.jpg"
    }

    public void uploadFiles() {
        WebElement upload = driver.findElement(By.cssSelector("[accept='*']"));
        upload.sendKeys("C:/Users/Lenovo/IdeaProjects/IntegriVideo/src/main/resources/Homework1.docx");
        upload.sendKeys("C:/Users/Lenovo/IdeaProjects/IntegriVideo/src/main/resources/Homework2.docx");
    }

    public void startClick() {
        driver.findElement(By.cssSelector(".integri-file-upload-start")).click();
    }

}
