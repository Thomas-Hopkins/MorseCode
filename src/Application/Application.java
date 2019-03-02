package Application;

import java.io.IOException;
import java.util.Scanner;

import MorseTree.MorseCodeTree;

public class Application {
	public static void main(String[] args) throws IOException {
	    MorseCodeTree morseCodeTree = MorseCodeTree.buildFromFile("input.txt");
	    Menu appMenu = new Menu(morseCodeTree);
	    
	    while(appMenu.running) {
	    	appMenu.promptAction();
	    }
	}
}
