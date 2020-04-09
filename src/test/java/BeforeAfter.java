import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;

import java.util.concurrent.TimeUnit;

public class BeforeAfter {

    protected WebDriver browser;

    @Ignore
    @BeforeClass
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Ignore
    @AfterClass
    public void after() {
        browser.quit();
    }

}

