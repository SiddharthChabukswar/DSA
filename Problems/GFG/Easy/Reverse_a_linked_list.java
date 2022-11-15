package GFG.Easy;

import GFG.Utils.LL.Node;

/*

https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-linked-list

Reverse a linked list

Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 6 5 4 3 2 1
Explanation: After reversing the list, 
elements are 6->5->4->3->2->1.
Example 2:

Input:
LinkedList: 2->7->8->9->10
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
Your Task:
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104


*/

public class Reverse_a_linked_list {

	//Function to reverse a linked list. 
	/*
	// Iterative
	Node reverseList(Node head) {
		Node prev = null, curr = head, next = head.next;
		while(next != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = curr.next;
		}
		curr.next = prev;
		return curr;
	}
	*/

	// Recursive
	Node reverseList(Node head) {
		Node curr = head, currNext;
		if(head == null || head.next == null) return head;
		head = reverseList(head.next);
		currNext = curr.next;
		currNext.next = curr;
		curr.next = null;
		return head;
	}

}