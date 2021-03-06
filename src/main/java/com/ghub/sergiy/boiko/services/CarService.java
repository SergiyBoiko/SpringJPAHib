package com.ghub.sergiy.boiko.services;

import com.ghub.sergiy.boiko.model.Car;
import com.ghub.sergiy.boiko.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    WheelService wheelService;

    public Car findById(int id){
        return carRepository.findById(id);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public void save(Car car){
        carRepository.save(car);
    }
}
