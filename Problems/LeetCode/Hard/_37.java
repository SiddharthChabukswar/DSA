package LeetCode.Hard;

/*

https://leetcode.com/problems/sudoku-solver/description/

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

 

Example 1:


Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:


 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
It is guaranteed that the input board has only one solution.
*/
public class _37 {

	private void initMatrixSets(final char[][] board, final boolean[][] matrixSets) {
		// System.out.println("initMatrixSets");
		for (int i=0; i<9; i++) {
			int row_start=(i/3)*3;
			int row_end=row_start+3;
			int col_start=(i%3)*3;
			int col_end=col_start+3;
			for (int j=row_start; j<row_end; j++) {
				for (int k=col_start; k<col_end; k++) {
					if (board[j][k] != '.') {
						// System.out.println(i+"_"+j+"_"+k);
						matrixSets[i][board[j][k]-'0'-1] = true;
					}
				}
			}
		}
	}

	private void initColSets(final char[][] board, final boolean[][] colSets) {
		// System.out.println("initColSets");
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (board[j][i] != '.') {
					// System.out.println(i+"_"+j);
					colSets[i][board[j][i]-'0'-1] = true;
				}
			}
		}
	}

	private void initRowSets(final char[][] board, final boolean[][] rowSets) {
		// System.out.println("initRowSets");
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (board[i][j] != '.') {
					// System.out.println(i+"_"+j);
					rowSets[i][board[i][j]-'0'-1] = true;
				}
			}
		}
	}

	private void initSets(final char[][] board, final boolean[][] rowSets, final boolean[][] colSets, final boolean[][] matrixSets) {
		initRowSets(board, rowSets);
		initColSets(board, colSets);
		initMatrixSets(board, matrixSets);
	}

	private void recursiveSudokuSolver(final char[][] board, final int index, final boolean[][] rowSets, final boolean[][] colSets, final boolean[][] matrixSets, final char[][] solvedBoard) {
		if (index == 81) {
			// System.out.println("Solved");
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					solvedBoard[i][j] = board[i][j];
				}
			}
			return;
		}
		final int row = index/9;
		final int col = index%9;
		if (board[row][col] != '.') {
			recursiveSudokuSolver(board, index+1, rowSets, colSets, matrixSets, solvedBoard);
		} else {
			int matrixIdx = 3*(row/3)+(col/3);
			for (int num=0; num<9; num++) {
				if (rowSets[row][num] == false 
					&& colSets[col][num] == false 
					&& matrixSets[matrixIdx][num] == false) {
					rowSets[row][num] = true;
					colSets[col][num] = true;
					matrixSets[matrixIdx][num] = true;
					board[row][col] = (char)(num+1+'0');
					recursiveSudokuSolver(board, index+1, rowSets, colSets, matrixSets, solvedBoard);
					board[row][col] = '.';
					rowSets[row][num] = false;
					colSets[col][num] = false;
					matrixSets[matrixIdx][num] = false;
				}
			}
		}
	}

	public void solveSudoku(char[][] board) {
		boolean[][] rowSets, colSets, matrixSets;
		rowSets = new boolean[9][9];
		colSets = new boolean[9][9];
		matrixSets = new boolean[9][9];
		
		initSets(board, rowSets, colSets, matrixSets);


		char[][] solvedBoard = new char[9][9];
		recursiveSudokuSolver(board, 0, rowSets, colSets, matrixSets, solvedBoard);
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				board[i][j] = solvedBoard[i][j];
				System.out.print(board[i][j]+" , ");
			}
			System.out.println();
		}
	}
	
}
