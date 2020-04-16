package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().GroupsPage();
        Groups before = app.group().all();
        GroupData newGroup = new GroupData().withName("test1");
        app.group().create(newGroup);
        assertThat(app.group().count(), equalTo((before.size() + 1)));
        Groups after = app.group().all();
        assertThat(after, equalTo(
                before.withAdded(newGroup.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadGroupCreation() {

        app.goTo().GroupsPage();
        Groups before = app.group().all();
        GroupData newGroup = new GroupData().withName("test1'");
        app.group().create(newGroup);
        assertThat(app.group().count(), equalTo((before.size())));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }
}
