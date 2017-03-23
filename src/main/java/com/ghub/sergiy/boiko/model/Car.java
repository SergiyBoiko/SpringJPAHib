package com.ghub.sergiy.boiko.model;

import com.ghub.sergiy.boiko.carpart.Engine;
import com.ghub.sergiy.boiko.carpart.Wheel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CAR")
public class Car {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "WHEELS")
    private List<Wheel> wheels;
    @Column(name = "ENGINE")
    private Engine engine;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", wheels=" + wheels +
                ", engine=" + engine +
                '}';
    }
}
