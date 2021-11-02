package com.jerin.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.*;

import com.jerin.basic.search.Searcher;

@Component
public class BasicConcepts {

	private static Logger LOGGER = LoggerFactory.getLogger(BasicConcepts.class);

	@Autowired
	private Searcher<Integer> searcher;

	public void run() {

		int index = searcher.search(new Integer[] { 1, 2, 3, 4 }, 3);
		LOGGER.info("{}", index);
	}

	@PostConstruct
	public void afterConstruct() {
		LOGGER.info("afterConstruct : " + this.getClass());
	}

	@PreDestroy
	public void beforeDetruct() {
		LOGGER.info("beforeDetruct : " + this.getClass());
	}

}
