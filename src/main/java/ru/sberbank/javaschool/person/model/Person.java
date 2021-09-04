package ru.sberbank.javaschool.person.model;

import java.io.Serializable;

public abstract class Person implements Serializable {
    protected final String lastName;
    protected final String firstName;
    protected String middleName;
    protected final Integer id;

    protected Person(String lastName, String firstName, Integer id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public Person(String lastName, String firstName, String middleName, Integer id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    //jackson ругается на getFullName т.к. не может найти поле
    public String takeFullName() {
        return lastName.concat(" ").concat(firstName).concat(" ").concat(middleName);
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getId() {
        return id;
    }
}
