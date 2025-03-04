package LeetCode.Medium;

/*

https://leetcode.com/problems/rotate-image/

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000



[[5,1,9,11]
 [2,4,8,10]
 [13,3,6,7] 
 [15,14,12,16]]

[[15,13,2,5] 
 [14,4,4,1]
 [12,8,6,9]
 [16,7,10,11]]

[[15,13,2,5]
 [14,3,4,1]
 [12,6,8,9]
 [16,7,10,11]]

*/

public class _48 {
	
	/*
	 * Swap spirally O(n^2)
	 */
	/*
	public void rotate(int[][] matrix) {
		int i, j, temp, temp2, n = matrix.length, max_j, max_i;
		for(i=0; i<n/2; i++) {
			max_j = n-i-1;
			for(j=i; j<max_j; j++) {
				max_i = n-j-1;
				temp = matrix[j][max_j];
				matrix[j][max_j] = matrix[i][j];
				temp2 = matrix[max_j][max_i];
				matrix[max_j][max_i] = temp;
				temp = matrix[max_i][i];
				matrix[max_i][i] = temp2;
				matrix[i][j] = temp;
			}
		}
	}
	*/

	private void transpose(int[][] matrix) {
		int n = matrix.length;
		int temp;
		for (int row=0; row<n; row++) {
			for(int col=0; col<row; col++) {
				temp  = matrix[row][col];
				matrix[row][col] = matrix[col][row];
				matrix[col][row] = temp;
			}
		}
	}

	private void swapColumns(int[][] matrix) {
		int n = matrix.length;
		int temp;
		for (int col=0; col<n/2; col++) {
			for (int row=0; row<n; row++) {
				temp = matrix[row][col];
				matrix[row][col] = matrix[row][n-col-1];
				matrix[row][n-col-1] = temp;
			}
		}
	}

	/*
	 * Transpose and swap columns O(n^2)
	 */
	public void rotate(int[][] matrix) {
		transpose(matrix);
		swapColumns(matrix);
	}
}
