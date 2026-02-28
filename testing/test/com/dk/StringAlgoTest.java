package com.dk;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringAlgoTest {

	@Test
	void testFunc() throws Exception{
		StringAlgo obj = new StringAlgo();
		String input = "saurabh";
		String expected = "urabhsa";
		String actual  = obj.func(input);
		assertEquals(expected, actual);
	}
	@Test
	void testFunc2() {
		StringAlgo obj = new StringAlgo();
		String input = "s";
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			String actual = obj.func(input);
		});
	}

}
