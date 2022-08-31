package LeetCode.Easy;

import java.util.Scanner;

/*

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50

*/

public class twohundredandthree {

	// Two pointer method
	public ListNode removeElements(ListNode head, int val) {
		while(head!=null && head.val == val) head = head.next;
		if(head == null) return null;
		ListNode ptr1 = head, ptr2 = head.next;
		while(ptr2!=null){
			if(ptr2.val!=val){
				ptr1.next = ptr2;
				ptr1 = ptr1.next;
			}
			ptr2 = ptr2.next;
		}
		ptr1.next = null;
		return head;
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int i, n;
			System.out.print("\nEnter size of array: ");
			n = sc.nextInt();
			System.out.println("\nEnter array elements one by one: ");
			int[] arr1 = new int[n];
			for(i=0; i<n; i++){
				arr1[i] = sc.nextInt();
			}
			
			System.out.print("\nEnter element to be removed: ");
			int val = sc.nextInt();

			ListNode currNode, newNode;
			ListNode head = null;
			currNode = null;
			newNode = null;
			for(i=0; i<n; i++){
				newNode = new ListNode(arr1[i]);
				if(head == null) head = newNode;
				else currNode.next = newNode;
				currNode = newNode;
			}

			twohundredandthree objTwohundredandthree = new twohundredandthree();
			head = objTwohundredandthree.removeElements(head, val);

			System.out.println("Answer list: ");
			while(head!=null){
				System.out.printf("%d ", head.val);
				head = head.next;
			}
			sc.close();
		}
	}

}
