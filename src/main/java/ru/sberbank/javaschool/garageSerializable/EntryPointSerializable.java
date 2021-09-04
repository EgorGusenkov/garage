package ru.sberbank.javaschool.garageSerializable;

import ru.sberbank.javaschool.garage.Garage;
import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class EntryPointSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Owner serializeOwner = new Owner("Петров", "Петр", "Петрович", 123456);

        MySerializer.serializeOwner(serializeOwner);
        Owner deserializeOwner =  MySerializer.deserializeOwner();
        System.out.println(deserializeOwner.toString());

        Car serializableCar = new Car("SD123456");

        serializableCar.setOwner(deserializeOwner);
        MySerializer.serializeCar(serializableCar);

        Car deserializeCar =  MySerializer.deserializeCar();
        System.out.println(deserializeCar.toString());

        Garage serializeGarage = new Garage();
        serializeGarage.addCar(deserializeCar);
        MySerializer.serializeGarage(serializeGarage.getGarage());

        Set<Car> deserializeGarage = new TreeSet<>( MySerializer.deserializeGarage());

        System.out.println(deserializeGarage.toString());
    }
}
