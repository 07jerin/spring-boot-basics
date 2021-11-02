package com.jerin.basic.search;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jerin.basic.sort.Sorter;

@Service
public class BinarySearch<T extends Comparable<T>> implements Searcher<T> {

	@Autowired
	@Qualifier("bubble")
	private Sorter<T> sorter;
	
	private static Logger LOGGER = LoggerFactory.getLogger(BinarySearch.class);
	

	@Override
	public int search(T[] arr, T value) {

		sorter.sort(arr);
		LOGGER.info("Sorter used " + sorter);

		return Arrays.binarySearch(arr, value);
	}

}
