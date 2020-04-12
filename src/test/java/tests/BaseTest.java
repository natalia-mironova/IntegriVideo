package tests;

import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
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
    public void setDriver(ITestContext context) {
        //adding ITestContext context for IListener (screenshots)
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //adding context for taking screenshots
        context.setAttribute("driver", driver);

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
