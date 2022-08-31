package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*

Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?

*/

// Defined in problem 94
// Definition for a binary tree node.

public class hundredandfourtyfour {

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
	public void preorder(TreeNode node, List<Integer> preorder_list){
		if(node == null) return;
		preorder_list.add(node.val);
		preorder(node.left, preorder_list);
		preorder(node.right, preorder_list);
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder_list = new ArrayList<Integer>();
		preorder(root, preorder_list);
		return preorder_list;
	}
	*/

	// Iterative approach O(n)

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder_list = new ArrayList<Integer>();
		Stack<TreeNode> node_stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!node_stack.isEmpty() || curr!=null){
			while(curr!=null){
				preorder_list.add(curr.val);
				node_stack.add(curr);
				curr = curr.left;
			}
			curr = node_stack.pop();
			curr = curr.right;
		}
		return preorder_list;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hundredandfourtyfour objHundredandfourtyfour = new hundredandfourtyfour();

		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		TreeNode root = objHundredandfourtyfour.createTree(root_val, sc);
		
		List<Integer> answer = objHundredandfourtyfour.preorderTraversal(root);
		System.out.println(answer);
		sc.close();
	}

}
