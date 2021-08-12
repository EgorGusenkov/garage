package ru.sberbank.javaschool.person.model;

import java.util.Objects;

public class Owner extends Person {
    public Owner(String lastName, String firstName, String middleName, Integer id) {
        super(lastName, firstName, middleName, id);
    }

    @Override
    public String toString() {
        return "[full name: " + lastName + " " + firstName + " " + middleName +
                ", " + "id: " + id + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Owner owner = (Owner) obj;
        return this.id.equals(owner.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
