package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.

*/

public class hundredandeight {


	// Recursive Creation using binary search (Divide and conquer) O(n)
	/*
	public TreeNode createTree(int[] nums, int left, int right){
		if(left > right) return null;
		// System.out.printf("Left: %d,  Right:%d  \n", left, right);
		int mid = (right - left)/2 + left;
		TreeNode curr = new TreeNode(nums[mid]);
		curr.left = createTree(nums, left, mid-1);
		curr.right = createTree(nums, mid+1, right);
		return curr;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) return null;
		TreeNode head = createTree(nums, 0, nums.length-1);
		return head;
	}
	*/

	// Iterative binary sarch (Divide and conquer) O(n)
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) return null;
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements one by one: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		hundredandeight objHundredandeight = new hundredandeight();
		TreeNode head = objHundredandeight.sortedArrayToBST(nums);
		System.out.println(head.val);
		sc.close();
	}

}
