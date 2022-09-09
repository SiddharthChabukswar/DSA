package LeetCode.Easy;

/*

https://leetcode.com/problems/diameter-of-binary-tree/

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

*/

public class fivehundredandfourtythree {

	private int max_diameter;

	// Get Max height dfs approach
	private int getMaxHeight(TreeNode node) {
		if(node == null) return 0;
		int left_max_height = this.getMaxHeight(node.left);
		int right_max_height = this.getMaxHeight(node.right);
		this.max_diameter = Math.max(this.max_diameter, left_max_height + right_max_height);
		return Math.max(left_max_height, right_max_height) + 1;
	}

	public int diameterOfBinaryTree(TreeNode root) {
		this.max_diameter = Integer.MIN_VALUE;
		this.getMaxHeight(root);
		return this.max_diameter;
	}
	
}
