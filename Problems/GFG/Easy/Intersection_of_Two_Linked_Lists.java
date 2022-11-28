package GFG.Easy;

import java.util.HashSet;
import GFG.Utils.LL.Node;

/*

Intersection of Two Linked Lists

Given two linked lists, the task is to complete the function findIntersection(), that returns the intersection of two linked lists. Each of the two linked list contains distinct node values.

Example 1:

Input:
LinkedList1: 9->6->4->2->3->8
LinkedList2: 1->2->8->6
Output: 6 2 8
Your Task:
You task is to complete the function findIntersection() which takes the heads of the 2 input linked lists as parameter and returns the head of intersection list. Returned list will be automatically printed by driver code.
Note: The order of nodes in this list should be same as the order in which those particular nodes appear in input list 1.

Constraints:
1 <= n,m <= 104

Expected time complexity: O(m+n)
Expected auxiliary space: O(m+n)

*/

public class Intersection_of_Two_Linked_Lists {

	public static Node findIntersection(Node head1, Node head2) {
		HashSet<Integer> dataSet = new HashSet<Integer>();
		Node curr = head2;
		while(curr != null) {
			dataSet.add(curr.data);
			curr = curr.next;
		}
		Node intersectionList = null, presNode = null, newNode;
		curr = head1;
		while(curr != null) {
			if(dataSet.contains(curr.data) == true) {
				newNode = new Node(curr.data);
				if(intersectionList == null) intersectionList = newNode;
				else presNode.next = newNode;
				presNode = newNode;
				dataSet.remove(curr.data);
			}
			curr = curr.next;
		}
		return intersectionList;
	}

}