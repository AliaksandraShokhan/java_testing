package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

    public SessionHelper(ApplicationManager app) {
        super(app);
        this.app = app;
        wd = app.getDriver();
    }

    public void login(String username, String password) {

        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Login']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void loginAsAdmin() {

        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), app.getProperty("web.adminLogin"));
        click(By.cssSelector("input[value='Login']"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.cssSelector("input[value='Login']"));
    }
}
