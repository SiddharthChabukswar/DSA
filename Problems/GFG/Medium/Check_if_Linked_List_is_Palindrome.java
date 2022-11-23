package GFG.Medium;

import GFG.Utils.LL.Node;

/*

https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=check-if-linked-list-is-pallindrome

Check if Linked List is Palindrome

Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Constraints:
1 <= N <= 105

*/

class nodeStartPair {
	Node first;
	Node second;
	nodeStartPair (Node first, Node second) {
		this.first = first;
		this.second = second;
	}
	Node getFirst() {
		return this.first;
	}
	Node getSecond() {
		return this.second;
	}
}

public class Check_if_Linked_List_is_Palindrome {

	nodeStartPair getNodeStartPair(Node head) {
		Node slowNode = head, fastNode = head, currNode = head, prevNode = null;
		while(fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = slowNode;
		}
		if(fastNode == null) return new nodeStartPair(prevNode, slowNode);
		return new nodeStartPair(prevNode, slowNode.next);
	}

	//Function to check whether the list is palindrome.
	boolean isPalindrome(Node head) {
		nodeStartPair nodePair = getNodeStartPair(head);
		Node first = nodePair.getFirst();
		Node second = nodePair.getSecond();
		while(first != null && second != null) {
			if(first.data != second.data) return false;
			first = first.next;
			second = second.next;
		}
		return true;
	}

}