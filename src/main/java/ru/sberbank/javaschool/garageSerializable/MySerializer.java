package ru.sberbank.javaschool.garageSerializable;

import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class MySerializer {

    public static void serializeOwner(Owner owner) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/ownerSerializable.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(owner);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static Owner deserializeOwner() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./files/ownerSerializable.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Owner) objectInputStream.readObject();
    }

    public static void serializeCar(Car car) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/carSerializable.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(car);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static Car deserializeCar() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./files/carSerializable.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Car) objectInputStream.readObject();
    }

    public static void serializeGarage(Set<Car> garage) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/garageSerializable.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(garage);
        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static TreeSet<Car> deserializeGarage() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./files/garageSerializable.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (TreeSet<Car>) objectInputStream.readObject();
    }
}
