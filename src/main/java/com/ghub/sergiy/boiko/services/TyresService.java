package com.ghub.sergiy.boiko.services;

import com.ghub.sergiy.boiko.model.Tyres;
import com.ghub.sergiy.boiko.repository.TyresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TyresService {

    @Autowired
    TyresRepository tyresRepository;

    public Tyres findById(int id) {
        return tyresRepository.findById(id);
    }

    public List<Tyres> findAll(){
        return tyresRepository.findAll();
    }

    public void save(Tyres tyres) {
        tyresRepository.save(tyres);
    }
}
