package com.example.autoservice.tires;

import com.example.autoservice.enums.TireType;

public class WinterTire extends Tire {
    public WinterTire(TireType type) {
        super(type);
    }

    @Override
    public void change() {
        System.out.println("Установлены зимние шины.");
    }
}
