package com.example.autoservice.services;

import com.example.autoservice.autos.Auto;
import com.example.autoservice.tires.Tire;

public class ModernAutoService implements AutoService {
    @Override
    public void fixCar(Auto car) {
        System.out.println("Машина починена.");
    }

    @Override
    public void changeTire(Auto car, Tire tire) {
        System.out.println("Шины заменены.");
    }
}
