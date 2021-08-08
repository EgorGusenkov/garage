package ru.sberbank.javaschool.garage;

import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

public class Garage {
    private static final String CAR_WITH_VIN_IS_ALREADY = "A car with this VIN is already in the collection";
    private static final String CAR_WITH_VIN_IS_NOT_ALREADY = "A car with this VIN is not already in the collection";
    Set<Car> garage = new HashSet<>();

    private final BiPredicate<Car, String> equalsVin = (car, vin) ->
            of(car).map(Car::getVin).filter(vin::equals).isPresent();

    public Optional<Car> getByVin(String vin) {
        return garage.stream().filter(car -> equalsVin.test(car, vin)).findFirst();
    }

    public void addCar(Car car) {
        ofNullable(car).filter(garage::add)
                .orElseThrow(() -> new IllegalArgumentException(CAR_WITH_VIN_IS_ALREADY));
    }

    public void addCar(String vin) {
        ofNullable(vin).map(Car::new).filter(garage::add)
                .orElseThrow(() -> new IllegalArgumentException(CAR_WITH_VIN_IS_ALREADY));
    }

    public Set<Owner> getOwners() {
        return garage.stream().map(Car::getOwner).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public void addOwner(String vin, Owner owner) {
        getByVin(vin)
                .orElseThrow(() -> new IllegalArgumentException(CAR_WITH_VIN_IS_NOT_ALREADY))
                .setOwner(owner);
    }

    public boolean removeCar(String vin) {
        return garage.removeIf(car -> equalsVin.test(car, vin));
    }

    public boolean removeOwner(String vin) {
        return getByVin(vin)
                .orElseThrow(() -> new IllegalArgumentException(CAR_WITH_VIN_IS_NOT_ALREADY))
                .removeOwner();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Garage{");
        sb.append("garage=").append(garage).append('}');
        return sb.toString();
    }

    public Set<Car> findCarsByPassportId(Integer passportId) {
        return garage.stream()
                .filter(car -> car.getOwner() != null && car.getOwner().getId().equals(passportId))
                .collect(Collectors.toSet());
    }

    public Set<Car> findCarsByFullName(String lastName, String firstName, String middleName) {
        return garage.stream().filter(car -> car.getOwner() != null
                && car.getOwner().getLastName().equals(lastName)
                && car.getOwner().getFirstName().equals(firstName)
                && car.getOwner().getMiddleName().equals(middleName)).collect(Collectors.toSet());
    }
}