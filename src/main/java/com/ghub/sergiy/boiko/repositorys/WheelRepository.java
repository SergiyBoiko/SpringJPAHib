package com.ghub.sergiy.boiko.repositorys;

import com.ghub.sergiy.boiko.carpart.Wheel;
import com.ghub.sergiy.boiko.entity.Tyres;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WheelRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public WheelRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Wheel findById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Wheel.class, id);
    }

    public List<Wheel> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Wheel.class).list();
    }

    public void save(Wheel tyres){
        Session session = sessionFactory.openSession();
        session.save(tyres);
    }
}
