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
	
	public MorseCodeTree () {
		root = null;
	}
	
	/**
	 * Wrapper function for buildTree
	 * @param morseString
	 * @return
	 */
	public MorseCodeTree<String> buildTree(String[] morseString) {
		return buildTree(morseString, 0);
	}
	
	/**
	 * Builds the binary tree from inputed morse code mapping
	 * @param morseString
	 * @param index
	 * @return
	 */
	private MorseCodeTree<String> buildTree(String[] morseString, int index) {
		// TODO: Build tree for morse code.
		return null;
	}
	
	public String decodeMessage(String message) {
		// TODO: Decode message and return it using constructed binary tree
		return message;
	}
	
	public String encodeMessage(String message) {
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
