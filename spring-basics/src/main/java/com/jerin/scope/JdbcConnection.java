package com.jerin.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.jerin.basic.SpringBasicsApplication;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JdbcConnection {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JdbcConnection.class);

	public JdbcConnection() {
//		LOGGER.info("In JDBC Connection Constructor " + this);
		System.out.println("In JDBC Connection Constructor");
	}

}
