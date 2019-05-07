package com.ck.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {
	
	@Test
	void length_basic() {
		int actuallength = "ABCD".length();
		int expectedLength = 4;
		assertEquals(expectedLength, actuallength);
	}
	
	@Test
	void toUpperCase_basic() {
		String str = "abcd";
		String result = str.toUpperCase();
		assertNotNull(result); // <- just Demo doesn't make any sense here
		//assertNull(result);
		assertEquals("ABCD", result);
	}
	
	@Test
	void contains_basic() {
		String str ="abcdefgh";
		boolean result = str.contains("ijk");
		assertEquals(false, result);
		assertFalse(result); //<- just Demo same as above
		//assertTrue(result);
	}
	
	@Test
	void contains_basic2() {
		assertFalse("abcdefgh".contains("ijk")); //inline ...more readable?!?
	}
	
	@Test
	void split_basic() {
		String str = "abc def ghi";
		String[] actualResult = str.split(" ");
		String[] expectedResult = new String[] {"abc", "def", "ghi"};
		assertArrayEquals(expectedResult, actualResult);
	}

}
