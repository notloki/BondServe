package com.notloki.bondserve;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Person  {
    private @Id
    @GeneratedValue
    Long id;
    private String lastName;
    private String phone;
    private String ivrCode;
    private String lang;

    public Person() {
    }

    public boolean equals(Person person) {
        return person.getLastName().equals(this.lastName) &&
                person.getPhone().equals(this.phone) &&
                person.getIvrCode().equals(this.ivrCode);
       }


    @Override
    public String toString() {
        return "ivr code: : " + this.getIvrCode() + "\n" +
                        "Last Name: " + this.getLastName() + "\n" +
                                "Language: " + this.getLang() + "\n" +
                                        "Phone: " + this.getPhone();
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIvrCode() {
        return ivrCode;
    }

    public void setIvrCode(String ivrCode) {
        this.ivrCode = ivrCode;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String toString(Person person) {
        return "Last Name: " + person.getLastName() + "\n" +
               "Phone: " + person.getPhone() + "\n" +
               "Ivr Code: " + getIvrCode() + "\n" +
               "Lang: " + getLang();
    }

    public void addPerson(String lastName, String phone, String ivrCode) {
        this.phone = phone;
        this.lastName = lastName;
        this.ivrCode = ivrCode;
        this.lang = "en";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
