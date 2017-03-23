package com.ghub.sergiy.boiko.repositorys;

import com.ghub.sergiy.boiko.entity.Car;
import com.ghub.sergiy.boiko.entity.Tyres;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TyresRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public TyresRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Tyres findById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tyres.class, id);
    }

    public List<Tyres> findAll(){
        Session session = sessionFactory.openSession();
        return session.createCriteria(Tyres.class).list();
    }

    public void save(Tyres tyres){
        Session session = sessionFactory.openSession();
        session.save(tyres);
    }
}
