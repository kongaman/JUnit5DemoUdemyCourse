package com.ck.junit5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringTest {
	
	@BeforeEach
	//This method is executed BEFORE EVERY single other test
	void beforeEach() {
		System.out.println("Initialize test data for each test");
	}
	
	@AfterEach
	//This method is executed AFTER EVERY single other test
	void afterEach() {
		System.out.println("Clean up test data");
	}
	
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
