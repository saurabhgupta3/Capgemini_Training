package com.dk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumSquareDigitsRepeatTest {
	
	@ParameterizedTest
	@CsvSource({
		"16, 8",
		"2, -1",
		"14, -1	"
	})
	void testGetAns(int input, int expected) {
		int result = SumSquareDigitsRepeat.getAns(input);
		assertEquals(expected, result);
	}
}