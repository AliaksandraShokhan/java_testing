package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        GroupData newGroup = new GroupData("test1", null, null);
        app.getGroupsHelper().createGroup(newGroup);
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);
        app.logout();

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        newGroup.setId(max);
        before.add(newGroup);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
