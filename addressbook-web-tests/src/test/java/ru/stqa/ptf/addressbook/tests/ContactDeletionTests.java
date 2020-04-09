package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {

        if (!app.getContactsHelper().isThereAContact()) {
            app.getContactsHelper().createContact(new ContactData("firstname", "middlename", "lastname",
                    "nickname", "title", "company", "address", "hometelephone",
                    "mobiletelephone", "work telephone", "fax", "email@sample.com",
                    "email2@sample.com", "email@sample.com", "www.site.org", "2",
                    "April", "1990", "6", "April", "1900",
                    "test1", "address", "home", "notes"));
        }
        List<ContactData> before = app.getContactsHelper().getContactList();
        app.getContactsHelper().selectContact(0);
        app.getContactsHelper().initContactDeletion();
        app.getContactsHelper().confirmDeletion();
        if (app.getContactsHelper().isDeletionConfirmed()) {
            app.getNavigationHelper().goToHomePage();
        }
        List<ContactData> after = app.getContactsHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }
}
