package com.codeclan.example.whiskytracker.repositories;

import com.codeclan.example.whiskytracker.models.Distillery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
}
