package GFG.Easy;

import GFG.Utils.LL.Node;

/*

https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list

Add 1 to a number represented as linked list
Easy

A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.

Example 1:

Input:
LinkedList: 4->5->6
Output: 457 
Example 2:

Input:
LinkedList: 1->2->3
Output: 124 
Your Task:
Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number.
Note: The head represents the left-most digit of the number.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 101000

*/

public class Add_1_to_a_number_represented_as_linked_list {

	private static Node reverseList(Node head) {
		Node curr = head, prev = null, next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static Node incrementList(Node head) {
		int carry = 1, sum = 0;
		Node curr = head, prev = null;
		while(curr != null) {
			sum = curr.data + carry;
			carry = sum/10;
			sum = sum % 10;
			curr.data = sum;
			prev = curr;
			curr = curr.next;
		}
		if(carry == 1) {
			curr = new Node(1);
			prev.next = curr;
		}
		return head;
	}

	public static Node addOne(Node head){
		head = reverseList(head);
		head = incrementList(head);
		head = reverseList(head);
		return head;
	}
}