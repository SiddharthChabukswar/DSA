package GFG.Utils.DLL;

/*
 * Representation class of a Doubly linkedList
*/

public class Node {
	
	public int data;
	public Node next;
	public Node prev;
	public Node(int x) {
		data = x;
		next = null;
		prev = null;
	}

}
