package ru.sberbank.javaschool.transport.builder;

import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

public class CarBuilder extends TransportBuilder<Car> {
    Owner owner;

    public CarBuilder owner(Owner owner) {
        this.owner = owner;
        return this;
    }

    @Override
    public Car build() {
        return new Car(this.vin, owner);
    }
}
