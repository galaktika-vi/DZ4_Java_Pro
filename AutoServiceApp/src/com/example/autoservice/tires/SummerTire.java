package com.example.autoservice.tires;

import com.example.autoservice.enums.TireType;

public class SummerTire extends Tire {
    public SummerTire(TireType type) {
        super(type);
    }

    @Override
    public void change() {
        System.out.println("Установлены летние шины.");
    }
}
