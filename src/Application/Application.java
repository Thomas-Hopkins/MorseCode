package Application;

import java.io.IOException;

import MorseTree.MorseCodeTree;

public class Application {
	public static void main(String[] args) throws IOException {
	    MorseCodeTree morseCodeTree = MorseCodeTree.buildFromFile("input.txt");
	    Menu appMenu = new Menu(morseCodeTree);
	    System.out.println(morseCodeTree); // TODO: See toString method to explain output. Only printing here for testing.
	    
		Menu.promptAction();
	    
	}
}
