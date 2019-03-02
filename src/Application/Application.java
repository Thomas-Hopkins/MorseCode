package Application;

import java.io.IOException;
import java.util.Scanner;

import MorseTree.MorseCodeTree;

public class Application {
	public static void main(String[] args) throws IOException {
		// Build morse code binary tree and create a menu
	    MorseCodeTree morseCodeTree = MorseCodeTree.buildFromFile("input.txt");
	    Menu appMenu = new Menu(morseCodeTree);
	    
	    // Main loop
	    while(appMenu.running) {
	    	appMenu.promptAction();
	    }
	}
}
