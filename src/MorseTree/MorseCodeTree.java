package MorseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
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
		BTNode localRoot = root;
		for(int i = 0; i < message.length(); i++) { // Iterate through the string
			if(message.charAt(i) == '.') { // if a dot then advance on left branch
				localRoot = localRoot.left;
			}
			if(message.charAt(i) == '-') { // if a dash then advance on right branch
				localRoot = localRoot.right;
			}
			if(message.charAt(i) == ' ') { // if a space then add previous character and start
			    if(localRoot != null) {
    				decodedMsg += localRoot.data; // binary morse code tree from beginning
    				localRoot = root;
			    } else { return "Could not parse input."; }
			}
		}
		if(localRoot != null) { decodedMsg += localRoot.data; }// string does not have ending space, so add last element
		else { return "Could not parse input."; }
		
		return decodedMsg;
	}

	/**
	 * Takes a String argument and returns the Morse Code representation of the given String.
	 * @param message String The message to encode
	 * @return String The Morse Code representation of the given String
	 */
	public String encodeMessage(String message) {
	    message = message.toLowerCase(); // Set message to lower case for encoding
        StringBuilder encodedMessage = new StringBuilder();
        char letter;
        String encodedLetter;
        
        for(int i = 0; i < message.length() - 1; i++) { // Encode each character in the String.
            letter = message.charAt(i);
            encodedLetter = encodeLetter(root, letter);
            encodedMessage.append(encodedLetter + " "); // Append to the StringBuilder, with a space in between.
        }
        encodedMessage.append(encodeLetter(root, message.charAt(message.length() - 1)));
        
        return encodedMessage.toString();
	}
	
	/**
	 * Takes in a char value and returns a String representing the
	 * Morse value of the given char.
	 * @param root BTNode The root of the MorseCodeTree
	 * @param letter char The letter to encode
	 * @return String The morse value representing the letter
	 */
	private String encodeLetter(BTNode root, char letter) {
	    // Method-local inner class for storing a node and string within the Queue
        class Pair {
            public final BTNode node;
            public final String morseString;
            public Pair(BTNode node, String morseString) { 
                this.node = node;
                this.morseString = morseString;
            }
        }
        Pair nodeMorsePair;
        BTNode curNode;
        String curMorseString;
        Queue<Pair> queue = new LinkedList<Pair>();
        
        queue.add(new Pair(root, "")); // Add root with empty string to start off queue.
        
        while(!queue.isEmpty()) { // If queue is empty, we've searched the entire tree.
            nodeMorsePair = queue.poll();
            curNode = nodeMorsePair.node;
            curMorseString = nodeMorsePair.morseString;
            
            if(curNode.data != letter) {
                if(curNode.left != null) {
                    // Add left to queue and add the previous morse string + "."
                    queue.add(new Pair(curNode.left, curMorseString + ".")); 
                }
                if(curNode.right != null) {
                    // Add right to queue and add the previous morse string + "-"
                    queue.add(new Pair(curNode.right, curMorseString + "-"));
                }
            } else {
                return curMorseString; // Character found, return the current morse string associated with the current pair.
            }
        }
        
        return String.valueOf(letter); // Character not found in tree.
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
