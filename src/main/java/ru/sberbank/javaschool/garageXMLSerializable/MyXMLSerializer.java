package ru.sberbank.javaschool.garageXMLSerializable;

import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;
import sun.reflect.generics.tree.Tree;

import java.beans.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class MyXMLSerializer {

    public static void serializeOwner(Owner owner) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/ownerSerializable.xml");
        XMLEncoder encoder = new XMLEncoder(fileOutputStream);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                e.printStackTrace();
            }
        });
        PersistenceDelegate ownerDelegate = new DefaultPersistenceDelegate(new String[]{"lastName", "firstName", "id"});
        encoder.setPersistenceDelegate(Owner.class, ownerDelegate);
        encoder.writeObject(owner);
        encoder.close();
    }

    public static Owner deserializeOwner() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./files/ownerSerializable.xml");
        XMLDecoder decoder = new XMLDecoder(fileInputStream);
        return (Owner) decoder.readObject();
    }

    public static void serializeCar(Car car) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/carSerializable.xml");
        XMLEncoder encoder = new XMLEncoder(fileOutputStream);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                e.printStackTrace();
            }
        });

        PersistenceDelegate carDelegate = new DefaultPersistenceDelegate(new String[]{"vin"});
        encoder.setPersistenceDelegate(Car.class, carDelegate);
        PersistenceDelegate ownerDelegate = new DefaultPersistenceDelegate(new String[]{"lastName", "firstName", "id"});
        encoder.setPersistenceDelegate(Owner.class, ownerDelegate);

        encoder.writeObject(car);
        encoder.close();
    }

    public static Car deserializeCar() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./files/carSerializable.xml");
        XMLDecoder decoder = new XMLDecoder(fileInputStream);
        return (Car) decoder.readObject();
    }

    public static void serializeGarage(Set<Car> garage) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("./files/garageSerializable.xml");
        XMLEncoder encoder = new XMLEncoder(fileOutputStream);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                e.printStackTrace();
            }
        });
        PersistenceDelegate carDelegate = new DefaultPersistenceDelegate(new String[]{"vin"});
        encoder.setPersistenceDelegate(Car.class, carDelegate);
        PersistenceDelegate ownerDelegate = new DefaultPersistenceDelegate(new String[]{"lastName", "firstName", "id"});
        encoder.setPersistenceDelegate(Owner.class, ownerDelegate);
        encoder.writeObject(garage);
        encoder.close();
    }

}
