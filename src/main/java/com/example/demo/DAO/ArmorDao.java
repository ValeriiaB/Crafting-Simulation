package com.example.demo.DAO;

import com.example.demo.DataBase.Armor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ArmorDao implements IDAO<Armor>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Armor select(Long id) {
        return entityManager.find(Armor.class, id);
    }
    @Override
    public Armor insert(Armor armor) {
        return entityManager.merge(armor);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(select(id));
    }

    @Override
    public List<Armor> selectAll() {
        String hql = "FROM Armor as armor ORDER BY armor.id";
        return (List<Armor>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void update(Armor armor) {
        entityManager.merge(armor);
    }
}
