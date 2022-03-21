package project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ParserTest {

	@Test
	void test() {
		assertTrue(new Parser().commandValid("ADD"));
		assertFalse(new Parser().commandValid("D"));
		
		assertTrue(new Parser().optionValid(new Option("-p", " ", " ")));
		assertFalse(new Parser().optionValid(new Option("-p", "", " ")));
		
		assertTrue(new Parser().dataValid(new ArrayList<Data>()));
		
		assertTrue(new Parser().employeeNumValid("12345678"));
		assertFalse(new Parser().employeeNumValid("1"));
		
		assertTrue(new Parser().clValid("CL1"));
		assertFalse(new Parser().clValid("CL0"));
		
		assertTrue(new Parser().phoneNumValid("010-1234-5678"));
		assertFalse(new Parser().phoneNumValid("011-1234-5678"));
		assertFalse(new Parser().phoneNumValid("010-1234-56789"));
		
		assertTrue(new Parser().birthdayValid("20220318"));
		
		assertTrue(new Parser().certiValid("PRO"));
		assertFalse(new Parser().certiValid("PROO"));
		
	}

}
