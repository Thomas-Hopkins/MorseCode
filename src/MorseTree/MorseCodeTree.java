package MorseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

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
	
	// CONSTRUCTORS // 
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
	
	/**
	 * Builds the morse code binary tree for decoding and encoding messages.
	 * @param fileName Name of the input file
	 * @return The MorseCodeTree filled with the data from file
	 * @throws IOException
	 */
	public static MorseCodeTree buildFromFile(String fileName) throws IOException {
	    FileInputStream fileInput = new FileInputStream(fileName);
	    Scanner input = new Scanner(fileInput);
	    
	    // Initialize tree with root node null
	    MorseCodeTree theTree = new MorseCodeTree();
	    theTree.root = theTree.new BTNode();
	    input.forEachRemaining(line -> { // For each line in file
	        BTNode curNode = theTree.root;
	        char current = line.charAt(0);
	        String morseValue = line.substring(1);
	        char morseToken;
	        
	        for(int i = 0; i < morseValue.length(); i++) { // Iterate through morse tokens
	            morseToken = morseValue.charAt(i);
	            if(morseToken == '.') { // Go left
	                if(curNode.left == null) { curNode.left = theTree.new BTNode(); } // If it's null, make null node
	                curNode = curNode.left;
	            }
	            if(morseToken == '-') { // Go right
	                if(curNode.right == null) { curNode.right = theTree.new BTNode(); } // If it's null, make null node
	                curNode = curNode.right;
	            }
	        }
	        curNode.data = current; // After looping morse tokens, we are at our destination.
	    });
	    
	    fileInput.close();
	    input.close();
	    
	    return theTree;
	}
	
	/**
	 * Decodes a message from morse code into alpha-numerical characters.
	 * @param Morse code string space delimiter separates characters
	 * @return Decoded message string
	 */
	public String decodeMessage(String message) {
		String decodedMsg = "";
		BTNode localRoot = root, prevNode = root;
		for(int i = 0; i < message.length(); i++) { // Iterate through the string
			prevNode = localRoot; // Get previous node 
			if(message.charAt(i) == '.') { // if a dot then advance on left branch
				localRoot = localRoot.left;
			}
			if(message.charAt(i) == '-') { // if a dash then advance on right branch
				localRoot = localRoot.right;
			}
			if(message.charAt(i) == ' ') { // if a space then add previous character and start
				decodedMsg += prevNode.data; // binary morse code tree from beginning 
				localRoot = root;
			}
		}
		decodedMsg += localRoot.data; // string does not have ending space, so add last element
		return decodedMsg;
	}
	
	/**
	 * Wrapper function for encoding a message
	 * @param message
	 * @return
	 */
	public String encodeMessage(String message) {
		System.out.println("Fix method.");
		// TODO: FIX THIS METHOD. Returns .... for any value beyond ....
		String encodedMsg = "";
		BTNode localRoot = root;
		for(int i = 0; i < message.length(); i++) { // Iterate through string one character at a time
			encodedMsg += encodeMessage(message.charAt(i), localRoot, ""); // Run character through encoder
			encodedMsg += " "; // Add a space at the end of the encoded character
		}
		return encodedMsg;
	}
	
	private String encodeMessage(char character, BTNode root, String morse) {
		if(character == root.data) { // If character is equal to the root then return that path
			return morse;
		}
		else {
			if(root.left != null) {
				// Go through left branch
				return encodeMessage(character, root.left, morse + ".");
			}
			if(root.right != null) {
				// Go through right branch
				return encodeMessage(character, root.right, morse + "-");
			}
			return morse;
		}
		
	}
	
	/**
	 * Takes a StringBuilder object and formulates a string representation
	 * of the tree using preorder traversal
	 * @param stringBuilder StringBuilder to append the data to.
	 * @param root The root of the tree
	 */
	private void preorderString(StringBuilder stringBuilder, BTNode root) {
	    stringBuilder.append(root.data);
	    if(root.left != null) {
	        preorderString(stringBuilder, root.left);
	    }
	    if(root.right != null) {
	        preorderString(stringBuilder, root.right);
	    }
	}
	
	@Override 
	/**
	 * Outputs the tree using preorder traversal
	 * In our case, the string should return as " eishvufarlwpjtndbxkcymgzqo"
	 */
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		preorderString(stringBuilder, root);
	    return stringBuilder.toString();
	}
	
}
