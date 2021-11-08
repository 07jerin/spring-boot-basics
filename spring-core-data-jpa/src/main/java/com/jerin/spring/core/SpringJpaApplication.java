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
import com.jerin.spring.core.jpa.respository.PersonRepository;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person p2 = repository.findById(2);
		logger.info("User 2 -> {} ", p2);
		
		p2.setName("New Name");
		logger.info("Number of records update with id 2 - > {}", repository.updateName(p2));

		Person pNew = new Person(-1, "Jerin", "Trivandrum", LocalDate.of(1989, Month.FEBRUARY, 1));
		logger.info("Number of records -> {}", repository.insert(pNew));
		
		repository.deletById(1);
		
		logger.info("All users -> {} ", repository.findAll());
		
	}

}
