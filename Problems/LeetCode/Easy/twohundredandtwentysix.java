package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/invert-binary-tree/

Given the root of a binary tree, invert the tree, and return its root.

 

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

*/

public class twohundredandtwentysix {
	
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

	// Recursive solution O(n) Top-bottom approach
	/*
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode temp = new TreeNode();
		temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;
	}
	*/

	// Recursive solution O(n) Bottom-up approach
	/*
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode leftSubTree = invertTree(root.left);
		TreeNode rightSubTree = invertTree(root.right);
		root.left = rightSubTree;
		root.right = leftSubTree;
		return root;
	}
	*/

	// Iterative solution O(n) BFS
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		Queue<TreeNode> node_queue = new LinkedList<TreeNode>();
		TreeNode curr, leftnode, rightnode;
		node_queue.offer(root);
		while(!node_queue.isEmpty()){
			curr = node_queue.poll();
			leftnode = curr.left;
			rightnode = curr.right;
			curr.left = rightnode;
			curr.right = leftnode;
			if(rightnode!=null) node_queue.offer(rightnode);
			if(leftnode!=null) node_queue.offer(leftnode);
		}
		return root;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		twohundredandtwentysix objTwohundredandtwentysix = new twohundredandtwentysix();
		TreeNode root = objTwohundredandtwentysix.createTree(root_val, sc);
		root = objTwohundredandtwentysix.invertTree(root);
		sc.close();
	}
}
