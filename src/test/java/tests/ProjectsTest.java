package tests;

import models.User;
import org.testng.annotations.Test;

public class ProjectsTest extends BaseTest {

    @Test
    public void projectsPageOpen() {
        loginPage.openLoginPage();
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .login(user);
        projectsPage.isPageOpened();
    }

    @Test
    public void createProjectPageOpen() {
        loginPage.openLoginPage();
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .login(user);
        projectsPage
                .createProjectPageOpen()
                .createProjectPageOpenCheck();
    }

    @Test
    public void createProject() {
        loginPage.openLoginPage();
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .login(user);
        projectsPage.createProjectPageOpen();
        projectsPage.createProject("Project Dev.by",
                "Project for IT specialists",
                "dev.by");
        projectsPage.checkProjectCreated();
    }

    @Test
    public void editProject() {
        loginPage.openLoginPage();
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .login(user);
        projectsPage.editProjectPageOpen(6);
        projectsPage.editProjectName("New Project Name");
        projectsPage.editedProjectDescription("New Project Description");
        projectsPage.editDomain("mail.ru");
        projectsPage.editButtonClick();
        projectsPage.isProjectEdited();
    }

    @Test
    public void addDomain() {
        loginPage.openLoginPage();
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .login(user);
        projectsPage.editProjectPageOpen(2);
        projectsPage.addNewDomain("yandex.ru");
    }

    @Test
    public void removeDomain() {
        loginPage.openLoginPage();
        User user = new User("natalia16@mailinator.com", "admin123");
        loginPage
                .login(user);
        projectsPage.editProjectPageOpen(2);
        projectsPage.removeDomain();
    }
}
