package GFG.Medium;

import GFG.Utils.LL.Node;

/*

https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotate-a-linked-list

Rotate a Linked List

Given a singly linked list of size N. The task is to left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

Example 1:

Input:
N = 5
value[] = {2, 4, 7, 8, 9}
k = 3
Output: 8 9 2 4 7
Explanation:
Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
Rotate 3: 8 -> 9 -> 2 -> 4 -> 7
Example 2:

Input:
N = 8
value[] = {1, 2, 3, 4, 5, 6, 7, 8}
k = 4
Output: 5 6 7 8 1 2 3 4

Your Task:
You don't need to read input or print anything. Your task is to complete the function rotate() which takes a head reference as the first argument and k as the second argument, and returns the head of the rotated linked list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
1 <= k <= N

*/

public class Rotate_a_Linked_List {

	//Function to rotate a linked list.
	public Node rotate(Node head, int k) {
		Node newHead = head, newHeadPrev = null, newTail = null;
		for(int i=0; i<k; i++) {
			newHeadPrev = newHead;
			newHead = newHead.next;
		}
		if(newHead == null) return head;
		newTail = newHead;
		while(newTail.next != null) newTail = newTail.next;
		newHeadPrev.next = null;
		newTail.next = head;
		head = newHead;
		return head;
	}

}