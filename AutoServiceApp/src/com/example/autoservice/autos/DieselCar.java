package com.example.autoservice.autos;

public class DieselCar extends Auto {
    public DieselCar(String brand, int year, String model) {
        super(year, brand, model);
    }

    @Override
    public void drive() {
        System.out.println("Дизельная машина движется.");
    }

    @Override
    public void breakDown() {
        System.out.println("Дизельная машина сломалась.");
    }

    @Override
    public void start() {
        System.out.println("Дизельная машина завелась.");
    }
}
