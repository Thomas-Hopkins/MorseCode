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
	
	/**
	 * Calls printMenu and gets input for choice, passes to peformMenuAction
	 * @return int corresponding with success status -1 is an error, 1 is quit, 0 is success 
	 */
	public int promptAction() {
		printMenu();
		System.out.print(">>> ");
		return performMenuAction(getInput());
	}
	
	/**
	 * Performs corresponding action when user picks an option.
	 * @param option
	 * @return 0 not exit 1 if exit
	 */
	private int performMenuAction(int option) {
		switch(option) {
		case 1: 
			// Encode choice.
			encodeInput();
			return 0;
		case 2: 
			// Decode choice
			decodeInput();
			return 0;
		case 3:
			// Exit condition
			running = false;
			scnr.close();
			return 1;
		}
		return -1;
	}
	
	/**
	 * Gets user's morse code input and decodes it.
	 */
	private void decodeInput() {
		System.out.println("Enter a string in morse code to decode: ");
		String input = scnr.nextLine();
		System.out.println(morseTree.decodeMessage(input));
		System.out.println();
	}
	
	/**
	 * Gets user's string input and encodes it.
	 */
	private void encodeInput() {
		System.out.println("Enter a string to encode into morse code: ");
		String input = scnr.nextLine();
		System.out.println(morseTree.encodeMessage(input));
		System.out.println();
	}
	
	/**
	 * Gets user input for menu options
	 * @return int The option to execute
	 */
	private int getInput() {
		if(scnr.hasNextInt()) {
			int userInput = scnr.nextInt();
			scnr.nextLine();
			return userInput;
		}
		else {
		    scnr.nextLine();
			return -1;
		}
	}
}
