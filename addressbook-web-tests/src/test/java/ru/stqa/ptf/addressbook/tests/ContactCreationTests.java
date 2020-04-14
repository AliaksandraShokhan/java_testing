package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        List<ContactData> before = app.contact().list();
        ContactData newContact = new ContactData("firstname", "middlename", "lastname",
                "nickname", "title", "company", "address", "hometelephone",
                "mobiletelephone", "work telephone", "fax", "email@sample.com",
                "email2@sample.com", "email@sample.com", "www.site.org", "2",
                "April", "1990", "6", "April", "1900",
                "test1", "address", "home", "notes");
        app.contact().create(newContact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(newContact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
