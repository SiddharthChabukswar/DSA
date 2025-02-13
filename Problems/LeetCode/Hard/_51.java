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

	/*
	private boolean isSafePosition(final int n, final int row, final int col, final char[][] queenPositions) {
		// flip threat positions for column
		for (int i=row; i>=0; i--) {
			if (queenPositions[i][col] != '.') return false;
		}
		// flip threat positions for fwd diagonal
		for (int i=1; i<=row && i<n-col; i++) {
			if (queenPositions[row-i][col+i] != '.') return false;
		}
		// flip threat positions for bwd diagonal
		for (int i=1; i<=row && i<=col; i++) {
			if (queenPositions[row-i][col-i] != '.') return false;
		}
		return true;
	}

	/*
	Recursion with backtracking O(N!*N^2)
	*/
	/*
	private void placeQueenAtIndexRow(final int n, final int row, final List<List<String>> positionLists, final char[][] queenPositions) {
		if (n == row) {
			positionLists.add(generatePositionString(n, queenPositions));
			return;
		}
		for (int col=0; col<n; col++) {
			if (isSafePosition(n, row, col, queenPositions)) {
				queenPositions[row][col] = 'Q';
				// System.out.println(row+"_"+col+);
				// for (int i=0;i<n;i++){
				// 	for (int j=0;j<n;j++) System.out.print(queenPositions[i][j]+" ");
				// 	System.out.println();
				// }
				placeQueenAtIndexRow(n, row+1, positionLists, queenPositions);
				queenPositions[row][col] = '.';
			}
		}
	}
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> positionLists = new ArrayList<>();
		char[][] queenPositions = new char[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				queenPositions[i][j] = '.';
			}
		}
		placeQueenAtIndexRow(n, 0, positionLists, queenPositions);
		return positionLists;
	}
	*/

	private List<String> generatePositionString(final int n, final char[][] queenPositions) {
		List<String> positionsStringList = new ArrayList<>();
		StringBuilder stringBuilder;
		for (int i=0; i<n; i++) {
			stringBuilder = new StringBuilder();
			for (int j=0; j<n; j++) {
				stringBuilder.append(queenPositions[i][j]);
			}
			positionsStringList.add(stringBuilder.toString());
		}
		return positionsStringList;
	}

	private void placeQueenAtIndexRow(final int n, final int row, final List<List<String>> positionLists, final boolean[] column, final boolean[] fwdDiagonal, final boolean[] bwdDiagonal, final char[][] queenPositions) {
		if (n == row) {
			positionLists.add(generatePositionString(n, queenPositions));
			return;
		}
		for (int col=0; col<n; col++) {
			if (column[col] == false && fwdDiagonal[row+col] == false && bwdDiagonal[n-1+row-col] == false) {
				queenPositions[row][col] = 'Q';
				column[col] = true;
				fwdDiagonal[row+col] = true;
				bwdDiagonal[n-1+row-col] = true;
				placeQueenAtIndexRow(n, row+1, positionLists, column, fwdDiagonal, bwdDiagonal, queenPositions);
				column[col] = false;
				fwdDiagonal[row+col] = false;
				bwdDiagonal[n-1+row-col] = false;
				queenPositions[row][col] = '.';
			}
		}
	}
	
	/*
	Better solution avoiding iterative safe checks O(N!)
	*/
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> positionLists = new ArrayList<>();
		boolean[] column, fwdDiagonal, bwdDiagonal;
		column = new boolean[n];
		fwdDiagonal = new boolean[2*n-1];
		bwdDiagonal = new boolean[2*n-1];
		char[][] queenPositions = new char[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				queenPositions[i][j] = '.';
			}
		}
		placeQueenAtIndexRow(n, 0, positionLists, column, fwdDiagonal, bwdDiagonal, queenPositions);
		return positionLists;
	}
}
