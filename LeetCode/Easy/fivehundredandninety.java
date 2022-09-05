package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*

https://leetcode.com/problems/n-ary-tree-postorder-traversal/

Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

 

Example 1:


Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
Example 2:


Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.
 

Follow up: Recursive solution is trivial, could you do it iteratively?

*/

public class fivehundredandninety {

	private List<Integer> postorder_list;

	private void iterativePostorderTraversal(Node node) {
		if(node == null) return;
		Stack<Node> postorder_stack = new Stack<Node>();
		HashSet<Node> visitedNodeSet = new HashSet<Node>();
		Node curr = node;
		postorder_stack.push(curr);
		int child;
		while(!postorder_stack.isEmpty()) {
			curr = postorder_stack.peek();
			if(visitedNodeSet.contains(curr)){
				this.postorder_list.add(curr.val);
				postorder_stack.pop();
			}else {
				visitedNodeSet.add(curr);
				for(child = curr.children.size()-1; child >=0; child--) {
					postorder_stack.push(curr.children.get(child));
				}
			}
		}
	}

	private void recursivePostorderTraversal(Node node){
		if(node == null) return;
		for(Node child: node.children) {
			recursivePostorderTraversal(child);
		}
		postorder_list.add(node.val);
	}

	public List<Integer> postorder(Node root) {
		this.postorder_list = new ArrayList<Integer>();
		this.recursivePostorderTraversal(root);
		this.iterativePostorderTraversal(root);
		return this.postorder_list;
	}

}