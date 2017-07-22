package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ModeService {

    @Autowired
    ModeRepository modeRepository;


    public void putListOfModesToDB(ArrayList<Mode> listOfModes){
            modeRepository.save(listOfModes);
    }

    public void putOneModeToDB(Mode mode){
        modeRepository.save(mode);
    }

    public Mode getModeById(Long id){
        return modeRepository.findOne(id);
    }

    public void deleteModeById(Long id){
        modeRepository.delete(id);
    }

    public void updateMode(Mode mode){
        modeRepository.save(mode);
    }
}
