package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/smartphone")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;
    @GetMapping
    public ResponseEntity<List<Smartphone>> getAll(){
        List<Smartphone> smartphoneList = smartphoneService.findAll();
        if(smartphoneList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(smartphoneList,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Smartphone smartphone){
        smartphoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
