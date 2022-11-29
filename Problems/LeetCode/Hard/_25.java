package LeetCode.Hard;

/*

https://leetcode.com/problems/reverse-nodes-in-k-group/

25. Reverse Nodes in k-Group
Hard

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 5000
0 <= Node.val <= 1000
 

Follow-up: Can you solve the problem in O(1) extra memory space?

*/

public class _25 {

	private ListNode reverseList(ListNode head) {
		ListNode curr = head, prev = null, next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 1) return head;
		ListNode nextListHead = head, nextListHeadPrev = null;
		ListNode prevListHead = null, prevListTail = null, revListTail;
		int i;
		while(nextListHead != null) {
			prevListHead = nextListHead;
			for(i=0; i<k; i++) {
				if(nextListHead == null) {
					if(prevListTail != null) prevListTail.next = prevListHead;
					break;
				}
				nextListHeadPrev = nextListHead;
				nextListHead = nextListHead.next;
			}
			if(i!=k) break;
			nextListHeadPrev.next = null;
			revListTail = prevListHead;
			prevListHead = reverseList(prevListHead);
			if(prevListTail == null) {
				head = prevListHead;
			} else {
				prevListTail.next = prevListHead;
			}
			prevListTail = revListTail;
		}
		return head;
	}
	
}
