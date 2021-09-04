package ru.sberbank.javaschool.person.model;

import java.io.Serializable;
import java.util.Objects;

public class Owner extends Person implements Serializable {
    public Owner(String lastName, String firstName, String middleName, Integer id) {
        super(lastName, firstName, middleName, id);
    }

    //
    public Owner() {
        super("","","",0);
    }

    public Owner(String lastName, String firstName, Integer id) {
        super(lastName, firstName, id);
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
