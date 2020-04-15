package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        Set<ContactData> before = app.contact().all();
        ContactData newContact = new ContactData().withFirstName("first name").withLastName("last name").
                withAddress("address").withEmail1("example@mail.com").withHomePhone("+46 8 64 25 66").withGroup("test1");
        app.contact().create(newContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        newContact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(newContact);
        Assert.assertEquals(before, after);
    }
}
