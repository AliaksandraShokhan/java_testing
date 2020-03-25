package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test0", "test5", "test9"));
        app.getGroupsHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupsPage();
    }
}
