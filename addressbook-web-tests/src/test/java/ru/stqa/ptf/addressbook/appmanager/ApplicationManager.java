package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final Properties properties;
    WebDriver wd;

    private final String browser;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupsHelper groupsHelper;
    private ContactsHelper contactsHelper;
    private DbHelper dbHelper;

    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {

        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        dbHelper = new DbHelper();

        if("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            } else if (browser.equals(BrowserType.SAFARI)) {
                wd = new SafariDriver();
            }
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "MAC")));
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        groupsHelper = new GroupsHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
        contactsHelper = new ContactsHelper(wd);
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void stop() {
        wd.quit();
    }

    public GroupsHelper group() {
        return groupsHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() { return sessionHelper; }

    public ContactsHelper contact() { return contactsHelper; }

    public DbHelper db() {return  dbHelper; }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }
}
