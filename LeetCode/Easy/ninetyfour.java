package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/binary-tree-inorder-traversal/

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


*/


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

public class ninetyfour {

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
	
	
	// Recursive Solution O(n)
	/*
	// Print inorder string O(n)
	public void inorder(TreeNode curr){
		if(curr == null) return;
		inorder(curr.left);
		System.out.println(curr.val);
		inorder(curr.right);
	}

	// Get inorder List O(n)
	public void inorder(TreeNode curr, List<Integer> inorder_List){
		if(curr == null) return;
		inorder(curr.left, inorder_List);
		inorder_List.add(curr.val);
		inorder(curr.right, inorder_List);
	}

	// Call recursive function O(n)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder_List = new ArrayList<Integer>();
		inorder(root, inorder_List);
		return inorder_List;
	}

	*/


	// Iterative Solution O(n)

	// call iterative function O(n)
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder_List = new ArrayList<Integer>();

		return inorder_List;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		ninetyfour objNinetyfour = new ninetyfour();
		TreeNode root = objNinetyfour.createTree(root_val, sc);
		List<Integer> inorder_list = objNinetyfour.inorderTraversal(root);
		System.out.println(inorder_list);
		sc.close();
	}
}
