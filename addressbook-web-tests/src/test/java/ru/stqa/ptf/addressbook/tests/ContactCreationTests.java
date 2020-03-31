package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    app.getContactsHelper().createContact(new ContactData("firstname", "middlename", "lastname",
            "nickname", "title", "company", "address", "hometelephone",
            "mobiletelephone", "work telephone", "fax", "email@sample.com",
            "email2@sample.com", "email@sample.com", "www.site.org", "2",
            "April", "1990", "6", "April", "1900",
            "test4", "address", "home", "notes"));
    app.getSessionHelper().logout();
  }


}
