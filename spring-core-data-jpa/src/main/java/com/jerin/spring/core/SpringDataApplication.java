package com.jerin.spring.core;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jerin.spring.core.jpa.entity.Person;
import com.jerin.spring.core.springdata.respository.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person p2 = repository.findById(2).get();
		logger.info("User 2 -> {} ", p2);
		
		p2.setName("New Name");
		logger.info("Number of records update with id 2 - > {}", repository.save(p2));

		Person pNew = new Person(-1, "Jerin", "Trivandrum", LocalDate.of(1989, Month.FEBRUARY, 1));
		logger.info("Number of records -> {}", repository.save(pNew));
		
		repository.deleteById(1);
		
		logger.info("All users -> {} ", repository.findAll());
		


	}

}
