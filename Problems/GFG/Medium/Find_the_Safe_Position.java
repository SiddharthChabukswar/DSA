package GFG.Medium;

/*

Find the Safe Position

There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed. The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise). In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom.
Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle. The task is to choose the place in the initial circle so that you are the last one remaining and so survive.

Example 1:

Input:
n = 2, k = 1
Output:
2
Explanation:
Here, n = 2 and k = 1, then safe position is
2 as the person at 1st position will be killed.
Example 2:

Input:
n = 4, k = 2
Output:
1
Explanation:
The safe position is 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function safePos() which takes an Integer n as input and returns the safe position.

Expected Time Complexity: O(n*n)
Expected Auxiliary Space: O(n)

Follow up: This problem can be solved in linear time. Can you come up with a solution?

Constraints:
1 <= n,k <= 500

1 2 3 4 5 6 7 8 9 -> 3


*/

class Node {
	int val;
	Node next;
	Node(int val, Node next) {
		this.val = val;
		this.next = next;
	}
}

// TLE
public class Find_the_Safe_Position {

	static Node createCircularLinkedList(int n) {
		int val = 1;
		Node head = new Node(val, null);
		Node newNode, currNode;
		currNode = head;
		for(val = 2; val<=n; val++) {
			newNode = new Node(val, null);
			currNode.next = newNode;
			currNode = newNode;
		}
		currNode.next = head;
		return head;
	}

	static int safePos(int n, int k) {
		Node head = createCircularLinkedList(n);
		Node currNode = head, prevNode = head, tempNode = head;
		while(prevNode.next != head) prevNode = prevNode.next;
		int count;
		while(prevNode.next != prevNode) {
			count = 0;
			while(count < k-1) {
				prevNode = currNode;
				currNode = currNode.next;
				count++;
			}
			tempNode = currNode.next;
			currNode.next = null;
			prevNode.next = tempNode;
			prevNode = tempNode;
			currNode = tempNode;
		}
		return prevNode.val;
	}

}