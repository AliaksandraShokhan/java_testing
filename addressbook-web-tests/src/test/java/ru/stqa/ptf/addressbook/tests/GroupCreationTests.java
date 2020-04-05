package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        int before = app.getGroupsHelper().getGroupCount();

        app.getNavigationHelper().goToGroupsPage();
        app.getGroupsHelper().createGroup(new GroupData("test1", null, null));

        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after, before + 1);
        app.logout();
    }
}
