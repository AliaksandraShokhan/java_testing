package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws InterruptedException {
        app.getContactsHelper().selectContact();
        app.getContactsHelper().initContactDeletion();
        app.getContactsHelper().confirmDeletion();
    }
}
