package LeetCode.Easy;

import java.util.Scanner;

/*



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

public class twohundredandsix {

	// Iterative Solution using stack time and space O(n)
	/*
	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
		Stack<ListNode> node_stack = new Stack<ListNode>();
		while(head!=null){
			node_stack.add(head);
			head = head.next;
		}
		head = node_stack.pop();
		ListNode curr = head, temp = null;
		while(node_stack.size()!=0){
			temp = node_stack.pop();
			curr.next = temp;
			curr = temp;
		}
		curr.next = null;
		return head;
	}
	*/

	// Iterative Solution time O(n) and space O(1)
	public ListNode reverseList(ListNode head) {
		if(head == null) return head;
		ListNode ptr2 = head, ptr3;
		head = null;
		while(ptr2!=null){
			ptr3 = ptr2.next;
			ptr2.next = head;
			head = ptr2;
			ptr2 = ptr3;
		}
		return head;
	}

	// Recursive Solution time and space O(n)
	/*
	public ListNode reverseList(ListNode head) {
		return null;
	}
	*/


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

			twohundredandsix objTwohundredandsix = new twohundredandsix();
			head = objTwohundredandsix.reverseList(head);

			System.out.println("Answer list: ");
			while(head!=null){
				System.out.printf("%d ", head.val);
				head = head.next;
			}
			sc.close();
		}
	}

}
