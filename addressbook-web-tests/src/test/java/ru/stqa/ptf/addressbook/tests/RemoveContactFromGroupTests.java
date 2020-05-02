package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactFromGroupTests extends TestBase {

    @BeforeMethod

    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().HomePage();
            app.contact().create(new ContactData().withFirstName("first name").withLastName("last name"));
        }

        if (app.db().groups().size() == 0) {
            app.goTo().GroupsPage();
            app.group().create(new GroupData().withName("name").withHeader("header").withFooter("footer"));
        }
    }

    @Test

    public void addContactToGroup() {

        GroupData groupToTest = selectGroupWithContact();
        Contacts contactsInGroupBefore = app.db().contactsInGroupByName(groupToTest.getName());

        ContactData contactToRemove = contactsInGroupBefore.iterator().next();
        Groups groupsForContactBefore = app.db().contactById(contactToRemove.getId()).getGroups();

        app.goTo().HomePage();
        app.contact().removeContactFromGroup(contactToRemove, groupToTest);

        Contacts groupsForContactAfter = app.db().contactsInGroupByName(groupToTest.getName());
        Groups contactsInGroupAfter = app.db().contactById(contactToRemove.getId()).getGroups();

        assertThat(contactsInGroupAfter.size(), equalTo(contactsInGroupBefore.size() - 1));
        assertThat(contactsInGroupAfter, equalTo(contactsInGroupBefore.without(app.db().contactById(contactToRemove.getId()))));

        assertThat(groupsForContactAfter.size(), equalTo(groupsForContactBefore.size() - 1));
        assertThat(groupsForContactAfter, equalTo(groupsForContactBefore.without(app.db().groupByName(groupToTest.getName()))));
    }

    private GroupData selectGroupWithContact() {
        Groups groups = app.db().groups();
        for (GroupData group : groups) {
            if (app.db().contactsInGroupByName(group.getName()).size() > 0) {
                return group;
            }
        }
        GroupData groupWithContact = groups.iterator().next();
        Contacts contacts = app.db().contacts();
        app.contact().addContactToGroup(contacts.iterator().next(), groupWithContact);
        app.goTo().HomePage();
        return groupWithContact;
    }
}
