package com.codeclan.example.whiskytracker.repositories;

import com.codeclan.example.whiskytracker.models.Distillery;
import com.codeclan.example.whiskytracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskiesByYear(int year);

    List<Whisky> findWhiskiesByDistilleryRegion(String region);

    List<Whisky> findWhiskiesByDistilleryNameAndAge(String distilleryName, int age);

}
