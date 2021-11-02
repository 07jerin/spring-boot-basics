package com.jerin.basic.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jerin.basic.SpringBasicsApplication;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringBasicsApplication.class)
public class SearchTest {

	@Autowired
	Searcher<Integer> search;

	@Test
	public void testBasicScenario() {
		assertEquals(2, search.search(new Integer[] { 1, 2, 3 }, 3));
		assertEquals(-4, search.search(new Integer[] { 1, 2, 3 }, 5));
		assertEquals(0, search.search(new Integer[] { 1, 2, 3 }, 1));
	}

}
