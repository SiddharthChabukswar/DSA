package LeetCode.Easy;

// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*

https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.


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


public class twohundredandthirtyfive {
	
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

	public TreeNode findNode(TreeNode root, int val){
		if(root == null || root.val == val) return root;
		TreeNode answer = findNode(root.left, val);
		if(answer == null) answer = findNode(root.right, val);
		return answer;
	}

	public String getString(List<TreeNode> new_list){
		String answer = "";
		for(TreeNode curr: new_list){
			answer = answer + (char)(curr.val + '0') + ", ";
			System.out.println(curr.val);
		}
		return answer;
	}

	// Solution for Binary tree : Iterative DFS solution O(n) 
	/*
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		TreeNode curr = root;
		Boolean p_visited = false, q_visited = false;
		Stack<TreeNode> node_stack = new Stack<TreeNode>();
		HashMap<TreeNode, List<TreeNode>> node_path = new HashMap<TreeNode, List<TreeNode>>();
		List<TreeNode> temp = new ArrayList<TreeNode>();
		List<TreeNode> new_list;
		while(!node_stack.isEmpty() || curr!=null){
			while(curr!=null){
				node_stack.add(curr);
				new_list = new ArrayList<TreeNode>(temp);
				temp = new_list;
				new_list.add(curr);
				node_path.put(curr, new_list);
				if(p_visited == false && curr == p) p_visited = true;
				if(q_visited == false && curr == q)	q_visited = true;
				// System.out.printf("curr: %d:  || list: %s\n", curr.val, getString(new_list));
				curr = curr.left;
			}
			curr = node_stack.pop();
			temp = node_path.get(curr);
			curr = curr.right;
			// if(curr == null) path_stack.pop();
			if(p_visited == true && q_visited == true) break;
		}

		// temp = node_path.get(p);
		// System.out.print("\nNode path for p: ");
		// for(TreeNode i: temp){
		// 	System.out.printf("%d, ", i.val);
		// }

		// temp = node_path.get(q);
		// System.out.print("\nNode path for q: ");
		// for(TreeNode i: temp){
		// 	System.out.printf("%d, ", i.val);
		// }

		temp = node_path.get(p);
		new_list = node_path.get(q);
		int i = 0;
		for(i=0; i<Math.min(temp.size(), new_list.size()); i++){
			if(temp.get(i).val != new_list.get(i).val) break;
		}

		return temp.get(i-1);
	}
	*/


	// Solution for Binary Search Tree: Recursive O(n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return root;
		if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
		if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
		return root;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		twohundredandthirtyfive objTwohundredandthirtyfive = new twohundredandthirtyfive();
		TreeNode root = objTwohundredandthirtyfive.createTree(root_val, sc);
		System.out.print("Enter value of p: ");
		int p_val = sc.nextInt();
		TreeNode p = objTwohundredandthirtyfive.findNode(root, p_val);
		System.out.print("Enter value of q: ");
		int q_val = sc.nextInt();
		TreeNode q = objTwohundredandthirtyfive.findNode(root, q_val);
		TreeNode answer = objTwohundredandthirtyfive.lowestCommonAncestor(root, p, q);
		System.out.print("\nLCA: ");
		System.out.println(answer.val);
		sc.close();
	}
	
}
