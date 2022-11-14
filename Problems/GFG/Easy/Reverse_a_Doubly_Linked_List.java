package GFG.Easy;

import GFG.Utils.DLL.Node;

/*

https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-a-doubly-linked-list

Reverse a Doubly Linked List

Given a doubly linked list of n elements. The task is to reverse the doubly linked list.

Example 1:

Input:
LinkedList: 3 <--> 4 <--> 5
Output: 5 4 3
Example 2:

Input:
LinkedList: 75 <--> 122 <--> 59 <--> 196
Output: 196 59 122 75
Your Task:
Your task is to complete the given function reverseDLL(), which takes head reference as argument and should reverse the elements so that the tail becomes the new head and all pointers are correctly pointed. You need to return the new head of the reversed list. The printing and verification is done by the driver code.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= number of nodes <= 103
0 <= value of nodes <= 103

*/

public class Reverse_a_Doubly_Linked_List {

	public static Node reverseDLL(Node head) {
		Node ptr1 = head, ptr2 = head;
		int temp;
		while(ptr2.next != null) ptr2 = ptr2.next;
		while(ptr1 != ptr2 && ptr2.next != ptr1) {
			temp = ptr1.data;
			ptr1.data = ptr2.data;
			ptr2.data = temp;
			ptr1 = ptr1.next;
			ptr2 = ptr2.prev;
		}
		return head;
	}

}