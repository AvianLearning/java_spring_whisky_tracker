package com.codeclan.example.whiskytracker;

import com.codeclan.example.whiskytracker.models.Distillery;
import com.codeclan.example.whiskytracker.models.Whisky;
import com.codeclan.example.whiskytracker.repositories.DistilleryRepository;
import com.codeclan.example.whiskytracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class WhiskytrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear() {
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	public void canFindDistilleryByRegion() {
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertEquals(3, foundDistilleries.size());
	}

	@Test
	public void canFindWhiskyFromDistilleryByAge() {
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskiesByDistilleryNameAndAge("Glendronach", 15);
		assertEquals(1, foundWhiskies.size());

	}
}
