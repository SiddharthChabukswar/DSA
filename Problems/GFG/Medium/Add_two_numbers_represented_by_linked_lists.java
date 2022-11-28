package GFG.Medium;

import GFG.Utils.LL.Node;

/*

https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-two-numbers-represented-by-linked-lists

Add two numbers represented by linked lists
Medium

This problem is part of GFG SDE Sheet. Click here to view more.  

Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.

For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the sum list.   

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(Max(N,M)) for the resultant list.

Constraints:
1 <= N, M <= 5000

*/

public class Add_two_numbers_represented_by_linked_lists {

	private static Node reverseList(Node head) {
		Node curr = head, prev = null, next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static Node addTwoRevLists(Node list1, Node list2) {
		Node ptr1 = list1, ptr2 = list2;
		Node sumList = null, currNode = null, newNode = null;
		int sum = 0, carry = 0;
		while(ptr1 != null || ptr2 != null) {
			sum = carry;
			if(ptr1 != null) {
				sum += ptr1.data;
				ptr1 = ptr1.next;
			}
			if(ptr2 != null) {
				sum += ptr2.data;
				ptr2 = ptr2.next;
			}
			carry = sum / 10;
			sum = sum % 10;
			newNode = new Node(sum);
			if(sumList == null) sumList = newNode;
			else currNode.next = newNode;
			currNode = newNode;
		}
		if(carry != 0) {
			newNode = new Node(carry);
			if(sumList == null) sumList = newNode;
			else currNode.next = newNode;
		}
		return sumList;
	}

	//Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
		first = reverseList(first);
		second = reverseList(second);
		Node sumList = addTwoRevLists(first, second);
		sumList = reverseList(sumList);
		return sumList;
	}

}