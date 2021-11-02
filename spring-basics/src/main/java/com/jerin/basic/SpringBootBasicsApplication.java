//package com.jerin.basic;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//@SpringBootApplication
//public class SpringBootBasicsApplication {
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootBasicsApplication.class);
//
//	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(SpringBootBasicsApplication.class, args);
//
//		runBasicSamples(context);
//	}
//
//	private static void runBasicSamples(ApplicationContext context) {
//		System.out.println();
//		System.out.println();
//		
//		BasicConcepts basics = context.getBean(BasicConcepts.class);
//		basics.run();
//	}
//
//}
