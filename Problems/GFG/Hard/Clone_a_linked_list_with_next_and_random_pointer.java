package GFG.Hard;

/*

https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=clone-a-linked-list-with-next-and-random-pointer

Clone a linked list with next and random pointer

You are given a special linked list with N nodes where each node has a next pointer pointing to its next node. You are also given M random pointers, where you will be given M number of pairs denoting two nodes a and b  i.e. a->arb = b.

Construct a copy of the given list. The copy should consist of exactly N new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

ArbitLinked List1

Example 1:

Input:
N = 4, M = 2
value = {1,2,3,4}
pairs = {{1,2},{2,4}}
Output: 1
Explanation: In this test case, there
are 4 nodes in linked list.  Among these
4 nodes,  2 nodes have arbitrary pointer
set, rest two nodes have arbitrary pointer
as NULL. Second line tells us the value
of four nodes. The third line gives the
information about arbitrary pointers.
The first node arbitrary pointer is set to
node 2.  The second node arbitrary pointer
is set to node 4.
Example 2:

Input:
N = 4, M = 2
value[] = {1,3,5,9}
pairs[] = {{1,1},{3,4}}
Output: 1
Explanation: In the given testcase ,
applying the method as stated in the
above example, the output will be 1.

Your Task:
The task is to complete the function copyList() which takes one argument the head of the linked list to be cloned and should return the head of the cloned linked list.

NOTE : 
1. If there is any node whose arbitrary pointer is not given then it's by default NULL. 
2. Your solution return an output 1 if your clone linked list is correct, else it returns 0.

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 100
1 <= M <= N
1 <= a, b <= 100
 
*/

class Node {
	int data;
	Node next, arb;
	Node(int d) { 
		data = d;
		next = arb = null;	
	}
}

public class Clone_a_linked_list_with_next_and_random_pointer {

	//Function to clone a linked list with next and random pointer.
	Node copyList(Node head) {
		Node newHead = null, newNode = null;
		Node curr1 = head, curr2 = null;
		while(curr1 != null) {
			newNode = new Node(curr1.data);
			if(newHead == null) newHead = newNode;
			else curr2.next = newNode;
			curr2 = newNode;
			curr1 = curr1.next;
		}
		curr1 = head;
		curr2 = newHead;
		Node arbNode = null, arb1 = null, arb2 = null;
		while(curr1 != null) {
			arbNode = curr1.arb;
			if(arbNode != null) {
				arb1 = head;
				arb2 = newHead;
				while(arb1 != arbNode) {
					arb1 = arb1.next;
					arb2 = arb2.next;
				}
				curr2.arb = arb2;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return newHead;
	}
}