package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupsPage();
        int before = app.getGroupsHelper().getGroupCount();
        if (!app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupsHelper().selectGroup(before - 1);
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test4", "test4", "test4"));
        app.getGroupsHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupsPage();
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
