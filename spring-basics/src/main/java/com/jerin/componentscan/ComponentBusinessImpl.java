package com.jerin.componentscan;

import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ComponentBusinessImpl implements ComponentBusiness {

	@Inject
	ComponentDAO dao;

	public int findMax() {
		return Arrays.stream(dao.getData()).max().orElse(Integer.MIN_VALUE);
	}

}
