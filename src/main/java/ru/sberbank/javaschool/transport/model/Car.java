package ru.sberbank.javaschool.transport.model;

import ru.sberbank.javaschool.person.model.Owner;

import java.io.Serializable;
import java.util.Objects;

public class Car extends Transport implements Serializable {
    private static final String HAS_OWNER = "this car has owner";
    private static final String HAS_NO_OWNER = "this car has no owner";
    private Owner owner;
    public Car(String vin, Owner owner) {
        super(vin);
        this.owner = owner;
    }

    public Car(){
        super("");
    }

    public Car(String vin) {
        super(vin);
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean setHasOwner() {
        return owner != null;
    }

    public void replaceOwner(Owner owner) {
        if (this.owner != null) {
            this.owner = owner;
        } else {
            System.err.println(HAS_NO_OWNER);
        }
    }

    public boolean removeOwner() {
        if (this.owner != null) {
            this.owner = null;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public TransportType takeType() {
        return TransportType.CAR;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return this.vin.equals(car.vin);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[vin: " + vin);
        // add createDate
        if (maxSpeed != null) {
            stringBuilder.append(", maxSpeed: ").append(maxSpeed);
        }
        if (width != null) {
            stringBuilder.append(", width: ").append(width);
        }
        if (height != null) {
            stringBuilder.append(", height: ").append(height);
        }
        if (length != null) {
            stringBuilder.append(", length: ").append(length);
        }
        if (owner != null) {
            stringBuilder.append(", owner: ");
            stringBuilder.append(owner.toString());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
