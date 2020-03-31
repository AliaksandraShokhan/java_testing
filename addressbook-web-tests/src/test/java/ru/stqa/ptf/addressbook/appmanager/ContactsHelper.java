package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactsHelper extends HelperBase {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("nickname"), contactData.getNickName());
        type(By.name("title"), contactData.getTitle());
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

        if (creation) {
            click(By.name("new_group"));
            select(By.name("new_group"), contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

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

    public void initContactModification() { click(By.xpath("//img[@alt='Edit']")); }

    public void submitContactModification() { click((By.name("update"))); }

    public void returnToHomePage() { click(By.linkText("home page")); }

    public void selectContact() { click(By.name("selected[]")); }

    public void initContactDeletion() { click(By.xpath("//input[@value='Delete']")); }

    public void confirmDeletion() { confirmAlert(); }
}
