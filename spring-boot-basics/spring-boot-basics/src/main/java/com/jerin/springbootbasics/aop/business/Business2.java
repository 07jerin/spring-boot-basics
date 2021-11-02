package com.jerin.springbootbasics.aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerin.springbootbasics.aop.service.Dao2;

@Service
public class Business2 {

	@Autowired
	Dao2 repo;
	
	public String calculateSomething() {
		return repo.retrieveSomething();
	}
}
