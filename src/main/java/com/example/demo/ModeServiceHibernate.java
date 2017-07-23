package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.ArrayList;

public class ModeServiceHibernate {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void insert(Mode mode) {
        hibernateTemplate.save(mode);
    }

    public void insert(ArrayList<Mode> listOfModes) {
        for(Mode mode : listOfModes)
            hibernateTemplate.save(mode);
    }

    public Mode select(Long id){

        return hibernateTemplate.get(Mode.class, id);
    }

    public void delete(Long id){
        hibernateTemplate.delete(id);
    }

    public void update(Mode mode){
        hibernateTemplate.update(mode);
    }
}
