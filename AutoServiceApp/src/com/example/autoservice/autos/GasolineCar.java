package com.example.autoservice.autos;

public class GasolineCar extends Auto {
    public GasolineCar(String brand, int year, String model) {
        super(year, brand, model);
    }

    @Override
    public void drive() {
        System.out.println("Бензиновая машина движется.");
    }

    @Override
    public void breakDown() {
        System.out.println("Бензиновая машина сломалась.");
    }

    @Override
    public void start() {
        System.out.println("Бензиновая машина завелась.");
    }
}
