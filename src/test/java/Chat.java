import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Chat extends BeforeAfter {
    @Ignore
    @Test
    public void chat() {
        browser.get("https://dev.integrivideo.com/demo/5e5ba38d46d9274aec5167db");

        browser.findElement(By.id("invite-users-to-chat")); //'invite users to the chat' element
        browser.findElement(By.cssSelector("textarea[placeholder='Start typing here']")); //text area (input)
        //Когда нужны одинарные кавычки - а когда нет?

        browser.findElement(By.className("iv-icon-paper-plane")); //значок отправить
        browser.findElement(By.className("iv-icon-camera")); //значок камеры
        browser.findElement(By.className("integri-watermark")); //иконка Integri Video в чате

        //Settings modal popup
        WebElement settings = browser.findElement(By.className("iv-icon-cog")); //Settings
        settings.click();
        WebElement heading = browser.findElement(By.className("integri-modal-head")); //popup heading
        heading.getText(); //взять текст названия, если надо
        browser.findElement(By.cssSelector("[type='text']"));
        browser.findElement(By.cssSelector("[type='email']"));
        browser.findElement(By.cssSelector("[type='url']"));
        WebElement cancel = browser.findElement(By.linkText("Cancel"));
        browser.findElement(By.className("integri-user-settings-save"));
        browser.findElement(By.cssSelector(".integri-modal-shown .close-integri-modal"));
        cancel.click();

        //Drag&Drop modal popup
        WebElement dragDrop = browser.findElement(By.cssSelector(".integri-chat-manual-upload.integri-pointer")); //Drag&Drop copy
        dragDrop.click();
        browser.findElement(By.cssSelector(".integri-file-upload-manual-init")); // browse link
        browser.findElement(By.cssSelector(".integri-file-upload-start")); // start button
        browser.findElement(By.cssSelector(".integri-file-upload-cancel")); // cancel button
        WebElement closeDragDrop = browser.findElement(By.cssSelector(".integri-modal-shown .close-integri-modal"));
        closeDragDrop.click();

        browser.findElement(By.xpath("//div[@class='integri-session-user-name']/span[@class='integri-session-user-name']")); //Current Username
        browser.findElement(By.xpath("//div[@class='integri-chat-session']/div[1]/span[@class='iv-icon iv-icon-user']")); //Current user avatar

        browser.findElement(By.xpath("//div[1]/div[@class='integri-chat-message-user']/div/span[@class='iv-icon iv-icon-user']")); //иконка юзера, написавшего сообщение1
        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[1]//span[@class='integri-session-user-name']")); //Username against message1
        //следующие 2 строки не работают
//        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[1]//div[@class='integri-chat-message-manage']/span[1]")); //edit message1
//        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[1]//div[@class='integri-chat-message-manage']/span[2]"));//remove message1
        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[1]//span[@class='integri-chat-message-date']"));//message1 date

        browser.findElement(By.xpath("//div[2]/div[@class='integri-chat-message-user']/div/span[@class='iv-icon iv-icon-user']")); //иконка юзера, написавшего сообщение2
        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[2]//span[@class='integri-session-user-name']")); //Username against message2
        //следующие 2 строки не работают
//        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[2]//div[@class='integri-chat-message-manage']/span[1]")); //edit message2
//        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[2]//div[@class='integri-chat-message-manage']/span[2]"));//remove message2
        browser.findElement(By.xpath("//div[@class='integri-chat-messages']/div[2]//span[@class='integri-chat-message-date']"));//message2 date


    }
}
