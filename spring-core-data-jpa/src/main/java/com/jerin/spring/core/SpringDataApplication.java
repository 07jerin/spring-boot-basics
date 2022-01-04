package com.jerin.spring.core;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jerin.spring.core.jpa.entity.Person;
import com.jerin.spring.core.jpa.entity.User;
import com.jerin.spring.core.springdata.respository.PersonSpringDataRepository;
import com.jerin.spring.core.springdata.respository.UserJPARepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	@Autowired
	UserJPARepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("User Operations");

		User user1 = userRepository.save(new User(0, "User 1", "Admin"));
		logger.info("User id = {}", user1.getId());

		User user2 = userRepository.save(new User(0, "User 2", "Developer"));
		logger.info("User id = {}", user2.getId());

		List<User> users = userRepository.findAll();
		logger.info("All users {} ", users);

		user2 = userRepository.findById(2l)
				.get();
		logger.info("Get User with id 2 {} ", user2);

		Person p2 = repository.findById(2)
				.get();
		logger.info("User 2 -> {} ", p2);

		p2.setName("New Name");
		logger.info("Number of records update with id 2 - > {}", repository.save(p2));

		Person pNew = new Person(-1, "Jerin", "Trivandrum", LocalDate.of(1989, Month.FEBRUARY, 1));
		logger.info("Number of records -> {}", repository.save(pNew));

		repository.deleteById(1);

		logger.info("All users -> {} ", repository.findAll());

	}

}
