package ru.sberbank.javaschool.person.builder;

import ru.sberbank.javaschool.person.model.Person;

public abstract class PersonBuilder<T extends Person> {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Integer id;

    public PersonBuilder<T> setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder<T> setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder<T> setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public PersonBuilder<T> setId(Integer id) {
        this.id = id;
        return this;
    }

    public abstract T build();
}
