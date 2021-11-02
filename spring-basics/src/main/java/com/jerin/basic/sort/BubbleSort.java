package com.jerin.basic.sort;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {

	@Override
	public void sort(T[] arr) {
		Arrays.sort(arr);

	}

}
