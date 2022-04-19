package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list/

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:


Input: head = [1,1,2]
Output: [1,2]
Example 2:


Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

*/

// Already compiled in problem twentyone

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) { 
		this.val = val;
		this.next = next;
	}
}


public class eightythree {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return null;
		ListNode finalListHead = head;
		ListNode a = head;
		ListNode b = head;
		while(b != null){
			if(a.val != b.val){
				a.next = b;
				a = a.next;
			}
			b = b.next;
		}
		a.next = null;
		return finalListHead;
	}


	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the length of LinkedList: ");
			int n = sc.nextInt();
			System.out.println("Enter the elements:");
			int i, temp = 0;
			ListNode head = null, curr = null, newNode = null;
			head = new ListNode(0);
			curr = head;
			for(i=0; i<n; i++){
				temp = sc.nextInt();
				newNode = new ListNode(temp);
				curr.next = newNode;
				curr = newNode;
			}
			head = head.next;
			eightythree objEightythree = new eightythree();
			ListNode newHead = objEightythree.deleteDuplicates(head);
			System.out.println("Final list of elements:");
			while(newHead!=null){
				System.out.println(newHead.val);
				newHead = newHead.next;
			}
			sc.close();
		}
	}
}
