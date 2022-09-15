package LeetCode.Medium;

/*

https://leetcode.com/problems/search-a-2d-matrix/

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

*/

public class _74 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int m, n;
		m = matrix.length;
		n = matrix[0].length;
		int left = 0, right = m-1, mid = -1, curr_ele;
		while(right >= left) {
			mid = (left+right)/2;
			curr_ele = matrix[mid][n-1];
			if(curr_ele == target) return true;
			else if(curr_ele > target) {
				if(mid == 0 || matrix[mid-1][n-1] < target) break;
				else right = mid-1;
			} else {
				left = mid+1;
			}
		}
		if(left > right) return false;
		int row = mid;
		left = 0;
		right = n-1;
		mid = -1;
		while(right >= left) {
			mid = (left+right)/2;
			curr_ele = matrix[row][mid];
			if(curr_ele == target) return true;
			else if(curr_ele > target) right = mid-1;
			else left = mid+1;
		}
		return false;
	}
	
}
