package Application;

import java.util.Scanner;

import MorseTree.MorseCodeTree;

public class Menu {
	public boolean running;
	private Scanner scnr;
	private MorseCodeTree morseTree;
	
	/** 
	 * Constructor
	 */
	public Menu(MorseCodeTree tree) {
		morseTree = tree;
		running = true;
		scnr = new Scanner(System.in);
	}
	/**
	 * Print out the menu options to console.
	 */
	private void printMenu() {
		System.out.println("What do you wish to do?");
		System.out.println("1. Input a string for Morse Code encoding.");
		System.out.println("2. Input morse code string for decoding.");
		System.out.println("3. Exit.");
	}
	
	public int promptAction() {
		printMenu();
		System.out.print(">>> ");
		if(scnr.hasNextInt()) {
			return performMenuAction(scnr.nextInt());
		}
		else {
			return -1;
		}
	}
	
	/**
	 * Performs corresponding action when user picks an option.
	 * @param option
	 * @return 0 not exit 1 if exit
	 */
	private int performMenuAction(int option) {
		switch(option) {
		case 1: 
			encodeInput();
			return 0;
		case 2: 
			decodeInput();
			return 0;
		case 3:
			running = false;
			scnr.close();
			return 1;
		}
		return -1;
	}
	
	private void decodeInput() {
		System.out.println("Enter a string in morse code to decode: ");
		String input = getInput();
		System.out.println(morseTree.decodeMessage(input));
		System.out.println();
	}
	
	private void encodeInput() {
		System.out.println("Enter a string to encode into morse code: ");
		String input = getInput();
		System.out.println(morseTree.encodeMessage(input));
		System.out.println();
	}
	
	private String getInput() {
		if(scnr.hasNext()) {
			return scnr.next();
		}
		else {
			return "";
		}
	}
	
}
