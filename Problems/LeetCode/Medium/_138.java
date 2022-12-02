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
		if(head == null) return null;
		Node currNode = head, newNode = null, newHead = null;
		while(currNode != null) {
			newNode = new Node(currNode.val);
			newNode.next = currNode.next;
			currNode.next = newNode;
			currNode = newNode.next;
		}
		newHead = head.next;
		currNode = head;
		while(currNode != null) {
			newNode = currNode.next;
			if(currNode.random != null) newNode.random = currNode.random.next;
			currNode = newNode.next;
		}
		currNode = head;
		newNode = currNode.next;
		Node nextCurrNode = newNode.next, nextNewNode = null;
		while(currNode != null) {
			if(nextCurrNode == null) nextNewNode = null;
			else nextNewNode = nextCurrNode.next;
			currNode.next = nextCurrNode;
			currNode = nextCurrNode;
			if(nextNewNode == null) nextCurrNode = null;
			else nextCurrNode = nextNewNode.next;
			newNode.next = nextNewNode;
			newNode = nextNewNode;
		}
		return newHead;
	}
}
