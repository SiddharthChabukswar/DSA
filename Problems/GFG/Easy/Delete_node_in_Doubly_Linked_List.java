package GFG.Easy;

import GFG.Utils.DLL.Node;

/*

https://practice.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-node-in-doubly-linked-list

Delete node in Doubly Linked List

Given a doubly linked list and a position. The task is to delete a node from given position in a doubly linked list.

Example 1:

Input:
LinkedList = 1 <--> 3 <--> 4 
x = 3
Output: 1 3  
Explanation: After deleting the node at
position 3 (position starts from 1),
the linked list will be now as 1->3.
Example 2:

Input:
LinkedList = 1 <--> 5 <--> 2 <--> 9  
x = 1
Output: 5 2 9
Your Task:
The task is to complete the function deleteNode() which should delete the node at given position and return the head of the linkedlist.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
2 <= size of the linked list <= 1000
1 <= x <= N

*/

public class Delete_node_in_Doubly_Linked_List {

	// function returns the head of the linkedlist
	Node deleteNode(Node head, int x) {
		Node currNode = head;
		x--;
		while(x-- != 0) currNode = currNode.next;
		if(currNode == head) head = head.next;
		if(currNode.prev != null) {
			currNode.prev.next = currNode.next;
		}
		if(currNode.next != null) {
			currNode.next.prev = currNode.prev;
		}
		currNode.next = null;
		currNode.prev = null;
		currNode = null;
		return head;
	}

}