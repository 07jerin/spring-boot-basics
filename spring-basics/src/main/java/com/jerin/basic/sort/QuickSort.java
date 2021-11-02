package com.jerin.basic.sort;

import java.util.Arrays;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Primary
public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(T[] arr) {
		Arrays.parallelSort(arr);


	}
}
