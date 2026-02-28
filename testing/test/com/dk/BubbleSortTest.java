package com.dk;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void testBubbleSort() {
        BubbleSort obj = new BubbleSort();
        int[] arr = {3, 8, 2, 7, 6};
        int[] expected = {2, 3, 6, 7, 8};

        obj.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

}
