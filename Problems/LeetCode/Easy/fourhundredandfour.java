package LeetCode.Easy;

// import java.util.LinkedList;
// import java.util.Queue;

/*

https://leetcode.com/problems/sum-of-left-leaves/

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-1000 <= Node.val <= 1000

*/

public class fourhundredandfour {

	int calculateLeftSum(TreeNode curr, Boolean isleft){
		if(curr == null) return 0;
		if(curr.left == null && curr.right == null){
			if(isleft) return curr.val;
			else return 0;
		}
		return calculateLeftSum(curr.left, true) + calculateLeftSum(curr.right, false);
	}

	// DFS O(n)
	public int sumOfLeftLeaves(TreeNode root) {
		return calculateLeftSum(root, false);
	}

	// BFS O(n)
	/*
	public int sumOfLeftLeaves(TreeNode root) {
		int answer = 0;
		if(root == null) return answer;
		TreeNode curr = root;
		Boolean is_left = false;
		int level_size = 0;
		Queue<TreeNode> node_queue = new LinkedList<TreeNode>();
		Queue<Boolean> left_queue = new LinkedList<Boolean>();
		node_queue.offer(curr);
		left_queue.offer(false);
		while(!node_queue.isEmpty()){
			level_size = node_queue.size();
			while(level_size!=0){
				curr = node_queue.poll();
				is_left = left_queue.poll();
				if(curr.left!=null){
					node_queue.offer(curr.left);
					left_queue.offer(true);
				}
				if(curr.right!=null){
					node_queue.offer(curr.right);
					left_queue.offer(false);
				}
				if(curr.left==null && curr.right==null && is_left==true) answer+=curr.val;
				level_size--;
			}
		}
		return answer;
	}
	*/

}
