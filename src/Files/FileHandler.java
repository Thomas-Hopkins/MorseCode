package Files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class FileHandler {
	private String filename;
	
	public FileHandler() {
		filename = "input.txt";
	}
	
	public FileHandler(String file) {
		this.filename = file;
	}
	
	
	/**
	 * Returns an ArrayList of the input file for tree building. 
	 * @return ArrayList 
	 * @throws IOException
	 */
	public String[] readFile() throws IOException {
		FileInputStream inputFile = new FileInputStream(filename);
		Scanner input = new Scanner(inputFile);
		String[] data = new String[26];
		int i = 0;
		// TODO: May need to change how data read in is stored and returned
		while(input.hasNext()) { // Read in from file
			data[i++] = input.next(); // Get current line
		}
		
		//TODO: Remove debug
		for (i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		return data;
	}
}
