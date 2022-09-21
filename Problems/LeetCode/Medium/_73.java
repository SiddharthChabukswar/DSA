package LeetCode.Medium;

// import java.util.HashSet;

/*

https://leetcode.com/problems/set-matrix-zeroes/

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

public class _73 {

	// pilot row and column set to 0: O(1) space
	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		Boolean setRow = false, setCol = false;
		Integer i, j;
		if(matrix[0][0] == 0) {
			setRow = true;
			setCol = true;
		}
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					if(i!=0 && j!=0){
						matrix[i][0] = 0;
						matrix[0][j] = 0;
					}
					else if(i==0) {
						setRow = true;
					}
					else if(j==0) {
						setCol = true;
					}
				}
			}
		}
		/*
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		*/
		for(i=1; i<m; i++) for(j=1; j<n; j++) if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
		if(setRow) for(i=0; i<n; i++) matrix[0][i] = 0;
		if(setCol) for(i=0; i<m; i++) matrix[i][0] = 0;
	}

	// HashSet : O(m+n) space
	/*
	public void setZeroes(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		HashSet<Integer> idxSet = new HashSet<Integer>();
		HashSet<Integer> idySet = new HashSet<Integer>();
		Integer i, j;
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					idxSet.add(i);
					idySet.add(j);
				}
			}
		}
		for(Integer idx: idxSet) {
			for(i=0; i<n; i++) {
				matrix[idx][i] = 0;
			}
		}
		for(Integer idy: idySet) {
			for(i=0; i<m; i++) {
				matrix[i][idy] = 0;
			}
		}
	}
	*/
	
}
