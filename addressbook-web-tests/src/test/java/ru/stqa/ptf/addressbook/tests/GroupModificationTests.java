package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import javax.print.attribute.HashAttributeSet;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupsPage();
        if (!app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test1", null, null));
        }
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size() - 1);
        app.getGroupsHelper().initGroupModification();
        GroupData newGroup = new GroupData(before.get(before.size() - 1).getId(),"test4", "test4", "test4");
        app.getGroupsHelper().fillGroupForm(newGroup);
        app.getGroupsHelper().submitGroupModification();
        app.getNavigationHelper().goToGroupsPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(newGroup);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
