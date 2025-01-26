package LeetCode.Medium;

/*



*/

class Node {
	int val;
	Node next;
	Node random;
	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class _138 {
	
	public Node copyRandomList(Node head) {
		if (head == null) return null;
		
		// handle nexts
		Node currNode = head, newNode;
		while (currNode != null) {
			newNode = new Node(currNode.val);
			newNode.next = currNode.next;
			currNode.next = newNode;
			currNode = newNode.next;
		}

		// handle randoms
		currNode = head;
		while (currNode != null) {
			newNode = currNode.next;
			if (currNode.random != null) newNode.random = currNode.random.next;
			else newNode.random = null;
			currNode = newNode.next;
		}

		// separate the lists
		currNode = head;
		Node headClone = currNode.next;
		while (currNode != null) {
			newNode = currNode.next;
			currNode.next = newNode.next;
			currNode = currNode.next;
			if (currNode != null) newNode.next = currNode.next;
			else newNode.next = null;
		}

		return headClone;
	}

}
