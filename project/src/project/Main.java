package project;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> input = new ArrayList<String>();
		
		FileIOManager ioManager = new FileIOManager();
		input = ioManager.read("input.txt");
		
		Parser parser = new Parser();
		ArrayList<Variable> cmd = parser.parse(input);

	}
}
