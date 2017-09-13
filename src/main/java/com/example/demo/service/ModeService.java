package com.example.demo.service;


import com.example.demo.DAO.IDAO;
import com.example.demo.DataBase.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeService implements IService <Mode> {
    @Autowired
    private IDAO<Mode> dao;

    public Mode select(Long id) {
        Mode mode= dao.select(id);
        return mode;
    }

    public List<Mode> selectAll(){
        return dao.selectAll();
    }

    public void insert(Mode mode){
        dao.insert(mode);
    }

    public void update(Mode mode) {
        dao.update(mode);
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}
