package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstName("first name").withLastName("last name").
                    withAddress("address").withEmail1("example@mail.com").withHomePhone("+46 8 64 25 66").
                    withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = 0;
        ContactData newContact = new ContactData().withId(before.get(index).getId()).withFirstName("1111").withLastName("2222").
                withAddress("address").withEmail1("example@mail.com").withHomePhone("+46 8 64 25 66").
                withGroup("test1");
        app.contact().modify(index, newContact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(newContact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
