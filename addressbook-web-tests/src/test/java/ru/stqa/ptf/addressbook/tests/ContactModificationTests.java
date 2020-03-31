package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactsHelper().selectContact();
        app.getContactsHelper().initContactModification();
        app.getContactsHelper().editContactForm(new ContactData("123", "456", "789",
                "nickname", "title", "company", "address", "hometelephone",
                "mobiletelephone", "work telephone", "fax", "email@sample.com",
                "email2@sample.com", "email@sample.com", "www.site.org", "2",
                "April", "1990", "6", "April", "1900",
                "test1", "address", "home", "notes"));
        app.getContactsHelper().submitContactModification();
        app.getContactsHelper().returnToHomePage();
    }
}
