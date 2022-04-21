package LeetCode.Easy;

import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/path-sum/

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class hundredandtwelve {
	
	public TreeNode createTree(int root_val, Scanner sc) {
		TreeNode root;
		if(root_val == -1) return null;
		root = new TreeNode(root_val);
		TreeNode currnode, leftnode, rightnode;
		int new_val;
		Stack<TreeNode> node_stack = new Stack<TreeNode>();
		node_stack.add(root);
		while(node_stack.size() != 0){
			currnode = node_stack.pop();
			if(currnode == null) continue;

			System.out.printf("\nEnter left node of %d: ", currnode.val);
			new_val = sc.nextInt();
			if(new_val == -1) leftnode = null;
			else leftnode = new TreeNode(new_val);

			System.out.printf("\nEnter right node of %d: ", currnode.val);
			new_val = sc.nextInt();
			if(new_val == -1) rightnode = null;
			else rightnode = new TreeNode(new_val);

			currnode.left = leftnode;
			currnode.right = rightnode;

			node_stack.add(leftnode);
			node_stack.add(rightnode);
		}

		return root;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		hundredandtwelve objHundredandtwelve = new hundredandtwelve();
		TreeNode root = objHundredandtwelve.createTree(root_val, sc);
		System.out.print("Enter target: ");
		int targetSum = sc.nextInt();
		boolean answer = objHundredandtwelve.hasPathSum(root, targetSum);
		System.out.println(answer);
		sc.close();
	}
	
}
