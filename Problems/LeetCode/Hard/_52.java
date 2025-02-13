package LeetCode.Hard;

/*

https://leetcode.com/problems/n-queens-ii/description/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9

*/
public class _52 {

	private int placeQueenAtIndexRow(final int n, final int row, final boolean[] column, final boolean[] fwdDiagonal, final boolean[] bwdDiagonal) {
		if (n == row) {
			return 1;
		}
		int count = 0;
		for (int col=0; col<n; col++) {
			if (column[col] == false && fwdDiagonal[row+col] == false && bwdDiagonal[n-1+row-col] == false) {
				column[col] = true;
				fwdDiagonal[row+col] = true;
				bwdDiagonal[n-1+row-col] = true;
				count += placeQueenAtIndexRow(n, row+1, column, fwdDiagonal, bwdDiagonal);
				column[col] = false;
				fwdDiagonal[row+col] = false;
				bwdDiagonal[n-1+row-col] = false;
			}
		}
		return count;
	}
	
	/*
	Better solution avoiding iterative safe checks O(N!)
	*/
	public int totalNQueens(int n) {
		boolean[] column, fwdDiagonal, bwdDiagonal;
		column = new boolean[n];
		fwdDiagonal = new boolean[2*n-1];
		bwdDiagonal = new boolean[2*n-1];
		return placeQueenAtIndexRow(n, 0, column, fwdDiagonal, bwdDiagonal);
	}
}
