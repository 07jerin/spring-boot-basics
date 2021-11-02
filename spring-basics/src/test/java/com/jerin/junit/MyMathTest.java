package com.jerin.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyMathTest {

	MyMath math = new MyMath();

	@BeforeAll
	public static void beforeAll() {
		System.out.println("before All");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("before Each");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("After All");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("afterEach");
	}

	@Test
	public void testAssert() {
		System.out.println("testing testAssert");
		assertArrayEquals(new int[] { 1, 2, 3 }, new int[] { 1, 2, 3 });
	}

	@Test
	public void testSum() {
		System.out.println("testing testSum");
		int result = math.sum(new int[] { 1, 2, 3 });
		assertEquals(6, result);

		result = math.sum(new int[] {});
		assertEquals(0, result);

		assertNotNull(result);

		boolean isPass = result == 0;
		assertTrue(isPass);

		boolean isFail = result != 0;
		assertFalse(isFail);

	}

}
