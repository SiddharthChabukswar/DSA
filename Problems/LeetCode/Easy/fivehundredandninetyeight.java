package LeetCode.Easy;

/*

https://leetcode.com/problems/range-addition-ii/

You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.

 

Example 1:


Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
Example 2:

Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
Example 3:

Input: m = 3, n = 3, ops = []
Output: 9
 

Constraints:

1 <= m, n <= 4 * 104
0 <= ops.length <= 104
ops[i].length == 2
1 <= ai <= m
1 <= bi <= n


*/

public class fivehundredandninetyeight {
	
	// Greedy O(len(ops))
	public int maxCount(int m, int n, int[][] ops) {
		if(ops.length == 0) return m*n;
		int min_ops_x = Integer.MAX_VALUE, min_ops_y = Integer.MAX_VALUE;
		for(int[] op: ops) {
			if(op[0] < min_ops_x) min_ops_x = op[0];
			if(op[1] < min_ops_y) min_ops_y = op[1];
		}
		return min_ops_x*min_ops_y;
	}

	// Brute Force O(m^n^ops) M.L.E.
	/*
	public int maxCount(int m, int n, int[][] ops) {
		if(ops.length == 0) return m*n;
		int answer = 0, x = 0, y = 0, max_element = 0;
		int[][] M = new int[m][n];
		for(int[] op: ops) {
			for(x=0; x<op[0]; x++) {
				for(y=0; y<op[1]; y++) {
					M[x][y]++;
					if(M[x][y] > max_element) max_element = M[x][y];
				}
			}
		}
		for(x=0; x<m; x++) {
			for(y=0; y<n; y++) {
				if(M[x][y] == max_element) answer++;		
			}
		}
		return answer;
	}
	*/
}
