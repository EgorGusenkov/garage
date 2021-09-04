package ru.sberbank.javaschool.garageXMLSerializable;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.sberbank.javaschool.garage.Garage;
import ru.sberbank.javaschool.garageSerializable.MySerializer;
import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

import java.io.IOException;


public class EntryPointXMLSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Owner serializeOwner = new Owner("Петров", "Петр", "Петрович", 123456);

        MyXMLSerializer.serializeOwner(serializeOwner);

        Owner deserializeOwner =  MyXMLSerializer.deserializeOwner();
        System.out.println(deserializeOwner.toString());

        Car serializableCar = new Car("SD123456");
        serializableCar.setOwner(serializeOwner);
        MyXMLSerializer.serializeCar(serializableCar);

        Car deserializeCar = MyXMLSerializer.deserializeCar();
        System.out.println(deserializeCar.toString());

        Garage serializeGarage = new Garage();
        serializeGarage.addCar(serializableCar);

        //Не смог решить проблему серриализации Set (java.lang.Exception: Encoder: discarding statement TreeSet.add(Car);)
        //MyXMLSerializer.serializeGarage(serializeGarage.getGarage());
    }
}
