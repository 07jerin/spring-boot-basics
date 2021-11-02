package com.jerin.springbootbasics.aop.service;

import org.springframework.stereotype.Repository;

import com.jerin.springbootbasics.aop.aspect.TrackTime;

@Repository
public class Dao1 {

	@TrackTime
	public String retrieveSomething() {
		return "Dao1";
	}
}
