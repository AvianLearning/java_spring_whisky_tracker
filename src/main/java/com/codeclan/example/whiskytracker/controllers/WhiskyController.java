package com.codeclan.example.whiskytracker.controllers;

import com.codeclan.example.whiskytracker.models.Whisky;
import com.codeclan.example.whiskytracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByDistilleryAgeRegion(@RequestParam(name="distillery", required = false) String distillery,
                                                                            @RequestParam(name="age", required = false) Integer age,
                                                                            @RequestParam(name="year", required = false) Integer year,
                                                                            @RequestParam(name="region", required = false) String region) {
        if (distillery != null && age != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskiesByDistilleryNameAndAge(distillery, age), HttpStatus.OK);
        }
        else if (year != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskiesByYear(year), HttpStatus.OK);
        } else if (region != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskiesByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}
