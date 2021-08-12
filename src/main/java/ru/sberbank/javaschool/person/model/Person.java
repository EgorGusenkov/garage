package ru.sberbank.javaschool.person.model;

public abstract class Person {
    protected final String firstName;
    protected final String lastName;
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

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getId() {
        return id;
    }
}
