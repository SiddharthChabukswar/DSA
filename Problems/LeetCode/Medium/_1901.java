package LeetCode.Medium;

/*

https://leetcode.com/problems/find-a-peak-element-ii/

A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

 

Example 1:



Input: mat = [[1,4],[3,2]]
Output: [0,1]
Explanation: Both 3 and 4 are peak elements so [1,0] and [0,1] are both acceptable answers.
Example 2:



Input: mat = [[10,20,15],[21,30,14],[7,16,32]]
Output: [1,1]
Explanation: Both 30 and 32 are peak elements so [1,1] and [2,2] are both acceptable answers.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal.


*/

public class _1901 {

	public int[] findPeakGrid(int[][] mat) {
		int m = mat.length, n = mat[0].length, low = 0, high = n-1, mid, global_max, global_max_row, i;
		int le, re;
		while(low <= high) {
			mid = (low+high)/2;
			global_max_row = -1;
			global_max = -1;
			for(i=0; i<m; i++) {
				if(mat[i][mid] > global_max) {
					global_max = mat[i][mid];
					global_max_row = i;
				}
			}
			le = (mid == 0)?-1:mat[global_max_row][mid-1];
			re = (mid == n-1)?-1:mat[global_max_row][mid+1];
			// System.out.println(le + " " + global_max + " " + re);
			if(global_max > le && global_max > re) return new int[]{global_max_row, mid};
			else if(global_max > re) high=mid-1;
			else low = mid+1;
		}
		return new int[]{-1, -1};
	}

}