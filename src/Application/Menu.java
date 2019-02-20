package Application;

public class Menu {
	private boolean running;
	
	/** 
	 * Constructor
	 */
	public Menu() {
		running = true;
	}
	/**
	 * Print out the menu options to console.
	 */
	public static void printMenu() {
		System.out.println("What do you wish to do?");
		System.out.println("1. Input a string for Morse Code encoding.");
		System.out.println("2. Decode/Encode Morse Code from file.");
		System.out.println("3. Exit.");
	}
	
	/**
	 * Performs corresponding action when user picks an option.
	 * @param option
	 * @return 0 not exit 1 if exit
	 */
	public static int performMenuAction(int option) {
		switch(option) {
			//TODO: write switch cases for each menu option
		}
		return 0;
	}
	
}
