package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("first name").withLastName("last name")
                    .withAddress("address").withEmail1("example1@mail.com").withEmail2("example2@mail.com").withEmail3("example3@mail.com").
                    withHomePhone("+46 8 64 25 66").withMobilePhone("234567").withWorkPhone("56789").withGroup("test1"));
        }
    }

    @Test
    public void testContactEmail() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> s!= null && !s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
