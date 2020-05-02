package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("first name").withLastName("last name")
                    .withAddress("address").withEmail1("example1@mail.com").withEmail2("example2@mail.com").withEmail3("example3@mail.com").
                    withHomePhone("+46 8 64 25 66").withMobilePhone("234567").withWorkPhone("56789"));
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}
