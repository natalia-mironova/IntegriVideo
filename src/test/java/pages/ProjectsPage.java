package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProjectsPage extends BasePage {
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void createProjectPageOpen() {
        driver.findElement(By.cssSelector(".iv-icon-file-add")).click();
    }

    public void createProjectPageOpenCheck() {
        WebElement projectLink = driver.findElement(By.linkText("Projects"));
        assertTrue(projectLink.isDisplayed(), "Projects page is not opened");
    }

    public void createProject(String projectName, String projectDescription, String... domains) {
        driver.findElement(By.name("name")).sendKeys(projectName);
        driver.findElement(By.tagName("textarea")).sendKeys(projectDescription);
        driver.findElement(By.name("domains[]")).sendKeys(domains);
        driver.findElement(By.xpath("//button[@class='btn']")).click();
    }

    public void checkProjectCreated(){
        WebElement createdProject = driver.findElement(By.cssSelector(".text-capitalize"));
        assertTrue(createdProject.isDisplayed(), "Project was not created");
    }

    public void editProject() {
       List<WebElement> projectsList = driver.findElements(By.cssSelector(".text-capitalize"));
       projectsList.get(2).click();
       WebElement isEditPageOpened = driver.findElement(By.cssSelector(".col-12.description"));
       assertTrue(isEditPageOpened.isDisplayed(), "Edit page is not opened");

       driver.findElement(By.linkText("Edit")).click();
       WebElement editBreadCrumbs = driver.findElement(By.xpath("//*[text()='Edit']"));
       assertTrue(editBreadCrumbs.isDisplayed(), "You're not on 'Edit Project' page");

       // to be continued..

    }
}
