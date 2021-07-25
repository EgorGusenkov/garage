package ru.sberbank.javaschool.person.model;

public abstract class Person {
    protected final String firstName;
    protected final String lastName;
    protected String middleName;
    protected final Integer id;

    protected Person(String firstName, String lastName, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Integer getId() {
        return id;
    }
}
