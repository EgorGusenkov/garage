package ru.sberbank.javaschool.garageJSONSerializable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MyJSONSerializer {
    public static void serializeOwner(Owner owner) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/ownerSerializable.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(fileOutputStream, owner);
        fileOutputStream.close();
    }

    public static Owner deserializeOwner() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./files/ownerSerializable.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return (Owner) objectMapper.readValue(fileInputStream, Owner.class);
    }

    public static void serializeCar(Car car) throws IOException {
        FileOutputStream fileInputStream = new FileOutputStream("./files/carSerializable.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(fileInputStream, car);
        fileInputStream.close();
    }

    public static Car deserializeCar() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./files/carSerializable.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return (Car) objectMapper.readValue(fileInputStream, Car.class);
    }

    public static void serializeGarage(Set<Car> garage) throws IOException {
        FileOutputStream fileInputStream = new FileOutputStream("./files/garageSerializable.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(fileInputStream, garage);
        fileInputStream.close();
    }

    public static HashSet<Car> deserializeGarage() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./files/garageSerializable.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerSubtypes(Car.class, Owner.class);
        return (HashSet<Car>) objectMapper.readValue(fileInputStream, HashSet.class);
    }
}
