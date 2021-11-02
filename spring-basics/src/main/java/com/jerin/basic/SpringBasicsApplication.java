package com.jerin.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jerin.basic.properties.ResourceLoader;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringBasicsApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBasicsApplication.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringBasicsApplication.class);

		runBasicSamples(context);
		context.close();
	}

	private static void runBasicSamples(ApplicationContext context) {

		BasicConcepts basics = context.getBean(BasicConcepts.class);
		basics.run();
		
		
		ResourceLoader resourceLoader = context.getBean(ResourceLoader.class);
		LOGGER.info("{}", resourceLoader.getUrl());
	}

}
