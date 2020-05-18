package ru.stqa.ptf.addressbook.rf;

import org.openqa.selenium.remote.BrowserType;
import ru.stqa.ptf.addressbook.appmanager.ApplicationManager;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.io.IOException;

public class AddressbookKeywords {

    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    private ApplicationManager app;

    public void initApplicationManager() throws IOException {
        app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        app.init();
    }

    public void stopApplicationManager() {
        app.stop();
        app = null;
    }

    public int getGroupCount() {
        app.goTo().GroupsPage();
        return app.group().count();
    }

    public void createGroup(String name, String header, String footer) {
        app.goTo().GroupsPage();
        app.group().create(new GroupData().withName(name).withHeader(header).withFooter(footer));
    }
}
