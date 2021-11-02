package com.jerin.componentscan;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CdiInjection {

	@Inject
	private ComponentDAO dao;

	public ComponentDAO getDao() {
		return dao;
	}

	public void setDao(ComponentDAO dao) {
		this.dao = dao;
		
		
	}
}
