package com.ghub.sergiy.boiko.services;

import com.ghub.sergiy.boiko.entity.Car;
import com.ghub.sergiy.boiko.repositorys.CarRepository;
import com.ghub.sergiy.boiko.repositorys.TyresRepository;
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
