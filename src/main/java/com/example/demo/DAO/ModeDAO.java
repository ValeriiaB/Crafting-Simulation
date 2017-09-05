package com.example.demo.DAO;

import com.example.demo.DataBase.Mode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
public class ModeDAO  implements BaseDAO<Mode>{
    @PersistenceContext
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void insert(Mode mode) {
        getSession().save(mode);
    }

    public Mode select(Long id) {
        return getSession().get(Mode.class, id);
    }
    public void insert(ArrayList<Mode> listOfModes){
        for(Mode mode : listOfModes)
            getSession().save(mode);
    }

    public void delete(Long id) {
        getSession().delete(id);
    }
    public void update(Mode mode){
        getSession().update(mode);
    }

    @SuppressWarnings("unchecked")
    public List<Mode> selectAll() {
        return getSession().createQuery("from Mode").list();
    }

}
