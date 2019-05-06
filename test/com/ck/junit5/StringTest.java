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

}
