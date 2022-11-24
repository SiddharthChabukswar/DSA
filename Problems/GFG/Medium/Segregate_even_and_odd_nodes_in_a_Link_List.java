package GFG.Medium;

import GFG.Utils.LL.Node;

/*

Segregate even and odd nodes in a Link List

Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.


Example 1:

Input: 
N = 7
Link List:
17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL

Output: 8 2 4 6 17 15 9

Explaination: 8,2,4,6 are the even numbers 
so they appear first and 17,15,9 are odd 
numbers that appear later.

Example 2:

Input:
N = 4
Link List:
1 -> 3 -> 5 -> 7

Output: 1 3 5 7

Explaination: There is no even number. 
So ne need for modification.

Your Task:
You do not need to read input or print anything. Your task is to complete the function divide() which takes N and head of Link List as input parameters and returns the head of modified link list. Don't create a new linked list, instead rearrange the provided one.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Each element of the list ≤ 105

*/

public class Segregate_even_and_odd_nodes_in_a_Link_List {

	Node divide(int N, Node head) {
		Node newHead = null, currEven = null;
		while(head != null && head.data%2 == 0) {
			if(newHead == null) newHead = head;
			currEven = head;
			head = head.next;
		}
		Node prev = head, curr = head;
		while(curr != null) {
			if(curr.data%2 == 0) {
				if(newHead == null) newHead = curr;
				else currEven.next = curr;
				currEven = curr;
				prev.next = curr.next;
				curr.next = null;
				curr = prev.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		if(currEven == null) return head;
		currEven.next = head;
		return newHead;
	}
}