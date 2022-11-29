package GFG.Easy;

import java.util.ArrayList;

import GFG.Utils.DLL.Node;

/*

https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list

Find pairs with given sum in doubly linked list

Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105

*/

public class Find_pairs_with_given_sum_in_doubly_linked_list {

	public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
		if(head == null) return null;
		ArrayList<ArrayList<Integer>> pairList = new ArrayList<>();
		ArrayList<Integer> pair;
		Integer sum;
		Node ptr1 = head, ptr2 = head;
		while(ptr2.next != null) ptr2 = ptr2.next;
		while(ptr1.data < ptr2.data) {
			sum = ptr1.data + ptr2.data;
			if(sum == target) {
				pair = new ArrayList<>();
				pair.add(ptr1.data);
				pair.add(ptr2.data);
				pairList.add(pair);
				ptr1 = ptr1.next;
				ptr2 = ptr2.prev;
			} else if(sum > target) {
				ptr2 = ptr2.prev;
			} else {
				ptr1 = ptr1.next;
			}
		}
		return pairList;
	}

}