package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/spiral-matrix/

Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/

public class _54 {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiralOrderList = new ArrayList<Integer>();
		int m = matrix.length, n = matrix[0].length;
		int left_bound = 0, right_bound = n-1, top_bound = 0, bott_bound = m-1, i = 0;
		while(left_bound <= right_bound && top_bound <= bott_bound) {
			// System.out.println(left_bound + " " + right_bound);
			for(i=left_bound; i<=right_bound; i++) {
				// System.out.print(i + " ");
				spiralOrderList.add(matrix[top_bound][i]);
			}
			if(top_bound == bott_bound) break;
			for(i=top_bound+1; i<=bott_bound; i++) {
				// System.out.print(i + " ");
				spiralOrderList.add(matrix[i][right_bound]);
			}
			for(i=right_bound-1; i>=left_bound; i--) {
				// System.out.print(i + " ");
				spiralOrderList.add(matrix[bott_bound][i]);
			}
			if(left_bound == right_bound) break;
			for(i=bott_bound-1; i>top_bound; i--) {
				// System.out.print(i + " ");
				spiralOrderList.add(matrix[i][left_bound]);
			}
			// System.out.println();
			left_bound++;
			right_bound--;
			top_bound++;
			bott_bound--;
		}
		return spiralOrderList;
	}
	
}
