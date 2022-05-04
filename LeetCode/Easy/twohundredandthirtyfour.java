package LeetCode.Easy;

import java.util.Scanner;

/*

Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:

Input: head = [1,2,2,1,]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?

*/

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

public class twohundredandthirtyfour {
	
	// Store linked list in an array : O(n) Space O(n)
	/*
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;
		ListNode curr = head;
		int n = 0, i;
		while(curr!=null){
			curr = curr.next;
			n++;
		}
		int[] nums = new int[n];
		curr = head;
		for(i=0; i<n; i++){
			nums[i] = curr.val;
			curr = curr.next;
		}
		for(i=0; i<n/2; i++) if(nums[i] != nums[n-i-1]) return false;
		return true;
	}
	*/

	// reverse LinkedList and check if both are equal: O(n)
	/*
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;
        ListNode reverseHead = new ListNode(0);
		reverseList(head, reverseHead);
		while(head!=null){
			if(reverseHead.val != head.val) return false;
			head = head.next;
			reverseHead = reverseHead.next;
		}
		return true;
	}

	ListNode reverseList(ListNode head, ListNode reverseHead) {
		if(head.next == null){
			reverseHead.val = head.val;
			return reverseHead;
		}
		ListNode curr = new ListNode(head.val);
		ListNode currnext = reverseList(head.next, reverseHead);
		curr.next = null;
		currnext.next = curr;
		return curr;
	}
	*/

	// Reverse from mid of the linkedList
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		ListNode tortoise = head, hare = head.next;
		while(hare.next!=null && hare.next.next!=null){
			tortoise = tortoise.next;
			hare = hare.next.next;
		}
		ListNode head2 = tortoise.next, mid = head2.next, right = null;
		tortoise.next = null;
		head2.next = null;
		while(mid!=null){
			right = mid.next;
			mid.next = head2;
			head2 = mid;
			mid = right;
		}

		while(head!=null){
			// System.out.printf("head: %d || head2: %d\n", head.val, head2.val);
			if(head.val != head2.val) return false;
			head = head.next;
			head2 = head2.next;
		}
		return true;
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
			curr.next = null;
			twohundredandthirtyfour objTwohundredandthirtyfour = new twohundredandthirtyfour();
			System.out.println(objTwohundredandthirtyfour.isPalindrome(head));
			sc.close();
		}
	}
	
}