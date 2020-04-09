package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {

        if (!app.getContactsHelper().isThereAContact()) {
            app.getContactsHelper().createContact(new ContactData("firstname", "middlename", "lastname",
                    "nickname", "title", "company", "address", "hometelephone",
                    "mobiletelephone", "work telephone", "fax", "email@sample.com",
                    "email2@sample.com", "email@sample.com", "www.site.org", "2",
                    "April", "1990", "6", "April", "1900",
                    "test4", "address", "home", "notes"));
        }
        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().selectContact(0);
        app.getContactsHelper().initContactModification();
        ContactData newContact = new ContactData(before.get(0).getId(),"123", "456", "789",
                "nickname", "title", "company", "address", "hometelephone",
                "mobiletelephone", "work telephone", "fax", "email@sample.com",
                "email2@sample.com", "email@sample.com", "www.site.org", "2",
                "April", "1990", "6", "April", "1900",
                null, "address", "home", "was edited");
        app.getContactsHelper().fillContactForm(newContact, false);
        app.getContactsHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactsHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(newContact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
