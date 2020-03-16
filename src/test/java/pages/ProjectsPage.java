package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProjectsPage extends BasePage {
    //это зачем-то добавили на лекции
    // By addProject = By.cssSelector(".iv-icon-file-add");

    WebDriverWait wait = new WebDriverWait(driver, 10);
    @FindBy(css = ".iv-icon-file-add")
    WebElement lastLoadedIcon;
    @FindBy(name = "name")
    WebElement projectNameElement;
    @FindBy(tagName = "textarea")
    WebElement projectDescriptionElement;
    @FindBy(name = "domains[]")
    WebElement domainsElement;
    @FindBy(xpath = "//button[@class='btn']")
    WebElement createUpdateButton;
    @FindBy(linkText = "Edit")
    WebElement editLink;
    @FindBy(css = "input[name='name']")
    WebElement editName;

    public ProjectsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProjectsPage openPage() {
        return this;
    }

    // OPEN PROJECTS PAGE
    public ProjectsPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(lastLoadedIcon));
        return this;
    }

    //OPEN CREATE NEW PROJECT PAGE
    public ProjectsPage createProjectPageOpen() {
        lastLoadedIcon.click();
        return this;
    }

    public void createProjectPageOpenCheck() {
        String url = driver.getCurrentUrl();
        assertEquals(url, "https://dev.integrivideo.com/app/projects/new", "Projects page is not opened");
    }

    //CREATE PROJECT
    public void createProject(String projectName, String projectDescription, String... domains) {
        projectNameElement.sendKeys(projectName);
        projectDescriptionElement.sendKeys(projectDescription);
        domainsElement.sendKeys(domains);
        createUpdateButton.click();
        wait.until(ExpectedConditions.urlToBe("https://dev.integrivideo.com/app/projects"));
    }

    public void checkProjectCreated() {
        String isProjectCreated = driver.getCurrentUrl();
        assertEquals(isProjectCreated, "https://dev.integrivideo.com/app/projects", "Project was not created");
    }

    //OPEN EDIT PROJECT PAGE
    public void editProjectPageOpen(int i) {
        List<WebElement> projectsList = driver.findElements(By.cssSelector(".text-capitalize"));
        projectsList.get(i).click();
        WebElement isEditPageOpened = driver.findElement(By.cssSelector(".col-12.description"));
        assertTrue(isEditPageOpened.isDisplayed(), "Edit page is not opened");
        editLink.click();
        WebElement editBreadCrumbs = driver.findElement(By.xpath("//*[text()='Edit']"));
        assertTrue(editBreadCrumbs.isDisplayed(), "You're not on 'Edit Project' page");
    }

    public void editProjectName(String editedProjectName) {
        editName.sendKeys(Keys.CONTROL + "a");
        editName.sendKeys(Keys.DELETE);
        editName.sendKeys(editedProjectName);
    }

    public void editedProjectDescription(String editedProjectDescription) {
        projectDescriptionElement.sendKeys(Keys.CONTROL + "a");
        projectDescriptionElement.sendKeys(Keys.DELETE);
        projectDescriptionElement.sendKeys(editedProjectDescription);
    }

    public void editDomain(String editedDomain) {
        domainsElement.sendKeys(Keys.CONTROL + "a");
        domainsElement.sendKeys(Keys.DELETE);
        domainsElement.sendKeys(editedDomain);
    }

    public void editButtonClick() {
        createUpdateButton.click();
        wait.until(ExpectedConditions.urlToBe("https://dev.integrivideo.com/app/projects"));
    }

    public void isProjectEdited() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://dev.integrivideo.com/app/projects", "Projects page is not opened after project was edited");
    }

    public void addNewDomain(String newDomain) {
        List<WebElement> domainsList = driver.findElements(By.name("domains[]"));
        int count = domainsList.size();
        domainsList.get(count - 1).sendKeys(newDomain);
        createUpdateButton.click();
    }

    //ДОДЕЛАТЬ
    public void removeDomain() {
        List<WebElement> domainsList = driver.findElements(By.name("domains[]"));
        int count = domainsList.size();
        domainsList.get(count - 1).click();
        createUpdateButton.click();
    }
}
