package com.jerin.scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jerin.componentscan.CdiInjection;
import com.jerin.componentscan.ComponentBusinessImpl;
import com.jerin.componentscan.ComponentDAO;

@Configuration
@ComponentScan(value = { "com.jerin.componentscan", "com.jerin.scope" })
//@ComponentScan(value="com.jerin")
public class SpringScopeApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringScopeApplication.class);

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringScopeApplication.class);) {

			runScopeSamples(context);

			componentScanAndCDI(context);
			
			componentFindMax(context);

			System.out.println("Here");
		}

	}

	private static void componentFindMax(AnnotationConfigApplicationContext context) {
		ComponentBusinessImpl business = context.getBean(ComponentBusinessImpl.class);
		System.out.println(business.findMax());
	}

	private static void componentScanAndCDI(ApplicationContext context) {
		ComponentDAO componentScan = context.getBean(ComponentDAO.class);

		CdiInjection cdi = context.getBean(CdiInjection.class);
		ComponentDAO componentDaoFromCdi = cdi.getDao();

		LOGGER.info("{}", componentScan);
		LOGGER.info("{}", cdi);
		LOGGER.info("{}", componentDaoFromCdi);
	}

	private static void runScopeSamples(ApplicationContext context) {
		System.out.println();
		System.out.println();

		PersonDAO person1 = context.getBean(PersonDAO.class);
		JdbcConnection con1 = person1.getJdbcConnection();
		PersonDAO person2 = context.getBean(PersonDAO.class);
		JdbcConnection con2 = person2.getJdbcConnection();
		JdbcConnection con21 = person2.getJdbcConnection();

		LOGGER.info("{}", person1);
		LOGGER.info("{}", con1);
		LOGGER.info("{}", person2);
		LOGGER.info("{}", con2);
		LOGGER.info("calling again on same instance ");
		LOGGER.info("{}", con21);

	}

}
