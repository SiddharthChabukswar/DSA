package GFG.Medium;

import GFG.Utils.LL.Node;

/*

https://practice.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=linked-list-that-is-sorted-alternatingly

Given a Linked list of size N, the list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.

 

Example 1:

Input:
LinkedList: 1->9->2->8->3->7
Output: 1 2 3 7 8 9
Explanation: After sorting the given
list will be 1-> 2-> 3-> 7-> 8-> 9.
 

Example 2:

Input:
LinkedList: 13->99->21->80->50
Output: 13 21 50 80 99
Explanation: After sorting the given list 
will be 12-> 21-> 50-> 80-> 99.
 

Your Task:
You do not need to read input or print anything. The task is to complete the function sort() which should sort the linked list in non-decreasing order. 

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= Number of nodes <= 100
0 <= Values of the linked list <= 103

*/

public class Linked_List_that_is_Sorted_Alternatingly {

	Node MergeTwoSortedLinkedList(Node list1, Node list2) {
		if(list2.data < list1.data) return MergeTwoSortedLinkedList(list2, list1);
		Node ptr1 = list1, pptr1 = null, ptr2 = list2, pptr2 = null;
		while(ptr1 != null && ptr2 != null) {
			if(ptr1.data <= ptr2.data) {
				pptr1 = ptr1;
				ptr1 = ptr1.next;
			} else {
				pptr1.next = ptr2;
				pptr2 = ptr2.next;
				ptr2.next = ptr1;
				pptr1 = ptr2;
				ptr2 = pptr2;
			}
		}
		if(ptr2 != null) pptr1.next = ptr2;
		return list1;
	}

	public Node sort(Node head) {
		if(head.next == null) return head;
		Node odd = head, even = head.next, nodd = even.next, neven = null;
		even.next = null;
		while(nodd != null) {
			neven = nodd.next;
			odd.next = nodd;
			odd = nodd;
			if(neven == null) nodd = null;
			else {
				nodd = neven.next;
				neven.next = even;
				even = neven;
			}
		}
		odd.next = null;
		while(even != null) {
			System.out.print(even.data + " ");
			even = even.next;
		}
		System.out.println();
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
		// head = MergeTwoSortedLinkedList(head, even);
		return head;
	}
}