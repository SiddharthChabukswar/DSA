package LeetCode.Medium;

/*

https://leetcode.com/problems/rotate-list/description/

61. Rotate List
Medium

Given the head of a linked list, rotate the list to the right by k places.

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109

*/

public class _61 {
	
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null) return null;
		ListNode newHead = head, currTail, newTail;
		for(int i=0; i<k; i++) {
			newHead = newHead.next;
			if(newHead == null) newHead = head;
		}
		if(newHead == head) return head;
		currTail = newHead;
		newTail = head;
		while(currTail.next != null) {
			newTail = newTail.next;
			currTail = currTail.next;
		}
		newHead = newTail.next;
		newTail.next = null;
		currTail.next = head;
		return newHead;
	}
}