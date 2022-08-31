package LeetCode.Easy;

import java.util.LinkedList;
import java.util.Queue;

/*

https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Example 1:



Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:



Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5
 

Constraints:

The total number of nodes is in the range [0, 104].
The depth of the n-ary tree is less than or equal to 1000.

*/

public class fivehundredandfiftynine {

	// B.F.S Approach
	private int breadthFirstSearch(Node node) {
		if(node == null) return 0;
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(node);
		int depth = 0, curr_queue_size = 0;
		Node curr_node;
		while(nodeQueue.isEmpty() == false) {
			depth++;
			curr_queue_size = nodeQueue.size();
			while(curr_queue_size-- != 0) {
				curr_node = nodeQueue.poll();
				for(Node child: curr_node.children) {
					nodeQueue.offer(child);
				}
			}
		}
		return depth;
	}

	// D.F.S Approach
	private int depthFirstSearch(Node node) {
		if(node == null) return 0;
		if(node.children.size() == 0) return 1;
		int max_depth = Integer.MIN_VALUE;
		for(Node child: node.children) {
			max_depth = Math.max(max_depth, depthFirstSearch(child));
		}
		return max_depth + 1;
	}
	
	public int maxDepth(Node root) {
		this.breadthFirstSearch(root);
		return this.depthFirstSearch(root);
	}

}
