package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {
    private ChromeDriver wd;

    public NavigationHelper(ChromeDriver wd) { super(wd); }

    public void goToGroupsPage() {
        click(By.linkText("groups"));
    }
}
