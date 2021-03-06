package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChatPage extends BasePage {

    private final static By CHAT_INPUT = By.cssSelector("textarea");

    public ChatPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @Override
//    public BasePage openPage() {
//        return null;
//    }

    public BasePage openPage() {
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        return this;
    }

    public void writeText(String text) {
        driver.findElement(CHAT_INPUT).sendKeys(text);
    }

    public void writeText11Times(String text) {
        for (int i = 0; i < 11; i++) {
            driver.findElement(CHAT_INPUT).sendKeys(text);
            clickSend();
            WebElement a = driver.findElement(By.xpath("//tag[contains(text(),'text')]"));
            wait.until(ExpectedConditions.visibilityOf(a));
            //не работает
        }
    }

    public void isDemoVersion() {
        WebElement demo = driver.findElement(By.cssSelector(".integri-demo-version"));
        assertTrue(demo.isDisplayed(), "Demo version message is not shown");
    }

    public void clickSend() {
        driver.findElement(By.className("iv-icon-paper-plane")).click(); //значок отправить
    }

    public void tapEnter() {
        driver.findElement(CHAT_INPUT).sendKeys(Keys.ENTER);
    }

    public void editMessage() {
        List<WebElement> editMessageElement = driver.findElements(By.cssSelector(".iv-icon.iv-icon-pencil.integri-chat-edit-message"));
        editMessageElement.get(0).click();
        driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        driver.findElement(By.cssSelector("textarea")).sendKeys("Second Message Edited");
        driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ENTER);
    }

    public void editFullRemove() {
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-pencil.integri-chat-edit-message")).click();
        driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.CONTROL, "a" + Keys.DELETE);
        driver.findElement(By.cssSelector("textarea")).sendKeys(Keys.ENTER);
        WebElement notify = driver.findElement(By.cssSelector(".integri-notify.integri-notify-error"));
        boolean isExist = notify.getText().equals("Message cannot be empty!");
        assertTrue(isExist, "Error message is not shown");
    }

    public void deleteMessage() {
        driver.findElement(By.cssSelector(".iv-icon.iv-icon-trash2.integri-chat-remove-message")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void messageShouldExist(int messageIndex, String text) {
        //просим подождать
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> messages = driver.findElements(By.cssSelector(".integri-chat-message-text")); //ищем все сообщеньки в чате (надо знать, сколько их)
        boolean isExist = messages.get(messageIndex - 1).getText().equals(text);
        assertTrue(isExist, "Message does not exist");
    }

    public void clickInviteButton() {
        driver.findElement(By.id("invite-users-to-chat")).click();
    }

    public void clipboardShouldContainCurrentUrl() {
        //дальше какая-то хрень чтобы достать что в буфере обмена
        try {
            String data = (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            String currentUrl = driver.getCurrentUrl();
            assertEquals(currentUrl, data, "URLs do not match"); //тут проверяю, что current URL такой же как в буфере обмена

        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyCode() {
        driver.findElement(By.cssSelector(".component-code")).click();
    }
}
