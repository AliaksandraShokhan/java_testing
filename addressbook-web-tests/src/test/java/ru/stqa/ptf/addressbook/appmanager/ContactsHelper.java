package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(ChromeDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
        click(By.name("theform"));
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        click(By.name("bday"));
        select(By.name("bday"), contactData.getBirthdayDay());
        click(By.name("bmonth"));
        select(By.name("bmonth"), contactData.getBirthdayMonth());
        click(By.name("byear"));
        click(By.name("byear"));
        type(By.name("byear"), contactData.getBirthdayYear());
        click(By.name("aday"));
        select(By.name("aday"), contactData.getAnniversDay());
        click(By.name("amonth"));
        select(By.name("amonth"), contactData.getAnniversMonth());
        click(By.name("ayear"));
        type(By.name("ayear"), contactData.getAnniversYear());
        click(By.name("new_group"));
        select(By.name("new_group"), contactData.getGroup());
        click(By.name("address2"));
        type(By.name("address2"), contactData.getAddressExtra());
        type(By.name("phone2"), contactData.getHomePhoneExtra());
        type(By.name("notes"), contactData.getNotes());
    }

    public void viewHomepage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
}