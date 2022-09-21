package GFG.Easy;

import java.util.ArrayList;
import java.util.List;

/*

https://practice.geeksforgeeks.org/problems/make-zeroes4042/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=make-zeroes

Given a matrix of  size n x m. Your task is to make Zeroes, that means in whole matrix when you find a zero, convert its upper, lower, left, and right value to zero and make that element the sum of the upper, lower, left and right value. Do the following tasks according to the initial matrix.
 

Example 1:

Input: matrix = {{1, 2, 3, 4},
                 {5, 6, 0, 7}, 
                 {8, 9, 4, 6},
                 {8, 4, 5, 2}}
Output: {{1, 2, 0, 4}, 
         {5, 0, 20, 0},
         {8, 9, 0, 6}, 
         {8, 4, 5, 2}}
Explanation: As matrix[1][2] = 0, we will
perform the operation here. Then matrix[1][2]
= matrix[0][2] + matrix[2][2] + matrix[1][1] 
+ matrix[1][3] and matrix[0][2] = matrix[2][2] 
= matrix[1][1] = matrix[1][3] = 0.
Example 2:

Input: matrix = {{1, 2}, 
                 {3, 4}}
output: {{1, 2}, 
         {3, 4}}

Your Task:
You don't need to read or print anything. Your task is to complete the function MakeZeros() which takes the matrix as input parameter and does the given task according to initial matrix. You don't need to return anything. The driver code prints the modified matrix itself in the output.
 

Expected Time Complexity: O(n * m)
Expected Space Complexity: O(n * m)
 

Constraints:
1 ≤ n, m ≤ 100
0 ≤ matrix[i][j] ≤ 100, where 0 ≤ i ≤ n and 0 ≤ j ≤ m

*/

class IndexPair {
	int idx;
	int idy;
	int val;
	IndexPair(int idx, int idy, int val) {
		this.idx = idx;
		this.idy = idy;
		this.val = val;
	}
}

public class Make_Zeroes {

	public void MakeZeros(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		List<IndexPair> zeroValuePairs = new ArrayList<IndexPair>();
		IndexPair indexPair;
		Integer val, i, j;
		for(i=0; i<m; i++) {
			for(j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					val = 0;
					if(i!=0) {
						val += matrix[i-1][j];
					}
					if(i!=m-1) {
						val += matrix[i+1][j];
					}
					if(j!=0) {
						val += matrix[i][j-1];
					}
					if(j!=n-1) {
						val += matrix[i][j+1];
					}
					indexPair = new IndexPair(i, j, val);
					zeroValuePairs.add(indexPair);
				}
			}
		}
		for(IndexPair pair: zeroValuePairs) {
			i = pair.idx;
			j = pair.idy;
			val = pair.val;
			if(i!=0) {
				matrix[i-1][j] = 0;
			}
			if(i!=m-1) {
				matrix[i+1][j] = 0;
			}
			if(j!=0) {
				matrix[i][j-1] = 0;
			}
			if(j!=n-1) {
				matrix[i][j+1] = 0;
			}
			matrix[i][j] = val;
		}
	}

}