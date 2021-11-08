package com.jerin.spring.core;

import java.time.LocalDate;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.jerin.spring.core.jdbc.dao.PersonJdbcDao;
import com.jerin.spring.core.jdbc.entity.JdbcPerson;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {} ", dao.findAll());
		JdbcPerson p2 = dao.findById(2);
		logger.info("User 2 -> {} ", p2);
		logger.info("Number of records deleted with id 1 -> {} ", dao.deletById(1));
		logger.info("Number of records deleted with id 1 -> {} ", dao.deletById(1));

		p2.setName("New Name");
		logger.info("Number of records update with id 2 - > {}", dao.updateName(p2));

		JdbcPerson pNew = new JdbcPerson(4, "Jerin", "Trivandrum", LocalDate.of(1989, Month.FEBRUARY, 1), "");
		logger.info("Number of records inserted with id 4 -> {}", dao.insert(pNew));
		
		logger.info("User 2 using custom row mapper -> {}", dao.findByIdCustomRowMapper(2));

	}

}
