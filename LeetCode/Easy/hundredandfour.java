package LeetCode.Easy;

import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/maximum-depth-of-binary-tree/

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

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


public class hundredandfour {
	
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

	// Recursive DFS O(n)
	
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max((maxDepth(root.left)), maxDepth(root.right));
	}
	


	// Iterative BFS O(n)
	/*
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		Queue<TreeNode> node_queue = new LinkedList<TreeNode>();
		node_queue.add(root);
		int height = 0, i, queue_len;
		TreeNode curr;
		while(node_queue.size() != 0){
			queue_len = node_queue.size();
			for(i=0; i<queue_len; i++){
				curr = node_queue.remove();
				if(curr.left != null) node_queue.add(curr.left);
				if(curr.right != null) node_queue.add(curr.right);
			}
			height++;
		}
		return height;
	}
	*/


	// Iterative DFS O(n)
	/*
	public int maxDepth(TreeNode root){
		if(root == null) return 0;
		Stack<TreeNode> node_stack = new Stack<TreeNode>();
		Stack<Integer> height_stack = new Stack<Integer>();
		node_stack.add(root);
		height_stack.add(1);
		TreeNode curr;
		int max_height = Integer.MIN_VALUE, curr_height = 0;
		while(node_stack.size() != 0){
			curr = node_stack.pop();
			curr_height = height_stack.pop();
			max_height = Math.max(max_height, curr_height);
			if(curr.left != null){
				node_stack.add(curr.left);
				height_stack.add(curr_height+1);
			}
			if(curr.right != null){
				node_stack.add(curr.right);
				height_stack.add(curr_height+1);
			}
		}
		return max_height;
	}
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		hundredandfour objHundredandfour = new hundredandfour();
		TreeNode root = objHundredandfour.createTree(root_val, sc);
		int answer = objHundredandfour.maxDepth(root);
		System.out.println(answer);
		sc.close();
	}
}
