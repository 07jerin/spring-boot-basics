package com.jerin.basic.sort;

public interface Sorter <T extends Comparable<T>> {
	
	public void sort(T[] arr);

}
