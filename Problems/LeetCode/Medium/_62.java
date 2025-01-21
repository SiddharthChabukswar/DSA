package LeetCode.Medium;

import java.util.Scanner;

/*

https://leetcode.com/problems/unique-paths/description/

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100

*/

public class _62 {

	/*
	Combinatorix solution O(m+n)
	Total steps to reach from (0,0) to (m-1,n-1) is always m+n-2;
	total steps taken can be (m+n-2)C(m-1) or (m+n-2)C(n-1)
	*/
	public int uniquePaths(int m, int n) {
		long maxSteps = (long) (m+n-2);
		long minRep = (long) (Math.min(m, n)-1);
		long answer = 1l;
		for (long i=1; i<=minRep; i++) {
			answer = answer*(maxSteps-i+1l)/i;
		}
		return (int) answer;
	}

	/*
	DP recursion O(m*n)
	 */
	/*
	private int recursiveTraversal(int m, int n, int iIdx, int jIdx, int[][] pathsTraversed) {
		if (iIdx == m-1 && jIdx == n-1) return 1;
		if (iIdx >= m || jIdx >= n) return 0;
		if (pathsTraversed[iIdx][jIdx] > 0) return pathsTraversed[iIdx][jIdx];
		pathsTraversed[iIdx][jIdx] = recursiveTraversal(m, n, iIdx, jIdx+1, pathsTraversed) 
			+ recursiveTraversal(m, n, iIdx+1, jIdx, pathsTraversed);
		return pathsTraversed[iIdx][jIdx];
	}

	public int uniquePaths(int m, int n) {
		int[][] pathsTraversed = new int[m][n];
        return recursiveTraversal(m, n, 0, 0, pathsTraversed);
    }
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		m = sc.nextInt();
		n = sc.nextInt();
		_62 obj62 = new _62();
		System.out.println(obj62.uniquePaths(m, n));
		sc.close();
	}
	
}
