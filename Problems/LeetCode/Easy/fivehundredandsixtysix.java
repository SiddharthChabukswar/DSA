package LeetCode.Easy;

/*

https://leetcode.com/problems/reshape-the-matrix/

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

 

Example 1:


Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]
Example 2:


Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300

*/

public class fivehundredandsixtysix {

	public int[][] matrixReshape(int[][] mat, int r, int c) {
		if((mat.length * mat[0].length) != (r*c)) return mat;
		int[][] reshaped_mat = new int[r][c];
		int rows = mat.length;
		int cols = mat[0].length;
		int reshaped_row = 0;
		int reshaped_col = 0;
		for(int row = 0; row<rows; row++) {
			for(int col = 0; col<cols; col++) {
				if(reshaped_col == c) {
					reshaped_row++;
					reshaped_col = 0;
				}
				reshaped_mat[reshaped_row][reshaped_col++] = mat[row][col];
			}
		}
		return reshaped_mat;
	}
}
