package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*

https://leetcode.com/problems/n-ary-tree-preorder-traversal/

Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000.
 

Follow up: Recursive solution is trivial, could you do it iteratively?

*/

public class fivehundredandeightynine {

	private List<Integer> preorder_list;

	private void recursivePreorderTraversal(Node node){
		if(node == null) return;
		this.preorder_list.add(node.val);
		for(Node child: node.children) {
			recursivePreorderTraversal(child);
		}
	}

	private void iterativePreorderTraversal(Node node){
		if(node == null) return;
		Node curr = node;
		Stack<Node> main_stack = new Stack<Node>();
		main_stack.push(curr);
		int child;
		while(!main_stack.isEmpty()) {
			curr = main_stack.pop();
			this.preorder_list.add(curr.val);
			for(child = curr.children.size()-1; child>=0; child--) main_stack.push(curr.children.get(child));
		}
	}
	
	public List<Integer> preorder(Node root) {
		this.preorder_list = new ArrayList<Integer>();
		this.recursivePreorderTraversal(root);
		this.iterativePreorderTraversal(root);
		return this.preorder_list;
	}
	
}
