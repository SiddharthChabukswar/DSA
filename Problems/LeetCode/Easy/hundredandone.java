package LeetCode.Easy;

import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/symmetric-tree/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 

Follow up: Could you solve it both recursively and iteratively?

*/

// Defined in problem 94
// Definition for a binary tree node.

public class hundredandone {
	
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

	/*
	// Recursive solution check mirror image O(n)
	
	public boolean checkSubtree(TreeNode p1, TreeNode p2){
		if(p1 == null && p2 == null) return true;
		else if(p1 == null || p2 == null) return false;
		else if(p1.val != p2.val) return false;
		return (checkSubtree(p1.left, p2.right) && checkSubtree(p1.right, p2.left));
	}

	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return checkSubtree(root.left, root.right);
	}

	*/

	// Iterative approach using stack O(n)
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return false;
		TreeNode p = root.left, q = root.right;
		Stack<TreeNode> node_stack = new Stack<TreeNode>();
		while(node_stack.size() != 0 || p!=null || q!=null){
			while(p == null && q == null){
				// for(int i=0; i<node_stack.size(); i++) System.out.printf("%d ,", node_stack.elementAt(i).val);
				// System.out.println();
				if(node_stack.size() == 0) return true;
				q = node_stack.pop();
				p = node_stack.pop();
				p = p.right;
				q = q.left;
			}
			if(p == null || q==null) return false;
			else if(p.val != q.val) return false;
			node_stack.push(p);
			node_stack.push(q);
			p = p.left;
			q = q.right;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		hundredandone objHundredandone = new hundredandone();
		TreeNode root = objHundredandone.createTree(root_val, sc);
		boolean answer = objHundredandone.isSymmetric(root);
		System.out.println(answer);
		sc.close();
	}

}
