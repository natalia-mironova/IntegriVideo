package tests;

import org.testng.annotations.Test;

public class ProjectsTest extends BaseTest {
    @Test
    public void createProject() {
        loginPage.openLoginPage();
        loginPage.login("natalia16@mailinator.com", "admin123");

        projectsPage.createProjectPageOpen();
        projectsPage.createProjectPageOpenCheck();
        projectsPage.createProject("Project Dev.by",
                "Project for IT specialists",
                "dev.by");
        projectsPage.checkProjectCreated();

    }

    @Test
    public void editProject() {
        loginPage.openLoginPage();
        loginPage.login("natalia16@mailinator.com", "admin123");

        projectsPage.editProject();
    }
}
