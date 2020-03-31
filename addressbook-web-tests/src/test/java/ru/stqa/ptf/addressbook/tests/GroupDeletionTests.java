package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupsPage();

        if (!app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test1", null, null));
        }

        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().deleteSelectedGroups();
        app.getNavigationHelper().goToGroupsPage();
    }
}
