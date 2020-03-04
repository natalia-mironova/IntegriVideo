package tests;

import org.testng.annotations.Test;

public class ChatTests extends BaseTest {
    @Test(invocationCount = 1) //запускаю N раз
    //ОТПРАВИТЬ СООБЩЕНИЕ НАЖАТИЕМ КНОПКИ "ОТПРАВИТЬ"
    public void sendMessageSendButton() {
        //open page
        //Find text area and input text
        //Find button click
        //Validate that message exists
        chatPage.openPage();
        chatPage.writeText("Test");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "Test"); //первое сообщение должно содержать Test
    }

    @Test
    //ОТПРАВИТЬ СООБЩЕНИЕ НАЖАТИЕМ ENTER
    public void sendMessageEnter() {
        chatPage.openPage();
        chatPage.writeText("Test");
        chatPage.tapEnter();
        chatPage.messageShouldExist(1, "Test"); //первое сообщение должно содержать Test
    }

    @Test
    //ОТПРАВИТЬ ССЫЛКУ
    public void messageWithUrl() {
        chatPage.openPage();
        chatPage.writeText("https://docs.google.com/spreadsheets/d/1-cgTVy8Z2AO0o9Wq6b7wfT15fuCrfmpBwNCymxwmQPY/edit#gid=0");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "https://docs.google.com/spreadsheets/d/1-cgTVy8Z2AO0o9Wq6b7wfT15fuCrfmpBwNCymxwmQPY/edit#gid=0");
    }

    @Test
    //ОТПРАВИТЬ JS/HTML
    public void messageJs() {
        chatPage.openPage();
        chatPage.writeText("<html><body><p>test</p></body></html>");
        chatPage.clickSend();
        chatPage.messageShouldExist(1, "test");
    }

    @Test
    //РЕДАКТИРОВАТЬ СООБЩЕНИЕ
    public void editMessage() {
        chatPage.openPage();
        chatPage.writeText("Natalia");
        chatPage.clickSend();
        chatPage.editMessage();
    }

    @Test
    //РЕДАКТИРОВАТЬ СООБЩЕНИЕ УДАЛИВ ЕГО (ПОЛУЧАЕМ ОШИБКУ)
    public void editViaFullRemoveError() {
        chatPage.openPage();
        chatPage.writeText("Natalia");
        chatPage.clickSend();
        chatPage.editFullRemove();
    }

    @Test
    //УДАЛИТЬ СООБЩЕНИЕ
    public void deleteMessage() {
        chatPage.openPage();
        chatPage.writeText("Natalia");
        chatPage.clickSend();
        chatPage.deleteMessage();
    }

    @Test
    //ОТПРАВИТЬ 11 СООБЩЕНИЙ, ПОЛУЧИТЬ ОШИБКУ, ЗАКРЫТЬ ОКНО ОШИБКИ
    public void testTrial() {
        chatPage.openPage();
        chatPage.writeText11Times("Natalia");
        chatPage.isDemoVersion();
    }

    @Test
    //ПРИГЛАСИТЬ УЧАСТНИКОВ
    public void clickInviteButton() {
        //open page
        //нажимаю Invite
        //проверяю, что current URL = copied URL
        chatPage.openPage();
        chatPage.clickInviteButton();
        chatPage.clipboardShouldContainCurrentUrl();
    }

    @Test
    //ПРОВЕРИТЬ РАБОТУ КНОПКИ С КОДОМ
    //А ЧТО ДОЛЖНА ДЕЛАТЬ КНОПКА С КОДОМ?
    public void codeCopy() {
        chatPage.openPage();
        chatPage.codeCopy();
    }

}
