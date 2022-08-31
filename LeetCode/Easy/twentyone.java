package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/merge-two-sorted-lists/

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

list1: 1 -> 2 -> 4
list2: 1 -> 3 -> 4

Answer: 1 -> 1 -> 2 -> 3 -> 4 -> 4


Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

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

public class twentyone {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode answer = new ListNode();
		
		// System.out.println("List1: ");
		// while(list1!=null){
		// 	System.out.println(list1.val);
		// 	list1 = list1.next;
		// }

		// System.out.println("List2: ");
		// while(list2!=null){
		// 	System.out.println(list2.val);
		// 	list2 = list2.next;
		// }

		// Basic two pointer compare method
		if(list1 == null) return list2;
		else if(list2 == null) return list1;
		ListNode answerPtr = answer;
		while(list1!=null && list2!=null){
			if(list1.val <= list2.val){
				answerPtr.next = list1;
				list1 = list1.next;
			}
			else if(list1.val > list2.val){
				answerPtr.next = list2;
				list2 = list2.next;
			}
			answerPtr = answerPtr.next;
		}

		if(list1!=null) answerPtr.next = list1;
		else if(list2!=null) answerPtr.next = list2;		

		return answer.next;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int i, n1, n2;
			System.out.print("\nEnter size of 1st array: ");
			n1 = sc.nextInt();
			System.out.println("\nEnter array 1 elements one by one: ");
			int[] arr1 = new int[n1];
			for(i=0; i<n1; i++){
				arr1[i] = sc.nextInt();
			}
			System.out.print("\nEnter size of 2nd array: ");
			n2 = sc.nextInt();
			System.out.println("\nEnter array 2 elements one by one: ");
			int[] arr2 = new int[n2];
			for(i=0; i<n2; i++){
				arr2[i] = sc.nextInt();
			}

			ListNode currNode, newNode;
			ListNode list1 = null;
			currNode = null;
			newNode = null;
			for(i=0; i<n1; i++){
				newNode = new ListNode(arr1[i]);
				if(list1 == null) list1 = newNode;
				else currNode.next = newNode;
				currNode = newNode;
			}

			ListNode list2 = null;
			currNode = null;
			newNode = null;
			for(i=0; i<n2; i++){
				newNode = new ListNode(arr2[i]);
				if(list2 == null) list2 = newNode;
				else currNode.next = newNode;
				currNode = newNode;
			}

			twentyone objTwentyone = new twentyone();
			ListNode list3 = objTwentyone.mergeTwoLists(list1, list2);

			System.out.println("Answer list: ");
			while(list3!=null){
				System.out.printf("%d ", list3.val);
				list3 = list3.next;
			}
			sc.close();
		}
	}
}
