package com.example.demo.service;


import com.example.demo.DAO.IDAO;
import com.example.demo.DataBase.Armor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmorService implements IService<Armor> {
    @Autowired
    private IDAO<Armor> dao;

    @Override
    public void insert(Armor armor) {
        dao.insert(armor);
    }

    @Override
    public Armor select(Long id) {
        return dao.select(id);
    }

    @Override
    public void update(Armor armor) {
        dao.update(armor);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Armor> selectAll() {
        return dao.selectAll();
    }
}
