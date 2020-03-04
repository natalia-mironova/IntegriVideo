package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ChatPage;
import pages.FileUploadModal;
import pages.SettingsModal;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    ChatPage chatPage;
    FileUploadModal fileUploadModal;
    SettingsModal settingsModal;

    @BeforeMethod
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        chatPage = new ChatPage(driver); //инициализировали страницу (объект класса ChatPage)
        fileUploadModal = new FileUploadModal(driver);
        settingsModal = new SettingsModal(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void closeDriver(){
        driver.quit();
    }
}