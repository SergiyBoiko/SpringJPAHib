package com.ghub.sergiy.boiko.repository;

import com.ghub.sergiy.boiko.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public CarRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public Car findById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Car.class, id);
    }

    public List<Car> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Car.class).list();
    }

    public void save(Car car){
        Session session = sessionFactory.openSession();
        session.save(car);
    }
}
