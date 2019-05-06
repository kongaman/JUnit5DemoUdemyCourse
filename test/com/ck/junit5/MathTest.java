package com.ck.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathTest {

	@Test
	void max() {
		int actualMax = Math.max(5, 6);
		int expectedMax = 6;
		assertEquals(expectedMax, actualMax);
	}
	
	@Test
	void min() {
		int actualMin = Math.min(3, 2);
		int expectedMin = 2;
		assertEquals(expectedMin, actualMin);
	}

}
