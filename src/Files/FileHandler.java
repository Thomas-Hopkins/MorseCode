package Files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileHandler {
	private String filename;
	
	public FileHandler() {
		filename = "input.txt";
	}
	
	public FileHandler(String file) {
		this.filename = file;
	}
	
	public void readFile() throws IOException {
		FileInputStream inputFile = new FileInputStream(filename);
		Scanner input = new Scanner(inputFile);
		
		//TODO: read in from input and pass into a data structure which can be later converted to a binary tree
	}
}
