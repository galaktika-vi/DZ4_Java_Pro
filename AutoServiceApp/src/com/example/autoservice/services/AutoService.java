package com.example.autoservice.services;

import com.example.autoservice.autos.Auto;
import com.example.autoservice.tires.Tire;

public interface AutoService {
    void fixCar(Auto car);
    void changeTire(Auto car, Tire tire);
}
