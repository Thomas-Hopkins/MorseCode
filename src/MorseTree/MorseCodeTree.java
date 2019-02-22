package MorseTree;

import Files.FileHandler;

public class MorseCodeTree <T> {
	protected class BTNode<T> {
		public T data;
	    public BTNode<T> left, right;
	    public BTNode() {}  // Default constructor
	    public BTNode(T theData) { data = theData; }
	    public BTNode(T theData, BTNode<T> L, BTNode<T> R) {
	        data = theData;
	        left = L;
	        right = R;
	    }
	}
	
	// Root node of the class
	protected BTNode root;
	
	public MorseCodeTree() {
		root = null;
	}
	
	public MorseCodeTree(BTNode root) {
		this.root = root;
	}
	
	public MorseCodeTree(T rootValue, MorseCodeTree<T> left, MorseCodeTree<T> right) {
		root = new BTNode(rootValue);
		root.left = left.root;
		root.right = right.root;
	}
	
	/**
	 * Wrapper function for buildTree
	 * @param morseString
	 * @return
	 */
	public static MorseCodeTree<String> buildTree(String[] morseString) {
		return buildTree(morseString, 0);
	}
	
	
	/**
	 * Builds the binary tree from inputed morse code mapping
	 * @param morseString
	 * @param index
	 * @return
	 */
	private static MorseCodeTree<String> buildTree(String[] morseString, int index) {
		// TODO: Build tree for morse code.
		String current = morseString[index].substring(1); // Get the morse code
		for (int i = 0; i < current.length(); i++) { // iterate through morse code one by one
			if (current.charAt(i) == '.') {
				// 
			}

		}
		return null;
	}
	
	public static String decodeMessage(String message) {
		// TODO: Decode message and return it using constructed binary tree
		return message;
	}
	
	public static String encodeMessage(String message) {
		// TODO: Encode message in morse code using binary tree and return it.
		return message;
	}
	
	@Override 
	public String toString() {
		String tree = root.data.toString() + " \n";
		// TODO: Append right and left subtrees
		return tree;
		
	}
	
}
