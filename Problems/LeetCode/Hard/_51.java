package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/n-queens/description/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 

Example 1:


Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9

*/
public class _51 {

	private void flipThreatPosition(final int[][] threatPositions, final int row, final int col, final int n, final int operation) {
		// flip threat positions for column
		for (int i=row; i<n; i++) {
			threatPositions[i][col] += operation;
		}
		// flip threat positions for fwd diagonal
		for (int i=1; i<n-row && i<=col; i++) {
			threatPositions[row+i][col-i] += operation;
		}
		// flip threat positions for bwd diagonal
		for (int i=1; i<n-row && i<n-col; i++) {
			threatPositions[row+i][col+i] += operation;
		}
	}

	private String generatePositionString(final int n, final int col) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i<n; i++) stringBuilder.append('.');
		stringBuilder.setCharAt(col, 'Q');
		return stringBuilder.toString();
	}

	/*
	Recursion with backtracking O(N!*N^2)
	*/
	private void placeQueenAtIndexRow(final int n, final int row, final List<String> currPositions, final List<List<String>> positionLists, final int[][] threatPositions) {
		if (n == row) {
			positionLists.add(new ArrayList<>(currPositions));
			return;
		}
		for (int col=0; col<n; col++) {
			if (threatPositions[row][col] == 0) {
				flipThreatPosition(threatPositions, row, col, n, 1);
				currPositions.add(generatePositionString(n, col));
				// System.out.println(row+"_"+col+"_"+currPositions);
				// for (int i=0;i<n;i++){
				// 	for (int j=0;j<n;j++) System.out.print(threatPositions[i][j]+"_");
				// 	System.out.println();
				// }
				placeQueenAtIndexRow(n, row+1, currPositions, positionLists, threatPositions);
				currPositions.remove(currPositions.size()-1);
				flipThreatPosition(threatPositions, row, col, n, -1);
			}
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> positionLists = new ArrayList<>();
		int[][] threatPositions = new int[n][n];
		placeQueenAtIndexRow(n, 0, new ArrayList<>(), positionLists, threatPositions);
		return positionLists;
	}
	
}
