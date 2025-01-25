package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list

Flattening a Linked List

Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer. For more clearity have a look at the printList() function in the driver code.

 

Example 1:

Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45
Output:  5-> 7-> 8- > 10 -> 19-> 20->
22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation:
The resultant linked lists has every 
node in a single level.
(Note: | represents the bottom pointer.)
 

Example 2:

Input:
5 -> 10 -> 19 -> 28
|          |                
7          22   
|          |                 
8          50 
|                           
30              
Output: 5->7->8->10->19->22->28->30->50
Explanation:
The resultant linked lists has every
node in a single level.

(Note: | represents the bottom pointer.)
 

Your Task:
You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.

 

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

 

Constraints:
0 <= N <= 50
1 <= Mi <= 20
1 <= Element of linked list <= 103

*/

class Node {
	int data;
	Node next;
	Node bottom;
	Node(int d) {
		data = d;
		next = null;
		bottom = null;
	}
}

public class Flattening_a_Linked_List {

	/*
	 * Iterative solution O(M*N*N)
	 */
	/*
	BottomNode flatten(BottomNode root) {
		if(root == null) return null;
		int n = 0, itr = 0, minVal = 0, minValIdx = 0;
		BottomNode curr = root, newHead = null, newBottomNode = null;
		while(curr != null) {
			curr = curr.next;
			n++;
		}
		BottomNode[] branchHead = new BottomNode[n];
		curr = root;
		while(curr != null) {
			branchHead[itr++] = curr;
			curr = curr.next;
		}
		curr = null;
		newHead = null;
		while(true) {
			minVal = 1001;
			minValIdx = -1;
			for(itr = 0; itr<n; itr++) {
				if(branchHead[itr] == null) continue;
				else {
					if(minVal > branchHead[itr].data) {
						minVal = branchHead[itr].data;
						minValIdx = itr;
					}
				}
			}
			if(minVal > 1000) break;
			newBottomNode = new BottomNode(minVal);
			branchHead[minValIdx] = branchHead[minValIdx].bottom;
			if(newHead == null)	newHead = newBottomNode;
			else curr.bottom = newBottomNode;
			curr = newBottomNode;
		}
		return newHead;
	}
	*/

	/*
	 * Recursive solution O(M*N*N)
	 */
	Node flatten(Node root) {
		if (root == null || root.next == null) return root;
		Node flattenNode = flatten(root.next);
		root.next = null;
		return mergeLinkedLists(root, flattenNode);
	}

	private Node mergeLinkedLists(Node list1, Node list2) {
		if (list1 == null) return list2;
		else if (list2 == null) return list1;

		Node mergedList = null, currNode = null;
		if (list1.data <= list2.data) {
			mergedList = list1;
			list1 = list1.bottom;
		}
		else {
			mergedList = list2;
			list2 = list2.bottom;
		}
		currNode = mergedList;
		while (list1 != null && list2 != null) {
			if (list1.data <= list2.data) {
				currNode.bottom = list1;
				currNode = list1;
				list1 = list1.bottom;
			} else {
				currNode.bottom = list2;
				currNode = list2;
				list2 = list2.bottom;
			}
		}
		if (list1 != null) currNode.bottom = list1;
		if (list2 != null) currNode.bottom = list2;
		return mergedList;
	}

}