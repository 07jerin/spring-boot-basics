package com.jerin.componentscan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jerin.scope.SpringScopeApplication;

//@ExtendWith(SpringExtension.class)
//
//@ContextConfiguration(classes = SpringScopeApplication.class)
@ExtendWith(MockitoExtension.class)
public class ComponentBusinessTest {

	@InjectMocks
	ComponentBusinessImpl business;

	@Mock
	ComponentDAO daoMock;

	@Test
	public void testBasicScenario() {
		when(daoMock.getData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(3, business.findMax());
	}

	@Test
	public void testEmptyScenario() {
		when(daoMock.getData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, business.findMax());
	}

}
