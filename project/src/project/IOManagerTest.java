package project;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class IOManagerTest {

	@Test
	void test() {
		ArrayList<String> input = new ArrayList<String>(); 
		input.add("ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO");
		input.add("DEL, , , ,name,KYUMOK KIM");
		assertEquals(input, new IOManager().fileRead("input.txt"));
	}

}
