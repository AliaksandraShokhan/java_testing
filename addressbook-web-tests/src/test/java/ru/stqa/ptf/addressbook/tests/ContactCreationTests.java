package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    List<ContactData> before = app.getContactsHelper().getContactList();
    app.getContactsHelper().createContact(new ContactData("firstname", "middlename", "lastname",
            "nickname", "title", "company", "address", "hometelephone",
            "mobiletelephone", "work telephone", "fax", "email@sample.com",
            "email2@sample.com", "email@sample.com", "www.site.org", "2",
            "April", "1990", "6", "April", "1900",
            "test1", "address", "home", "notes"));
    List<ContactData> after = app.getContactsHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.getSessionHelper().logout();
  }
}
