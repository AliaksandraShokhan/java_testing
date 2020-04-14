package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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

    public void submitCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void initCreation() {
        click(By.linkText("add new"));
    }

    public void initModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitModification() {
        click((By.name("update")));
    }

    public void modify(int index, ContactData contact) {
        select(index);
        initModification();
        fillContactForm(contact, false);
        submitModification();
        returnToHomePage();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void initDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void confirmDeletion() {
        confirmAlert();
    }

    public void create(ContactData data) {
        initCreation();
        fillContactForm(data, true);
        submitCreation();
        returnToHomePage();
    }

    public void delete(int index) {
        select(index);
        initDeletion();
        confirmDeletion();
        if (isDeletionConfirmed()) {
            returnToHomePage();
        }
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isDeletionConfirmed() {
        if (isElementPresent(By.cssSelector("div.msgbox"))) {
            return true;
        } else return false;
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.name("entry"));

        for (WebElement row : allRows) {
            List<WebElement> allCells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String name = allCells.get(2).getText();
            String lastName = allCells.get(1).getText();
            ContactData contact = new ContactData(id, name, null, lastName, null, null,
                    null, null, null, null, null, null,
                    null, null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
