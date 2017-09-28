package com.example.demo.DAO;


import com.example.demo.DataBase.Mode;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ModeDao implements IModeDao {
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

    public Mode insert(Mode mode) {
        return entityManager.merge(mode);
    }

    public void update(Mode mode) {
        entityManager.merge(mode);
    }
    public void delete(Long id) {
        entityManager.remove(select(id));
    }

    @SuppressWarnings("unchecked")
    public List<Mode> selectWithParams(int itemLevel, ModeTypeEnum modeType) {
        String hql = "FROM Mode as mode where mode.itemLevel <=:itemLvl and  mode.modeTypeEnum =:modeType ORDER BY mode.id";
        return (List<Mode>) entityManager.createQuery(hql)
                .setParameter("itemLvl",itemLevel)
                .setParameter("modeType", modeType)
                .getResultList();
    }
    @SuppressWarnings("unchecked")
    public List<Mode> selectWithParams(int itemLevel, ModeTypeEnum modeType, ActionTypeEnum actionType) {
        String hql = "FROM Mode as mode where mode.itemLevel <=:itemLvl and  mode.modeTypeEnum =:modeType and mode.actionTypeEnum =:actionType ORDER BY mode.id";
        return (List<Mode>) entityManager.createQuery(hql)
                .setParameter("itemLvl",itemLevel)
                .setParameter("modeType", modeType)
                .setParameter("actionType", actionType)
                .getResultList();
    }
}
