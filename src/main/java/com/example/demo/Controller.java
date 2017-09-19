package com.example.demo;


import com.example.demo.DataBase.Armor;
import com.example.demo.DataBase.Mode;
import com.example.demo.EnumClasses.ActionTypeEnum;
import com.example.demo.EnumClasses.ModeTypeEnum;
import com.example.demo.service.ArmorService;
import com.example.demo.service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    private ModeService modeService;
    @Autowired
    private ArmorService armorService;

    @GetMapping("mode/{id}")
    public ResponseEntity<Mode> getMode(@PathVariable("id") Long id) {
        Mode mode =modeService.select(id);
        return new ResponseEntity(mode, HttpStatus.OK);
    }
    @GetMapping("modes")
    public ResponseEntity<List<Mode>> getAllModes() {
        List<Mode> list = modeService.selectAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("mode")
    public ResponseEntity<Void> addArticle(@RequestBody Mode mode) {
        modeService.insert(mode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity updateArticle(@RequestBody Mode mode) {
        modeService.update(mode);
        return new ResponseEntity( HttpStatus.OK);
    }
    @DeleteMapping("mode/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        modeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
