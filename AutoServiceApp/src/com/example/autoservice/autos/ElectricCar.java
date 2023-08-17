package com.example.autoservice.autos;

public class ElectricCar extends Auto {
    public ElectricCar(String brand, int year, String model) {
        super(year, brand, model);
    }

    @Override
    public void drive() {
        System.out.println("Электрическая машина движется.");
    }

    @Override
    public void breakDown() {
        System.out.println("Электрическая машина сломалась.");
    }

    @Override
    public void start() {
        System.out.println("Электрическая машина завелась.");
    }
}
