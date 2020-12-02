package com.codeclan.example.whiskytracker.controllers;

import com.codeclan.example.whiskytracker.models.Distillery;
import com.codeclan.example.whiskytracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value="/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(@RequestParam(name="region", required = false) String region, @RequestParam(name="age", required = false) Integer age){

        if(region != null) {
            return new ResponseEntity<List<Distillery>>(distilleryRepository.findDistilleriesByRegion(region), HttpStatus.OK);
        }

        else if (age != null) {
            return new ResponseEntity<List<Distillery>>(distilleryRepository.findDistilleriesByWhiskiesAge(age), HttpStatus.OK);
        }

        return new ResponseEntity<List<Distillery>>(distilleryRepository.findAll(), HttpStatus.OK);
    }

}

