package com.jerin.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindGreatestBusinessImplStubTest {

	@Test
	public void testFindMax() {
		FindGreatestBusinessImpl impl = new FindGreatestBusinessImpl(new DataServiceStub());
		int max = impl.findMax();
		assertEquals(5, max);
	}
}

class DataServiceStub implements DataService {

	@Override
	public int[] retriveAllData() {

		return new int[] { 1, 2, 3, 4, 5 };
	}

}