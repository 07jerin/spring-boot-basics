package com.jerin.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class FindGreatestBusinessImplMockTestWithAnnotations {

	DataService service = mock(DataService.class);
	FindGreatestBusinessImpl impl = new FindGreatestBusinessImpl(service);

	@Test
	public void testFindMax() {

		when(service.retriveAllData()).thenReturn(new int[] { 1, 2, 3, 5 });
		int max = impl.findMax();
		assertEquals(5, max);

	}

	@Test
	public void findMaxEmptyArray() {
		when(service.retriveAllData()).thenReturn(new int[] {});
		int max = impl.findMax();
		assertEquals(Integer.MIN_VALUE, max);
	}
}
