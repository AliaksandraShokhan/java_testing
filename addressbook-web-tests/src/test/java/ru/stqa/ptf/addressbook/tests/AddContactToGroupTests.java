package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

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
        ContactData contactToTest = selectAvailableContact();
        GroupData groupToTest = selectAvailableGroup(contactToTest);

        Groups groupsForContactBefore = app.db().contactById(contactToTest.getId()).getGroups();
        Contacts contactsInGroupBefore = app.db().contactsInGroupByName(groupToTest.getName());

        app.goTo().HomePage();
        app.contact().addContactToGroup(contactToTest, groupToTest);

        Groups groupsForContactAfter = app.db().contactById(contactToTest.getId()).getGroups();
        Contacts contactsInGroupAfter = app.db().contactsInGroupByName(groupToTest.getName());

        assertThat(contactsInGroupAfter.size(), equalTo(contactsInGroupBefore.size() + 1));
        assertThat(contactsInGroupAfter, equalTo(contactsInGroupBefore.withAdded(app.db().contactById(contactToTest.getId()))));

        assertThat(groupsForContactAfter.size(), equalTo(groupsForContactBefore.size() + 1));
        assertThat(groupsForContactAfter, equalTo(groupsForContactBefore.withAdded(app.db().groupByName(groupToTest.getName()))));
    }

    public ContactData selectAvailableContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();
        for (ContactData contact : contacts) {
            if (contact.getGroups().size() < groups.size()) {
                return contact;
            }
        }
        app.goTo().HomePage();
        app.contact().create(new ContactData().withFirstName("first name").withLastName("last name"));
        Contacts newContact = app.db().contacts();
        return app.db().contactById(newContact.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    }

    private GroupData selectAvailableGroup(ContactData contact) {
        Groups groups = app.db().groups();
        Groups contactGroups = contact.getGroups();
        for (GroupData group : contactGroups) {
            groups.remove(group);
        }
        return groups.iterator().next();
    }
}
