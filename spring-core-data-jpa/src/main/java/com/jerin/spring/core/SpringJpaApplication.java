package com.jerin.spring.core;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.jerin.spring.core.jpa.entity.Person;
import com.jerin.spring.core.jpa.entity.User;
import com.jerin.spring.core.jpa.respository.PersonRepository;
import com.jerin.spring.core.jpa.respository.UserRepository;

//@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonRepository repository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User Operations");

		long userid = userRepository.insert(new User(0, "User 1", "Admin"));
		logger.info("User id = {}", userid);

		long useridDev = userRepository.insert(new User(0, "User 2", "Developer"));
		logger.info("User id = {}", useridDev);

		logger.info("Person Operations");
		Person p2 = repository.findById(2);
		logger.info("Person 2 -> {} ", p2);

		p2.setName("New Name");
		logger.info("Number of records update with id 2 - > {}", repository.updateName(p2));

		Person pNew = new Person(-1, "Jerin", "Trivandrum", LocalDate.of(1989, Month.FEBRUARY, 1));
		logger.info("Number of records -> {}", repository.insert(pNew));

		repository.deletById(1);

		logger.info("All Persons -> {} ", repository.findAll());

	}

}
