package project;

import java.util.ArrayList;

public interface IOManager<T> {
	ArrayList<T> read(String path);
	void write(String path, T content);
}
