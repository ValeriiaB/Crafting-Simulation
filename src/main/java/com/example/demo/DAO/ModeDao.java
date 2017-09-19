package com.example.demo.DAO;


import com.example.demo.DataBase.Mode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ModeDao implements IDAO<Mode> {
    @PersistenceContext
    private EntityManager entityManager;

    public Mode select(Long Id) {
        return entityManager.find(Mode.class, Id);
    }
    @SuppressWarnings("unchecked")
    public List<Mode> selectAll() {
        String hql = "FROM Mode as mode ORDER BY mode.id";
        return (List<Mode>) entityManager.createQuery(hql).getResultList();
    }

    public void insert(Mode mode) {
        entityManager.merge(mode);
    }

    public void update(Mode mode) {
        entityManager.merge(mode);
    }
    public void delete(Long id) {
        entityManager.remove(select(id));
    }

}
