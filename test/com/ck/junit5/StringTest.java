package com.ck.junit5;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {
	
	@BeforeAll
	// Done once for the entire testclass at the beginning
	// Before/AfterAll have to be static
	static void schneewittchen() {
		System.out.println("Initialize connection to database");
	}
	
	@AfterAll
	// Done once for the entire testclass at the end
	static void rosenrot() {
		System.out.println("close connection to database");
	}
	
	@BeforeEach
	// = @Before in jUnit4
	// This method is executed BEFORE EVERY single other test
	// Hint "TestInfo" did not exist in jUnit4
	void beforeEach(TestInfo info) {
		System.out.println("Initialize test data for " + info.getDisplayName());
	}
	
	@AfterEach
	// = @After in jUnit4
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
	void length_exception() {
		String str = null;
		//String str = "ABCD";
		// short video on functional programming -> https://youtu.be/aFCNPHfvqEU
		// the first parameter is the exception that is expected to be thrown
		// the second parameter of assertThrows is the code that is expected to throw the exception
		// lambda expression
		// this test will fail if NO exception is thrown!!!
		assertThrows(NullPointerException.class, () -> { str.length(); }  );
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
