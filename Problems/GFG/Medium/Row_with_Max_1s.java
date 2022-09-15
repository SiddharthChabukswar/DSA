package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s

Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:

Input: 
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:

Input: 
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rowWithMax1s() which takes the array of booleans arr[][], n and m as input parameters and returns the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.
 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N, M ≤ 103
0 ≤ Arr[i][j] ≤ 1 

*/

public class Row_with_Max_1s {
	
	int rowWithMax1s(int arr[][], int n, int m) {
		int max_row_index = -1, min_index = m, i;
		int left, right, mid;
		for(i=0; i<n; i++) {
			left = 0;
			right = min_index-1;
			if(arr[i][right] == 0) continue;
			while(right >= left) {
				mid = (left+right)/2;
				if(arr[i][mid] == 1) right = mid-1;
				else left = mid+1;
			}
			if(min_index > left) {
				min_index = left;
				max_row_index = i;
			}
			if(min_index == 0) return i;
		}
		return max_row_index;
	}
}
