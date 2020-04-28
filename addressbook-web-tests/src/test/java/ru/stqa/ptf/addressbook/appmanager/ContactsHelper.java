package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

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
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        attach(By.name("photo"), contactData.getPhoto());

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

    public void initModification(int id) {
        click(By.xpath("//a[@href=\"edit.php?id=" + id + "\"]"));
    }

    public void submitModification() {
        click((By.name("update")));
    }

    public void modify(ContactData contact) {
        selectById(contact.getId());
        initModification(contact.getId());
        fillContactForm(contact, false);
        submitModification();
        contactCache = null;
        returnToHomePage();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void select(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    private void selectById(int id) {
        wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
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
        contactCache = null;
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


    public void delete(ContactData contact) {
        selectById(contact.getId());
        initDeletion();
        confirmDeletion();
        contactCache = null;
        if (isDeletionConfirmed()) {
            returnToHomePage();
        }
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
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

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return  new Contacts(contactCache);
        }

        contactCache = new Contacts();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.name("entry"));

        for (WebElement row : allRows) {
            List<WebElement> allCells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            String name = allCells.get(2).getText();
            String lastName = allCells.get(1).getText();
            String allPhones = allCells.get(5).getText();
            String allEmails= allCells.get(4).getText();
            String address= allCells.get(3).getText();

            ContactData contact = new ContactData().withId(id).withFirstName(name).withLastName(lastName).
                    withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address1 = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3)
                .withAddress(address1);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
