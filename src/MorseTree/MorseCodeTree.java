package MorseTree;

import Files.FileHandler;

public class MorseCodeTree {
	
	public MorseCodeTree () {
	}
	
	public void buildTree() {
		FileHandler filehandler = new FileHandler();
		
	}
	
	public String decodeMessage(String message) {
		// TODO: Decode message and return it using constructed binary tree
		return message;
	}
	
	public String encodeMessage(String message) {
		// TODO: Encode message in morse code using binary tree and return it.
		return message;
	}
	
	private boolean insert(BTNode root, T item) {
		if (root.data.compareTo(item) > 0) { // if root is greater than item
			if (root.left == null) { // if left branch empty insert there
				root.left = new BTNode(item);
				return true;
			}
			return insert(root.left, item); // go through again on with left node
		}
		if (root.data.compareTo(item) < 0) { // if root is less than item
			if (root.right == null) { // if right branch empty insert there
				root.right = new BTNode(item);
				return true;
			}
			return insert(root.right, item); // if branch not empty try again on right root
		}
		return false;
	}
	
}
