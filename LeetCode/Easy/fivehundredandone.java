package LeetCode.Easy;

import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;

/*

https://leetcode.com/problems/find-mode-in-binary-search-tree/

Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [1,null,2,2]
Output: [2]
Example 2:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105
 

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

*/

public class fivehundredandone {

	// No HashMap Recursive solution O(n) & O(1)
	List<Integer> ans_list;
	Integer prev, count, max_count;

	public void inorderTraversal(TreeNode node) {
		if(node == null) return;
		inorderTraversal(node.left);
		if(prev != null){
			if(prev == node.val) count++;
			else count = 1;
		}

		if(count > max_count){
			ans_list.clear();
			max_count = count;
		}
		if(count == max_count){
			ans_list.add(node.val);
		}
		prev = node.val;
		inorderTraversal(node.right);
	}

	public int[] findMode(TreeNode root) {
		ans_list = new ArrayList<Integer>();
		count = 1;
		max_count = 0;
		inorderTraversal(root);
		int n = ans_list.size(), i;
		int[] answer = new int[n];
		for(i=0; i<n; i++) answer[i] = ans_list.get(i);
		return answer;
	}


	// Filling HashMap in recursion. Slightly better. O(n)
	/*
	HashMap<Integer, Integer> frequency_map;
	Integer mode_value;

	void inorderTraversal(TreeNode curr){
		if(curr == null) return;
		inorderTraversal(curr.left);
		Integer curr_map_value = frequency_map.get(curr.val);
		if(curr_map_value == null) curr_map_value = 0;
		frequency_map.put(curr.val, curr_map_value+1);
		mode_value = Math.max(mode_value, curr_map_value+1);
		inorderTraversal(curr.right);
	}

	public int[] findMode(TreeNode root) {
		List<Integer> ans_list = new ArrayList<Integer>();
		frequency_map = new HashMap<Integer, Integer>();
		mode_value = 0;
		inorderTraversal(root);
		for(Integer key: frequency_map.keySet()) if(frequency_map.get(key) == mode_value) ans_list.add(key);
		int n = ans_list.size(), i;
		int[] answer = new int[n];
		for(i=0; i<n; i++) answer[i] = ans_list.get(i);
		return answer;
	}
	*/

	// Using HashMap and inorder traversal O(n) Slow
	/*
	void inorderTraversal(TreeNode curr, List<Integer> inorder_list){
		if(curr == null) return;
		inorderTraversal(curr.left, inorder_list);
		inorder_list.add(curr.val);
		inorderTraversal(curr.right, inorder_list);
	}

	public int[] findMode(TreeNode root) {
		List<Integer> ans_list = new ArrayList<Integer>();
		List<Integer> inorder_list = new ArrayList<Integer>();
		inorderTraversal(root, inorder_list);
		// System.out.println(inorder_list.toString());
		HashMap<Integer, Integer> frequency_map = new HashMap<Integer, Integer>();
		Integer curr_map_value, mode_value = 0;
		for(Integer curr_ele: inorder_list){
			curr_map_value = frequency_map.get(curr_ele);
			if(curr_map_value == null) curr_map_value = 0;
			frequency_map.put(curr_ele, curr_map_value+1);
			mode_value = Math.max(mode_value, curr_map_value+1);
		}
		// System.out.println(mode_value);
		for(Integer key: frequency_map.keySet()) if(frequency_map.get(key) == mode_value) ans_list.add(key);
		int n = ans_list.size(), i;
		int[] answer = new int[n];
		for(i=0; i<n; i++) answer[i] = ans_list.get(i);
		return answer;
	}
	*/
}
