package project;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		
		IOManager ioManager = new IOManager();
		input = ioManager.fileRead("input.txt");
		
		Parser parser = new Parser();
		ArrayList<Variable> cmd = parser.parse(input);

	}
}
