package com.jerin.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockList {

	@Mock
	List<Integer> list;

	@Test
	public void size() {
		when(list.size()).thenReturn(10).thenReturn(20);
		assertEquals(10, list.size());
		assertEquals(20, list.size());
		assertEquals(20, list.size());
	}

	@Test
	public void getSpecific() {
		when(list.get(0)).thenReturn(10).thenReturn(20);
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(0));
		assertEquals(null, list.get(1));
	}

	@Test
	public void getGeneric() {
		when(list.get(Mockito.anyInt())).thenReturn(10).thenReturn(20);
		assertEquals(10, list.get(0));
		assertEquals(20, list.get(0));
		assertEquals(20, list.get(1));
		assertEquals(20, list.get(100));

	}

}
