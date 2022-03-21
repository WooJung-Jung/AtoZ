package project;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOManager implements IOManager<String> {

	@Override
	public ArrayList<String> read(String path) {
		ArrayList<String> input = new ArrayList<String>();
		try {
			File file = new File(path);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(fileReader);

			String line = "";
			while ((line = bufferReader.readLine()) != null) {
				input.add(line);
			}
			bufferReader.close();

		} catch (FileNotFoundException e) {
			e.getStackTrace();
		} catch (IOException e) {
			e.getStackTrace();
		}

		return input;
	}

	@Override
	public void write(String path, ArrayList<String> contents) {
		try {
			File file = new File(path);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

			if (file.isFile() && file.canWrite()) {
				for (String content : contents) {
					bufferedWriter.write(content);
					bufferedWriter.newLine();
				}
				bufferedWriter.close();

			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}
