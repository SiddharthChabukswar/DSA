package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/minimum-depth-of-binary-tree/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
 

Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000

*/

public class hundredandeleven {
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


	// BFS Optimal Solution O(n) return on first occurance of a leaf node
	
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		int height = 1, curr_queue_length = 0, i = 0;
		Queue<TreeNode> node_queue = new LinkedList<TreeNode>();
		TreeNode curr = null;
		node_queue.offer(root);
		while(!node_queue.isEmpty()){
			curr_queue_length = node_queue.size();
			for(i=0; i<curr_queue_length; i++){
				curr = node_queue.poll();
				if(curr.left == null && curr.right == null) return height;
				if(curr.left != null) node_queue.offer(curr.left);
				if(curr.right != null) node_queue.offer(curr.right);
			}
			height++;
		}
		return height;
	}

	// Recursive DFS Solution O(n) return minimum of left subtree and right subtree
	/*
	public int minDepth(TreeNode root){
		if(root == null) return 0;
		int lheight = minDepth(root.left);
		int rheight = minDepth(root.right);
		if(lheight == 0 || rheight == 0) return 1 + Math.max(lheight, rheight);
		return 1+Math.min(lheight, rheight);
	}
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		hundredandeleven objHundredandeleven = new hundredandeleven();
		TreeNode root = objHundredandeleven.createTree(root_val, sc);
		int answer = objHundredandeleven.minDepth(root);
		System.out.println(answer);
		sc.close();
	}

}
