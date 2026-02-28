package com.dk;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

	@Test
	void testGetTenRandoms() {
		RandomGenerator obj = new RandomGenerator();
		int[] arr = obj.getTenRandoms();
		int n = arr.length;
		assertEquals(10, arr.length);
//		for(int i=0; i<n; i++) {
//			assertTrue(arr[i] >= 1 && arr[i] <= 10);
//		}
		assertFalse(Arrays.stream(arr).anyMatch(x -> x < 1 || x > 10));
	}

}
