package LeetCode.Easy;

import java.util.Scanner;
import java.util.Stack;


/*

https://leetcode.com/problems/same-tree/

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

*/

/*
// Defined in problem 94
// Definition for a binary tree node.

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

*/


public class hundred {

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


	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		else if(p == null || q == null) return false;
		// System.out.printf("p: %d && q: %d\n", p.val, q.val);
		if(p.val != q.val) return false;
		else return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hundred objHundred = new hundred();

		System.out.print("Enter root1: ");
		int root_val = sc.nextInt();
		TreeNode root1 = objHundred.createTree(root_val, sc);
		
		System.out.print("Enter root2: ");
		root_val = sc.nextInt();
		TreeNode root2 = objHundred.createTree(root_val, sc);

		boolean answer = objHundred.isSameTree(root1, root2);
		System.out.println(answer);
		sc.close();
	}
}
