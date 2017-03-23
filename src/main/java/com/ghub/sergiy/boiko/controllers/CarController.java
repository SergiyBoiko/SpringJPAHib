package com.ghub.sergiy.boiko.controllers;

import com.ghub.sergiy.boiko.carpart.Engine;
import com.ghub.sergiy.boiko.carpart.Wheel;
import com.ghub.sergiy.boiko.entity.Car;
import com.ghub.sergiy.boiko.entity.Tyres;
import com.ghub.sergiy.boiko.services.CarService;
import com.ghub.sergiy.boiko.services.TyresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;

@Controller
public class CarController {

    @Autowired
    CarService carService;
    @Autowired
    TyresService tyresService;

    @RequestMapping("/")
    @ResponseBody
    public String save(){
        Car car = new Car();
        ArrayList<Wheel> wheels = new ArrayList<>();
            for(int i = 0; i <= 3;i++){
                Tyres tyres = new Tyres();
                tyres.setSize("17");
                tyres.setName("Super Swamper Bogger");
                Wheel wheel = new Wheel();
                wheel.setTyres(tyres);
                wheels.add(wheel);
            }
        Engine engine = new Engine();
        engine.setEngineСapacity(BigDecimal.valueOf(2.4));
        car.setWheels(wheels);
        car.setEngine(engine);
        carService.save(car);
        return carService.findAll().toString();
    }
}
