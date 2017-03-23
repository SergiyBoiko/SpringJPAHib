package com.ghub.sergiy.boiko.model;

import com.ghub.sergiy.boiko.carpart.Wheel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TYRES")
public class Tyres {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "NAME")
    private String name;
    @OneToMany
    @JoinColumn(name="WHEELS_ID")
    private List<Wheel> wheels;

    public Tyres(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Tyres{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", wheel=" + wheels +
                '}';
    }
}
