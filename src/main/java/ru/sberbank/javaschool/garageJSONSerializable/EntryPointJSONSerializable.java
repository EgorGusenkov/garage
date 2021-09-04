package ru.sberbank.javaschool.garageJSONSerializable;

import ru.sberbank.javaschool.garage.Garage;
import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

import java.io.IOException;
import java.util.HashSet;

public class EntryPointJSONSerializable {
    public static void main(String[] args) throws IOException {
        Owner serializeOwner = new Owner("Петров", "Петр", "Петрович", 123456);

        MyJSONSerializer.serializeOwner(serializeOwner);
        Owner deserializeOwner =  MyJSONSerializer.deserializeOwner();
        System.out.println(deserializeOwner.toString());

        Car serializableCar = new Car("SD123456");

        serializableCar.setOwner(deserializeOwner);
        MyJSONSerializer.serializeCar(serializableCar);

        Car deserializeCar =  MyJSONSerializer.deserializeCar();
        System.out.println(deserializeCar.toString());

        Garage serializeGarage = new Garage();
        serializeGarage.addCar(deserializeCar);
        MyJSONSerializer.serializeGarage(serializeGarage.getGarage());

        // при попытке серриализации в TreeSet - Exception in thread "main" java.lang.ClassCastException: [B cannot be cast to java.lang.Comparable..
        HashSet<Car> deserializeGarage = new HashSet<>( MyJSONSerializer.deserializeGarage());

        System.out.println(deserializeGarage.toString());

        //если я пытаюсь взаимодействовать с полями (например вызвать getVin()) - получаю ошибку, не могу выявить причину
        System.out.println(deserializeGarage.stream().findAny().get());
    }
}
