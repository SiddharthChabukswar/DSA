package LeetCode.Easy;

// import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
// import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


/*

https://leetcode.com/problems/binary-tree-paths/

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100

*/

public class twohundredandfiftyseven {
	
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

	// BFS O(n)
	/*
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return null;
		List<String> answer = new ArrayList<String>();
		Queue<TreeNode> node_queue = new LinkedList<TreeNode>();
		Queue<String> string_queue = new LinkedList<String>();
		TreeNode curr = root;
		String curr_string = String.valueOf(curr.val);
		String new_string = "";
		int qlen = 0;
		node_queue.offer(curr);
		string_queue.offer(curr_string);
		while(!node_queue.isEmpty()){
			qlen = node_queue.size();
			while(qlen!=0){
				curr = node_queue.poll();
				curr_string = string_queue.poll();
				if(curr.left == null && curr.right == null){
					answer.add(curr_string);
				}
				if(curr.left != null){
					new_string = curr_string + "->" + String.valueOf(curr.left.val);
					node_queue.offer(curr.left);
					string_queue.offer(new_string);
				}
				if(curr.right != null){
					new_string = curr_string + "->" + String.valueOf(curr.right.val);
					node_queue.offer(curr.right);
					string_queue.offer(new_string);
				}
				qlen--;
			}
		}
		return answer;
	}
	*/

	// DFS recursive O(n)
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) return null;
		List<String> answer = new LinkedList<String>();
		dfsTraversal(root, "", answer);
		return answer;
	}

	public void dfsTraversal(TreeNode root, String current, List<String> answer){
		if(root == null) return;
		if(current != "") current = current + "->";
		current = current + String.valueOf(root.val);
		if(root.left == null && root.right == null){
			answer.add(current);
		}
		dfsTraversal(root.left, current, answer);
		dfsTraversal(root.right, current, answer);
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter root: ");
		int root_val = sc.nextInt();
		twohundredandfiftyseven objTwohundredandfiftyseven = new twohundredandfiftyseven();
		TreeNode root = objTwohundredandfiftyseven.createTree(root_val, sc);
		List<String> answer = objTwohundredandfiftyseven.binaryTreePaths(root);
		for(String ans: answer){
			System.out.println(ans);
		}
		sc.close();
	}
}
