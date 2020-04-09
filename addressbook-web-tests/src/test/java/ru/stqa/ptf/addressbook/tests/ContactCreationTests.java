package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {

        List<ContactData> before = app.getContactsHelper().getContactList();
        ContactData newContact = new ContactData("firstname", "middlename", "lastname",
                "nickname", "title", "company", "address", "hometelephone",
                "mobiletelephone", "work telephone", "fax", "email@sample.com",
                "email2@sample.com", "email@sample.com", "www.site.org", "2",
                "April", "1990", "6", "April", "1900",
                "test1", "address", "home", "notes");
        app.getContactsHelper().createContact(newContact);
        List<ContactData> after = app.getContactsHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
        app.getSessionHelper().logout();

        int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        newContact.setId(max);
        before.add(newContact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
