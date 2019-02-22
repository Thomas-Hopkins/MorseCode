package MorseTree;

/**
 * Binary tree node as shown in class.
 *
 * @param <T>
 */
public class BTNode<T> {
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
