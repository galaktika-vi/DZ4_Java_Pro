package com.example.autoservice.autos;

public class HybridCar extends Auto {
    public HybridCar(String brand, int year, String model) {
        super(year, brand, model);
    }

    @Override
    public void drive() {
        System.out.println("Гибридная машина движется.");
    }

    @Override
    public void breakDown() {
        System.out.println("Гибридная машина сломалась.");
    }

    @Override
    public void start() {
        System.out.println("Гибридная машина завелась.");
    }
}
