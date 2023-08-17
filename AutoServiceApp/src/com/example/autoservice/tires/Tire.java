package com.example.autoservice.tires;

import com.example.autoservice.enums.TireType;

public abstract class Tire {
    private TireType type;

    public Tire(TireType type) {
        this.type = type;
    }

    public abstract void change();

    // Геттер
    public TireType getType() {
        return type;
    }

    // Сеттер
    public void setType(TireType type) {
        this.type = type;
    }
}
