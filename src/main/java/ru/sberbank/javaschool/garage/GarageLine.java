package ru.sberbank.javaschool.garage;

import ru.sberbank.javaschool.person.builder.OwnerBuilder;
import ru.sberbank.javaschool.person.model.Owner;
import ru.sberbank.javaschool.transport.builder.CarBuilder;
import ru.sberbank.javaschool.transport.model.Car;

import java.util.Scanner;

public class GarageLine {
    private static final String ENTER_VIN = "Введите VIN транспорта";
    private static final String ENTER_FIRST_NAME = "Введите имя владельца";
    private static final String ENTER_MIDDLE_NAME = "Введите отчество владельца";
    private static final String ENTER_LAST_NAME = "Введите фамилию владельца";
    private static final String ENTER_PASSPORT_ID = "Введите номер паспорта";
    private static final String WAIT_INT = "Ожидается вввод цифры";

    static Garage garage = new Garage();

    public static void main(String[] args) {
        boolean isContinue = true;
        Scanner sc = new Scanner(System.in);
        do {
            switch (getAction(sc)) {
                case 1:
                    garage.addCar(readCar(sc));
                    break;
                case 2:
                    garage.removeCar(readString(sc, ENTER_VIN));
                    break;
                case 3:
                    garage.addOwner(readString(sc, ENTER_VIN), readOwner(sc));
                    break;
                case 4:
                    garage.removeOwner(readString(sc, ENTER_VIN));
                    break;
                case 5:
                    System.out.println(garage.getByVin(readString(sc, ENTER_VIN)));
                    break;
                case 6:
                    System.out.println(garage.findCarsByPassportId(readInt(sc, ENTER_PASSPORT_ID)));
                    break;
                case 7:
                    System.out.println(garage.findCarsByFullName(
                            readString(sc, ENTER_LAST_NAME),
                            readString(sc, ENTER_FIRST_NAME),
                            readString(sc, ENTER_MIDDLE_NAME)));
                    break;
                case 8:
                    System.out.println(garage.getOwners());
                    break;
                case 9:
                    System.out.println(garage.toString());
                    break;
                case 0:
                    isContinue = false;
                    break;
            }
        } while (isContinue);
    }

    private static int getAction(Scanner sc) {
        return readAction(sc,
                "1 - Добавить автомобиль, 2 - Удалить автомобиль\n " +
                        "3 - Добавить/сменить владельца, 4 - Удалить владельца\n" +
                        "5 - найти автомобиль по vin\n" +
                        "6 - найти все автомобили владельца по номену паспорта \n" +
                        "7 - найти все автомобили владельца по ФИО\n " +
                        "8 - вывести список владельцев\n" +
                        "9 - получить карту всех владельцев и их авто\n" +
                        "0 - Закончить работу",
                9);
    }

    private static Car readCar(Scanner sc) {
        return new CarBuilder()
                .vin(readString(sc, ENTER_VIN))
                .build();
    }

    private static Owner readOwner(Scanner sc) {
        return new OwnerBuilder()
                .setLastName(readString(sc, ENTER_LAST_NAME))
                .setFirstName(readString(sc, ENTER_FIRST_NAME))
                .setMiddleName(readString(sc, ENTER_MIDDLE_NAME))
                .setId(readInt(sc, ENTER_PASSPORT_ID))
                .build();
    }

    private static String readString(Scanner sc, String text) {
        String string;
        do {
            System.out.println(text);
            string = sc.nextLine();
        } while (string.isEmpty());
        return string.toUpperCase();
    }

    private static int readInt(Scanner scanner, String text) {
        int result = 0;
        System.out.println(text);
        try {
            String value = scanner.nextLine();
            result = Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println(WAIT_INT);
        }
        return result;
    }

    private static int readAction(Scanner scanner, String text, int max) {
        int result = 0;
        boolean isContinue;
        do {
            System.out.println(text);
            try {
                String value = scanner.nextLine();
                result = Integer.parseInt(value);
            } catch (Exception e) {
                System.err.println(WAIT_INT);
                continue;
            }
            isContinue = result < -1 || result > max;
            if (isContinue) {
                System.err.println("Не удовлетворяет заданному диапазону: минимум - 0, максимум - " + max);
            }
        } while (result < 0 || result > max);
        return result;
    }
}
