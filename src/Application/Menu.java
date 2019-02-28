package Application;

import java.util.Scanner;

import MorseTree.MorseCodeTree;

public class Menu {
	public boolean running;
	private static MorseCodeTree morseTree;
	
	/** 
	 * Constructor
	 */
	public Menu(MorseCodeTree tree) {
		morseTree = tree;
		running = true;
	}
	/**
	 * Print out the menu options to console.
	 */
	public static void printMenu() {
		System.out.println("What do you wish to do?");
		System.out.println("1. Input a string for Morse Code encoding.");
		System.out.println("2. Input morse code string for decoding.");
		System.out.println("3. Exit.");
	}
	
	public static void promptAction() {
		Scanner scnr = new Scanner(System.in);
		int status = 0;
		printMenu();
		System.out.print(">>> ");
		performMenuAction(scnr.nextInt());
	}
	
	/**
	 * Performs corresponding action when user picks an option.
	 * @param option
	 * @return 0 not exit 1 if exit
	 */
	private static int performMenuAction(int option) {
		switch(option) {
		case 1: 
			encodeInput();
			return 0;
		case 2: 
			decodeInput();
			return 0;
		case 3:
			return 1;
		}
		return -1;
	}
	
	private static void decodeInput() {
		System.out.println("Enter a string in morse code to decode: ");
		String input = getInput();
		System.out.println(morseTree.decodeMessage(input));
	}
	
	private static void encodeInput() {
		System.out.println("Enter a string to encode into morse code: ");
		String input = getInput();
		//System.out.println(MorseCodeTree.encodeMessage(input)); TODO: Menu will need a reference to the tree.
		// A static encode/decode method will not work because we need an instance of the tree to build it.
		// Then we must use that instance to encode/decode. Unless we make the data attribute static as well, which
		// static data members are generally considered bad practice.
	}
	
	private static String getInput() {
		Scanner scnr = new Scanner(System.in);
		String userInput = scnr.nextLine();
		scnr.close();
		return userInput;
	}
	
}
