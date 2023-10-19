package com.java_cross_platform.lab2;

import java.util.List;

public class CarUtils {
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
