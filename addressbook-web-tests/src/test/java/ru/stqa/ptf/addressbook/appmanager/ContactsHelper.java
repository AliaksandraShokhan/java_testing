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
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getEmail1());

        if (creation) {
            click(By.name("new_group"));
            select(By.name("new_group"), contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
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
            ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
