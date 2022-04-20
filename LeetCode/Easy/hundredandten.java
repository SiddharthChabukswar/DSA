package LeetCode.Easy;

import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/balanced-binary-tree/

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

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

public class hundredandten {

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

	// Top Down Approach O(n^2) : Heights of each subtree is recalculated, Could be improved using hashmaps (Storing heights)
	/*
	public int findHeight(TreeNode node){
		if(node == null) return 0;
		return 1 + Math.max(findHeight(node.left), findHeight(node.right));
	}
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		int lheight = findHeight(root.left);
		int rheight = findHeight(root.right);
		int heightDiff = Math.abs(lheight - rheight);
		//System.out.printf("lheight: %d, rheight: %d , heightDiff: %d\n", lheight, rheight, heightDiff);
		if(heightDiff > 1) return false;
		return (true && isBalanced(root.left) && isBalanced(root.right));
	}
	*/

	// Bottom up Approach O(n) : We'll start from bottom return -1 if unbalanced and height of subtree if balanced.
	// Calculate height such that if height of one of the subtree is -1 return -1

	public int getHeight(TreeNode curr){
		if(curr == null) return 0;
		int lheight, rheight;
		lheight = getHeight(curr.left);
		if(lheight == -1) return -1;
		rheight = getHeight(curr.right);
		if(rheight == -1) return -1;
		if(Math.abs(lheight - rheight) > 1) return -1;
		return 1+Math.max(lheight, rheight);
	}


	public boolean isBalanced(TreeNode root) {
		if(getHeight(root) == -1) return false;
		return true;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		hundredandten objHundredandten = new hundredandten();
		TreeNode root = objHundredandten.createTree(root_val, sc);
		boolean answer = objHundredandten.isBalanced(root);
		System.out.println(answer);
		sc.close();
		sc.close();
	}

}
