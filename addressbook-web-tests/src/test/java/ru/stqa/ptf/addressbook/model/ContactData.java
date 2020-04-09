package ru.stqa.ptf.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickName;
    private final String title;
    private final String company;
    private final String address;
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String fax;
    private final String email1;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String birthdayDay;
    private final String birthdayMonth;
    private final String birthdayYear;
    private final String anniversDay;
    private final String anniversMonth;
    private final String anniversYear;
    private final String group;
    private final String addressExtra;
    private final String homePhoneExtra;
    private final String notes;

    public ContactData(String firstName, String middleName, String lastName, String nickName, String title,
                       String company, String address, String homePhone, String mobilePhone, String workPhone,
                       String fax, String email1, String email2, String email3, String homepage, String birthdayDay,
                       String birthdayMonth, String birthdayYear, String anniversDay, String anniversMonth,
                       String anniversYear, String group, String addressExtra, String homePhoneExtra, String notes) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.birthdayDay = birthdayDay;
        this.birthdayMonth = birthdayMonth;
        this.birthdayYear = birthdayYear;
        this.anniversDay = anniversDay;
        this.anniversMonth = anniversMonth;
        this.anniversYear = anniversYear;
        this.group = group;
        this.addressExtra = addressExtra;
        this.homePhoneExtra = homePhoneExtra;
        this.notes = notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBirthdayDay() {
        return birthdayDay;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public String getAnniversDay() {
        return anniversDay;
    }

    public String getAnniversMonth() {
        return anniversMonth;
    }

    public String getAnniversYear() {
        return anniversYear;
    }

    public String getGroup() {
        return group;
    }

    public String getAddressExtra() {
        return addressExtra;
    }

    public String getHomePhoneExtra() {
        return homePhoneExtra;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", homepage='" + homepage + '\'' +
                ", birthdayDay='" + birthdayDay + '\'' +
                ", birthdayMonth='" + birthdayMonth + '\'' +
                ", birthdayYear='" + birthdayYear + '\'' +
                ", anniversDay='" + anniversDay + '\'' +
                ", anniversMonth='" + anniversMonth + '\'' +
                ", anniversYear='" + anniversYear + '\'' +
                ", group='" + group + '\'' +
                ", addressExtra='" + addressExtra + '\'' +
                ", homePhoneExtra='" + homePhoneExtra + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(middleName, that.middleName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }
}
