package com.jerin.springbootbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= (ApplicationContext) SpringApplication.run(SpringBootApplication.class, args);
//		for(String bean : ctx.getBeanDefinitionNames()) {
//			System.out.println(bean);
//		}
	}

}
