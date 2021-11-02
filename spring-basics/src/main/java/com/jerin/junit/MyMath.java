package com.jerin.junit;

import java.util.Arrays;

public class MyMath {

	public int sum(int[] ips) {
		return Arrays.stream(ips).sum();
	}

}
