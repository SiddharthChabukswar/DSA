package GFG.Easy;

import GFG.Utils.Node;

/*

https://practice.geeksforgeeks.org/problems/delete-a-node-in-single-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-a-node-in-single-linked-list

Given a singly linked list and an integer x.Delete xth node from the singly linked list.

Example 1:

Input: 1 -> 3 -> 4 
       x = 3
Output: 1 -> 3
Explanation:
After deleting the node at 3rd
position (1-base indexing), the
linked list is as 1 -> 3. 
Example 2:

Input: 1 -> 5 -> 2 -> 9 
x = 2
Output: 1 -> 2 -> 9
Explanation: 
After deleting the node at 2nd
position (1-based indexing), the
linked list is as 1 -> 2 -> 9.
 

Your task: Your task is to complete the method deleteNode() which takes two arguments: the address of the head of the linked list and an integer x. The function returns the head of the modified linked list.

Constraints:
1 <= T <= 300
2 <= N <= 100
1 <= x <= N

*/

public class Delete_a_Node_in_Single_Linked_List {

	Node deleteNode(Node head, int x) {
		Node prevNode = head, nextNode = null;
		if(x == 1) {
			head = head.next;
			prevNode.next = null;
		} else {
			x--;
			while(--x > 0) prevNode = prevNode.next;
			// System.out.println(prevNode.data);
			nextNode = prevNode.next.next;
			prevNode.next.next = null;
			prevNode.next = nextNode;
		}
		return head;
	}

}