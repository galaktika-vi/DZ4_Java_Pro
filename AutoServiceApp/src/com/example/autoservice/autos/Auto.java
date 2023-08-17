package com.example.autoservice.autos;

import com.example.autoservice.tires.Tire;

public abstract class Auto {
    private int year;
    private String brand;
    private String model;
    private Tire[] tires;

    public Auto(int year, String brand, String model) {
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.tires = new Tire[4];
    }

    public abstract void drive();

    public abstract void breakDown();

    public abstract void start();

    // Геттеры
    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Tire[] getTires() {
        return tires;
    }

    // Сеттеры
    public void setYear(int year) {
        this.year = year;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
}

