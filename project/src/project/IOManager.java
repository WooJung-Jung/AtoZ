package project;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOManager {
	
	ArrayList<String> read(String path) {
		
		ArrayList<String> input = new ArrayList<String>();
		try {
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(fileReader);
			
			String line = "";			
			while ( (line = bufReader.readLine()) != null ) {
				input.add(line);
			}
			
		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}
		
		return input;
	}
}
