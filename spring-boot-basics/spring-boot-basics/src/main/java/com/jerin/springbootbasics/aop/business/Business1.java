package com.jerin.springbootbasics.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerin.springbootbasics.aop.service.Dao1;

@Service
public class Business1 {

	@Autowired
	Dao1 repo;
	
	public String calculateSomething() {
		return repo.retrieveSomething();
	}
}
