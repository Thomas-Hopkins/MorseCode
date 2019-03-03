package Application;

import java.io.IOException;

import MorseTree.MorseCodeTree;

public class Application {
	public static void main(String[] args) throws IOException {
		// Build morse code binary tree and create a menu
	    MorseCodeTree morseCodeTree = MorseCodeTree.buildFromFile("input.txt");
	    Menu appMenu = new Menu(morseCodeTree);
	    
	    // Main loop
	    int status;
	    while(appMenu.running) {
	    	status = appMenu.promptAction();
	    	if(status < 0) {
	    		System.out.println("INVALID INPUT.\n");
	    	}
	    	else if (status > 0) {
	    		System.out.println("Goodbye.");
	    	}
	    }
	}
}
