package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstName("first name").withLastName("last name").
                    withAddress("address").withEmail1("example@mail.com").withHomePhone("+46 8 64 25 66").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() {

        List<ContactData> before = app.contact().list();
        int index = 0;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
