package MorseTree;

import Files.FileHandler;

public class MorseCodeTree {
	protected class BTNode {
		public char data;
	    public BTNode left, right;
	    public BTNode() {}  // Default constructor
	    public BTNode(char theData) { data = theData; }
	    public BTNode(char theData, BTNode L, BTNode R) {
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
	
	public MorseCodeTree(char rootValue, MorseCodeTree left, MorseCodeTree right) {
		root = new BTNode(rootValue);
		root.left = left.root;
		root.right = right.root;
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
		// We should just print some value using one of the traversal methods as a helper function
	    // to build a string
	    return null;
	}
	
}
