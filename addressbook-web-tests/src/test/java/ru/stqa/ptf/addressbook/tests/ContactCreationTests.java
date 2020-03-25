package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.getContactsHelper().initContactCreation();
    app.getContactsHelper().fillContactForm(new ContactData("firstname", "middlename", "lastname",
            "nickname", "title", "company", "address", "hometelephone",
            "mobiletelephone", "work telephone", "fax", "email@sample.com",
            "email2@sample.com", "email@sample.com", "www.site.org", "2",
            "April", "1990", "6", "April", "1900",
            "test0", "address", "home", "notes"));
    app.getContactsHelper().submitContactCreation();
    app.getContactsHelper().viewHomepage();
    app.getSessionHelper().logout();
  }
}
