package com.example.demo;


import com.example.demo.DataBase.Mode;
import com.example.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {
    @Autowired
    private IService service;

    @GetMapping("mode/{id}")
    public ResponseEntity<Mode> getMode(@PathVariable("id") Long id) {
        Mode article =(Mode)service.select(id);
        return new ResponseEntity<Mode>(article, HttpStatus.OK);
    }
    @GetMapping("modes")
    public ResponseEntity<List<Mode>> getAllModes() {
        List<Mode> list = service.selectAll();
        return new ResponseEntity<List<Mode>>(list, HttpStatus.OK);
    }
    @PostMapping("mode")
    public ResponseEntity<Void> addArticle(@RequestBody Mode mode) {
        service.insert(mode);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity updateArticle(@RequestBody Mode mode) {
        service.update(mode);
        return new ResponseEntity( HttpStatus.OK);
    }
    @DeleteMapping("mode/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
