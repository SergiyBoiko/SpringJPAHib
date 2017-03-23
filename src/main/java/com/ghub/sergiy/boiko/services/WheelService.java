package com.ghub.sergiy.boiko.services;

import com.ghub.sergiy.boiko.carpart.Wheel;
import com.ghub.sergiy.boiko.entity.Car;
import com.ghub.sergiy.boiko.repositorys.WheelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WheelService {

    @Autowired
    WheelRepository wheelRepository;

    public Wheel findById(int id){
        return wheelRepository.findById(id);
    }

    public List<Wheel> findAll(){
        return wheelRepository.findAll();
    }

    public void save(Wheel wheel){
        wheelRepository.save(wheel);
    }
}
