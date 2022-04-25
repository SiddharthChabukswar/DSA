package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/binary-tree-postorder-traversal/

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?

*/

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

public class hundredandfourtyfive {
	
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

	// Recursive approach O(n)
	/*
	public void postorder(TreeNode node, List<Integer> postorder_list){
		if(node == null) return;
		postorder(node.left, postorder_list);
		postorder(node.right, postorder_list);
		postorder_list.add(node.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postorder_list = new ArrayList<Integer>();
		postorder(root, postorder_list);
		return null;
	}
	*/

	// Iterative approach O(n) , Two stack method Space: O(n)

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postorder_list = new ArrayList<Integer>();
		if(root == null){
			return postorder_list;
		}
		else{
			Stack<TreeNode> node_stack = new Stack<TreeNode>();
			Stack<TreeNode> answer_stack = new Stack<TreeNode>();
			TreeNode curr = root;
			node_stack.add(curr);
			while(!node_stack.isEmpty()){
				curr = node_stack.pop();
				answer_stack.add(curr);
				if(curr.left != null) node_stack.add(curr.left);
				if(curr.right != null) node_stack.add(curr.right);
			}
			while(!answer_stack.isEmpty()) postorder_list.add(answer_stack.pop().val);
			return postorder_list;
		}	
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hundredandfourtyfive objHundredandfourtyfive = new hundredandfourtyfive();

		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		TreeNode root = objHundredandfourtyfive.createTree(root_val, sc);
		
		List<Integer> answer = objHundredandfourtyfive.postorderTraversal(root);
		System.out.println(answer);
		sc.close();
	}
	
}
