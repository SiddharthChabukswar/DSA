package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/minimum-absolute-difference-in-bst/

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

 

Example 1:


Input: root = [4,2,6,1,3]
Output: 1
Example 2:


Input: root = [1,0,48,null,null,12,49]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105
 

Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

*/

class fivehundredandthirty {

	private List<Integer> inorderedList;

	private void inorderMinDiff(TreeNode node) {
		if(node == null) return;
		this.inorderMinDiff(node.left);
		this.inorderedList.add(node.val);
		this.inorderMinDiff(node.right);
	}

	public int getMinimumDifference(TreeNode root) {
		Integer answer = Integer.MAX_VALUE;
		this.inorderedList = new ArrayList<Integer>();
		this.inorderMinDiff(root);
		for(int i=1; i<this.inorderedList.size(); i++) {
			answer = Math.min(answer, Math.abs(this.inorderedList.get(i) - this.inorderedList.get(i-1)));
		}
		return answer;
	}

	public static void main(String[] args) {
		
	}
}