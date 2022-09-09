package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/linked-list-cycle/

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
 

Follow up: Can you solve it using O(1) (i.e. constant) memory?

*/

public class hundredandfourtyone {

	// HashSet implementation O(n) : Extra space O(n)
	/*
	public boolean hasCycle(ListNode head) {
		HashSet<ListNode> nodeSet = new HashSet<ListNode>();
		while(head!=null){
			if(nodeSet.contains(head)) return true;
			nodeSet.add(head);
			head = head.next;
		}
		return false;
	}
	*/

	// Floyd's hare and tortoise solution : Two pointer O(n) : Space O(1)
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		ListNode slow=head, fast=head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
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
			ListNode cycleJoin = head;
			System.out.print("Enter pos: ");
			int pos = sc.nextInt();
			for(i=0; i<pos; i++) cycleJoin = cycleJoin.next;
			if(pos < 0) curr.next = null;
			else curr.next = cycleJoin; 
			hundredandfourtyone objHundredandfourtyone = new hundredandfourtyone();
			boolean answer = objHundredandfourtyone.hasCycle(head);
			System.out.println(answer);
			sc.close();
		}
	}
}
