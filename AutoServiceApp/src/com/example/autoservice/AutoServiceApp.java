package com.example.autoservice;

import com.example.autoservice.autos.Auto;
import com.example.autoservice.autos.ElectricCar;
import com.example.autoservice.enums.TireType;
import com.example.autoservice.services.AutoService;
import com.example.autoservice.services.ModernAutoService;
import com.example.autoservice.tires.SummerTire;
import com.example.autoservice.tires.Tire;

public class AutoServiceApp {
    public static void main(String[] args) {
        AutoService service = new ModernAutoService();

        Auto electricCar = new ElectricCar("Tesla", 2022, "Model S");
        Tire summerTire = new SummerTire(TireType.SUMMER);

        service.fixCar(electricCar);
        service.changeTire(electricCar, summerTire);

        System.out.println("Работа завершена.");
    }
}
