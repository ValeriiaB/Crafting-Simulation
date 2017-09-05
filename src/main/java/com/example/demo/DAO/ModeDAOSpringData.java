package com.example.demo.DAO;


import com.example.demo.DataBase.Mode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ModeDAOSpringData implements BaseDAO<Mode>{

    @Autowired
    ModeRepository modeRepository;


    public void insert(ArrayList<Mode> listOfModes){
            modeRepository.save(listOfModes);
    }

    public void insert(Mode mode){
        modeRepository.save(mode);

    }

    public Mode select(Long id){
        return modeRepository.findOne(id);
    }

    public List<Mode> selectAll() {
        List<Mode> listOfModes= new ArrayList<>();
        modeRepository.findAll()
                .forEach(listOfModes::add);
        return listOfModes;
    }

    public void delete(Long id){
        modeRepository.delete(id);
    }

    public void update(Mode mode){
        modeRepository.save(mode);
    }
}
