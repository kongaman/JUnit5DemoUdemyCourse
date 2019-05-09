package com.ck.junit5;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	@DisplayName("When String is null throw an exception")
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
	void length_greater_that_zero() {
		assertTrue("ABCD".length() > 0);
		assertTrue("ABC".length() > 0);
		assertTrue("A".length() > 0);
		assertTrue("DEF".length() > 0);
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"ABCD", "ABC", "A", "def"})
	// the test is executed for every parameter defined in @ValueSource
	void paramterized_test_length_greater_that_zero(String str) {
		assertTrue(str.length() > 0);
	}
	
	@Test
	void upperCase() {
		assertEquals("ABCD", "abcd".toUpperCase());
		assertEquals("ABC", "abc".toUpperCase());
		assertEquals("", "".toUpperCase());
		assertEquals("ABCDEFG", "abcdefg".toUpperCase());
	}
	
	@ParameterizedTest
	@CsvSource(value = {"abcd, ABCD", "abc, ABC", "'', ''", "abcdefg, ABCDEFG"})
	// in csv empty values have to be represented by single quotes ('')
	void patameterized_test_upperCase(String str, String capitalizedStr) {
		assertEquals(capitalizedStr, str.toUpperCase());
	}
	
	@ParameterizedTest
	@CsvSource(value = {"abcd, 4", "abc, 3", "'', 0", "abcdefg, 7"})
	// in csv empty values have to be represented by single quotes ('')
	void patameterized_test_length(String str, int expectedLength) {
		assertEquals(expectedLength, str.length());
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
