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
            app.contact().create(new ContactData("firstname", "middlename", "lastname",
                    "nickname", "title", "company", "address", "hometelephone",
                    "mobiletelephone", "work telephone", "fax", "email@sample.com",
                    "email2@sample.com", "email@sample.com", "www.site.org", "2",
                    "April", "1990", "6", "April", "1900",
                    "test4", "address", "home", "notes"));
        }
    }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int index = 0;
        ContactData newContact = new ContactData(before.get(index).getId(), "123", "456", "789",
                "nickname", "title", "company", "address", "hometelephone",
                "mobiletelephone", "work telephone", "fax", "email@sample.com",
                "email2@sample.com", "email@sample.com", "www.site.org", "2",
                "April", "1990", "6", "April", "1900",
                null, "address", "home", "was edited");
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
