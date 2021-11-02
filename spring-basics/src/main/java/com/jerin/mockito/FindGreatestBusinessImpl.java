package com.jerin.mockito;

import java.util.Arrays;

public class FindGreatestBusinessImpl {

	public FindGreatestBusinessImpl(DataService service) {
		super();
		this.service = service;
	}

	private DataService service;

	int findMax() {
		int[] data = service.retriveAllData();
		return Arrays.stream(data).max().orElse(Integer.MIN_VALUE);
	}

}
