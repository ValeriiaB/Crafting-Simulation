package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ModeService {

    @Autowired
    ModeRepository modeRepository;


    public void insert(ArrayList<Mode> listOfModes){
            modeRepository.save(listOfModes);
    }

    public void insert(Mode mode){
        modeRepository.save(mode);
        //modeRepository.se
    }

    public Mode select(Long id){
        return modeRepository.findOne(id);
    }

    public void delete(Long id){
        modeRepository.delete(id);
    }

    public void update(Mode mode){
        modeRepository.save(mode);
    }
}
