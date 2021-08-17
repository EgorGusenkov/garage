import org.junit.Assert;
import org.junit.Test;
import ru.sberbank.javaschool.garage.Garage;
import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.model.Car;

public class GarageTest {

    @Test
    public void addCarTest() {
        Garage garage = new Garage();
        garage.addCar("11111111");
        Assert.assertEquals(garage.getByVin("11111111").get().getVin(), "11111111");

        Car car = new Car("22222222");
        garage.addCar(car);
        Assert.assertEquals(garage.getByVin("22222222").get().getVin(), "22222222");
    }

    @Test
    public void RemoveCarTest() {
        Garage garage = new Garage();
        garage.addCar("11111111");

        garage.removeCar("11111111");
        Assert.assertFalse(garage.getByVin("11111111").isPresent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDuplicateCarTest() {
        Garage garage = new Garage();
        garage.addCar("11111111");
        Car car = new Car("11111111");
        garage.addCar(car);
    }

    @Test
    public void addOwnerTest() {
        Garage garage = new Garage();
        Owner owner = new Owner("Ivanov", "Ivan", "Ivanovich", 999912345);
        Car car = new Car("11111111");
        garage.addCar(car);
        garage.getByVin("11111111").get().setOwner(owner);
        Assert.assertEquals(car.getOwner().getLastName(), "Ivanov");
        Assert.assertEquals(car.getOwner().getFirstName(), "Ivan");
        Assert.assertEquals(car.getOwner().getMiddleName(), "Ivanovich");
        Assert.assertEquals(car.getOwner().getId().intValue(), 999912345);
    }

    @Test
    public void RemoveOwnerTest() {
        Garage garage = new Garage();
        Owner owner = new Owner("Ivanov", "Ivan", "Ivanovich", 999912345);
        Car car = new Car("11111111");
        garage.addCar(car);
        garage.getByVin("11111111").get().setOwner(owner);

        garage.getByVin("11111111").get().removeOwner();
        Assert.assertNull(garage.getByVin("11111111").get().getOwner());
    }

    @Test
    public void findCarsByPassportIdTest() {
        Garage garage = new Garage();
        Owner owner = new Owner("Ivanov", "Ivan", "Ivanovich", 999912345);
        Car car = new Car("11111111");
        garage.addCar(car);
        garage.getByVin("11111111").get().setOwner(owner);

        Assert.assertTrue(garage.findCarsByPassportId(999912345).contains(car));
    }

    @Test
    public void findCarsByFullNameTest() {
        Garage garage = new Garage();
        Owner owner = new Owner("Ivanov", "Ivan", "Ivanovich", 999912345);
        Car car = new Car("11111111");
        garage.addCar(car);
        garage.getByVin("11111111").get().setOwner(owner);

        Assert.assertTrue(garage.findCarsByFullName("Ivanov", "Ivan", "Ivanovich").contains(car));
    }
}
