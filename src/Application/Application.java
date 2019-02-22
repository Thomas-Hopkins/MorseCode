package Application;

import java.io.IOException;

import Files.FileHandler;
import MorseTree.MorseCodeTree;

public class Application {
	public static void main(String[] args) throws IOException {
		FileHandler filehandler = new FileHandler();
		filehandler.readFile();
		//MorseCodeTree.buildTree(filehandler.readFile());
	}
}
