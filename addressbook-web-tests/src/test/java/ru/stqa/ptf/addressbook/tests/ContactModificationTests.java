package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        int before = app.getContactsHelper().getContactCount();
        if (!app.getContactsHelper().isThereAContact()) {
            app.getContactsHelper().createContact(new ContactData("firstname", "middlename", "lastname",
                    "nickname", "title", "company", "address", "hometelephone",
                    "mobiletelephone", "work telephone", "fax", "email@sample.com",
                    "email2@sample.com", "email@sample.com", "www.site.org", "2",
                    "April", "1990", "6", "April", "1900",
                    "test4", "address", "home", "notes"));
        }
        app.getContactsHelper().selectContact(0);
        app.getContactsHelper().initContactModification();
        app.getContactsHelper().fillContactForm(new ContactData("123", "456", "789",
                "nickname", "title", "company", "address", "hometelephone",
                "mobiletelephone", "work telephone", "fax", "email@sample.com",
                "email2@sample.com", "email@sample.com", "www.site.org", "2",
                "April", "1990", "6", "April", "1900",
                null, "address", "home", "was edited"), false);
        app.getContactsHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        int after = app.getContactsHelper().getContactCount();
        Assert.assertEquals(after, before);
    }
}
