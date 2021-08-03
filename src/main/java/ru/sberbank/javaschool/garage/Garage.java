package ru.sberbank.javaschool.garage;

import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.builder.CarBuilder;
import ru.sberbank.javaschool.transport.model.Car;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Garage {
    private static final String CAR_WITH_VIN_IS_ALREADY = "A car with this VIN is already in the collection";
    private static final String CAR_WITH_VIN_IS_NOT_ALREADY = "A car with this VIN is not already in the collection";
    Set<Car> garage = new HashSet<Car>(){

        public boolean contains(String vin) {
            Car car = new Car(vin, null);
            return super.contains(car);
        }
    };

    public Car getByVin(String vin) {
        for (Car car : garage) {
            if (car.getVin().equals(vin)) {
                return car;
            }
        }
        return null;
    }

    public void addCar(Car car) {
        if (!garage.contains(car)) {
            garage.add(car);
        } else {
            System.err.println(CAR_WITH_VIN_IS_ALREADY);
        }
    }

    public Set<Owner> getOwners() {
        Set<Owner> ownerSet = new HashSet<>();
        garage.forEach(car -> {
            Owner carOwner = car.getOwner();
            if (carOwner != null) {
                ownerSet.add(carOwner);
            }
        });
        return ownerSet;
    }

    public void addOwner(String vin, Owner owner) {
        Car car = new CarBuilder()
                .vin(vin)
                .build();
        if (garage.contains(car)) {
            this.getByVin(vin)
                    .setOwner(owner);
        } else {
            System.err.println(CAR_WITH_VIN_IS_NOT_ALREADY);
        }
    }

    public Car removeCar(String vin) {
        Iterator<Car> carIterator = garage.iterator();
        while (carIterator.hasNext()) {
            Car car = carIterator.next();
            if (car.getVin().equals(vin)) {
                carIterator.remove();
                return car;
            }
        }
        return null;
    }

    public Owner removeOwner(String vin) {
        Car car = new CarBuilder()
                .vin(vin)
                .build();
        if (garage.contains(car)) {
            return car.removeOwner();
        } else {
            System.err.println(CAR_WITH_VIN_IS_NOT_ALREADY);
            return null;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Garage{");
        sb.append("garage=").append(garage);
        sb.append('}');
        return sb.toString();
    }

    public Set<Car> findCarsByPassportId(Integer passportId) {
        Set<Car> carSet = new HashSet<>();
        garage.forEach(car -> {
            if (car.getOwner() != null
                    && car.getOwner().getId().equals(passportId)) {
                carSet.add(car);
            }
        });
        return carSet;
    }

    public Set<Car> findCarsByFullName(String lastName, String firstName, String middleName) {
        Set<Car> carSet = new HashSet<>();
        garage.forEach(car -> {
            if (car.getOwner() != null
                    && car.getOwner().getLastName().equals(lastName)
                    && car.getOwner().getFirstName().equals(firstName)
                    && car.getOwner().getMiddleName().equals(middleName)) {
                carSet.add(car);
            }
        });
        return carSet;
    }
}