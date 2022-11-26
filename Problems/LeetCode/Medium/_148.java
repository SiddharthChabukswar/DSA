package LeetCode.Medium;

/*

https://leetcode.com/problems/sort-list/

148. Sort List
Medium

Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

*/

public class _148 {

	ListNode mergeSortedLists(ListNode list1, ListNode list2) {
		if(list1.val > list2.val) return mergeSortedLists(list2, list1);
		ListNode ptr1 = list1, ptr2 = list2, pptr1 = null, pptr2 = null;
		while(ptr1 != null && ptr2 != null) {
			// System.out.println(ptr1.val + " " + ptr2.val);
			if(ptr1.val <= ptr2.val) {
				pptr1 = ptr1;
				ptr1 = ptr1.next;
			} else {
				pptr2 = ptr2.next;
				pptr1.next = ptr2;
				ptr2.next = ptr1;
				pptr1 = ptr2;
				ptr2 = pptr2;
			}
		}
		if(ptr2 != null) pptr1.next = ptr2;
		return list1;
	}

	ListNode findBreakNode(ListNode list) {
		ListNode slow = list, fast = list, prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return prev;
	}

	ListNode mergeSortListNode(ListNode list) {
		if(list == null || list.next == null) return list;
		ListNode midpoint = findBreakNode(list);
		ListNode midpoint2 = midpoint.next;
		midpoint.next = null;
		ListNode list1 = mergeSortListNode(list);
		ListNode list2 = mergeSortListNode(midpoint2);
		// midpoint = list1;
		// midpoint2 = list2;
		// System.out.println();
		// System.out.print("list1 : ");
		// while(midpoint!=null) {
		// 	System.out.print(midpoint.val + "->");
		// 	midpoint = midpoint.next;
		// }
		// System.out.println();
		// System.out.print("list2 : ");
		// while(midpoint2!=null) {
		// 	System.out.print(midpoint2.val + "->");
		// 	midpoint2 = midpoint2.next;
		// }
		// System.out.println();
		return mergeSortedLists(list1, list2);
	}

	public ListNode sortList(ListNode head) {
		return mergeSortListNode(head);
	}
	
}
