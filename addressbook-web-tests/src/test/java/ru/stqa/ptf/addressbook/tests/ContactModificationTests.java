package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstName("first name").withLastName("last name").
                    withAddress("address").withEmail1("example@mail.com").withHomePhone("+46 8 64 25 66"));
        }
    }

    @Test
    public void testContactModification() {

        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData newContact = new ContactData().withId(modifiedContact.getId()).withFirstName("343").withLastName("6543").
                withAddress("address").withEmail1("example@mail.com").withHomePhone("+46 8 64 25 66");
        app.contact().modify(newContact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(newContact)));
    }
}
