package com.ck.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void whatever() {
		int length = "ABCD".length();
		// we want to assert length == 4
		// BUT: There is no check, so the test will succeed even if the length()-Method
		// would return 5 or anything else!!!
		// run as -> junit test --> green bar = success
	}
	
	@Test
	void firstRealTestPass() {
		int actuallength = "ABCD".length();
		int expectedLength = 4;
		assertEquals(expectedLength, actuallength);
	}
	
	@Test
	void firstRealTestFail() {
		int actuallength = "ABCDE".length();
		int expectedLength = 4;
		assertEquals(expectedLength, actuallength);
	}

}
