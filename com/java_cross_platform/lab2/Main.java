package com.java_cross_platform.lab2;

import java.util.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо масив автомобілів
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Toyota", "Camry", 2019, "Black", 25000.0, "ABC123"));
        cars.add(new Car(2, "Honda", "Civic", 2017, "Silver", 18000.0, "XYZ789"));
        cars.add(new Car(3, "Ford", "Focus", 2020, "Blue", 22000.0, "DEF456"));
        cars.add(new Car(4, "Toyota", "Corolla", 2015, "White", 15000.0, "JKL987"));
        cars.add(new Car(5, "Honda", "Accord", 2018, "Red", 20000.0, "MNO654"));
        cars.add(new Car(6, "Ford", "Mustang", 2016, "Yellow", 35000.0, "GHI321"));
        cars.add(new Car(7, "Chevrolet", "Cruze", 2014, "Black", 12000.0, "PQR555"));

        // Виводимо список автомобілів заданої марки (наприклад, "Toyota")
        System.out.println("Список автомобілів марки Toyota:");
        printCarsByBrand(cars, "Toyota");

        // Виводимо список автомобілів заданої моделі, які експлуатуються більше n років
        // (наприклад, n=3)
        int years = 3;
        System.out.println("Список автомобілів моделі Civic, які експлуатуються більше " + years + " років:");
        printCarsByModelAndYears(cars, "Civic", years);

        // Виводимо список автомобілів заданого року випуску, ціна котрих більша за
        // вказану (наприклад, рік=2017, ціна=19000.0)
        int year = 2017;
        double price = 19000.0;
        System.out.println("Список автомобілів " + year + " року випуску з ціною більше " + price + " USD:");
        printCarsByYearAndPrice(cars, year, price);

        // Виводимо список автомобілів заданої моделі і марки, будь-якого кольору, окрім
        // вказаного (наприклад, "Ford", "Mustang", кольор="Yellow")
        String brand = "Ford";
        String model = "Mustang";
        String excludedColor = "Yellow";
        System.out.println(
                "Список автомобілів марки " + brand + ", моделі " + model + ", крім " + excludedColor + " кольору:");
        printCarsByBrandModelAndColor(cars, brand, model, excludedColor);
    }

    // Метод для виведення автомобілів заданої марки
    public static void printCarsByBrand(List<Car> cars, String brand) {
        for (Car car : cars) {
            if (car.getBrand().equals(brand)) {
                System.out.println(car);
            }
        }
    }

    // Метод для виведення автомобілів заданої моделі, які експлуатуються більше n
    // років
    public static void printCarsByModelAndYears(List<Car> cars, String model, int years) {
        int currentYear = 2023; // Поточний рік (можна отримати програмно)
        for (Car car : cars) {
            if (car.getModel().equals(model) && (currentYear - car.getYear()) > years) {
                System.out.println(car);
            }
        }
    }

    // Метод для виведення автомобілів заданого року випуску, ціна котрих більша за
    // вказану
    public static void printCarsByYearAndPrice(List<Car> cars, int year, double price) {
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > price) {
                System.out.println(car);
            }
        }
    }

    // Метод для виведення автомобілів заданої моделі і марки, будь-якого кольору,
    // окрім вказаного
    public static void printCarsByBrandModelAndColor(List<Car> cars, String brand, String model, String excludedColor) {
        for (Car car : cars) {
            if (car.getBrand().equals(brand) && car.getModel().equals(model) && !car.getColor().equals(excludedColor)) {
                System.out.println(car);
            }
        }
    }
}