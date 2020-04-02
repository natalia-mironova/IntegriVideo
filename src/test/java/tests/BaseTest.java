package tests;

import Steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    ChatPage chatPage;
    FileUploadModal fileUploadModal;
    SettingsModal settingsModal;
    Registration registration;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    protected LoginSteps steps;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        chatPage = new ChatPage(driver); //инициализировали страницу (объект класса ChatPage)
        fileUploadModal = new FileUploadModal(driver);
        settingsModal = new SettingsModal(driver);
        registration = new Registration(driver);
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        steps = new LoginSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing Chrome Driver")
    public void closeDriver() {
        driver.quit();
    }
}
