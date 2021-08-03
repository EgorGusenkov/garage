package ru.sberbank.javaschool.person.builder;

import ru.sberbank.javaschool.person.model.Owner;

public class OwnerBuilder extends PersonBuilder<Owner> {
    @Override
    public Owner build() {
        return new Owner(firstName, middleName, lastName, id);
    }
}
