package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/cd61add036272faa69c6814e34aa7007d5a25aa6/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=spiral_matrix

Given a matrix of size N x M. You have to find the Kth element which will obtain while traversing the matrix spirally starting from the top-left corner of the matrix.

Example 1:

Input: 
N = 3, M = 3, K = 4
A[] = {{1, 2, 3}, 
       {4, 5, 6}, 
       {7, 8, 9}}
Output: 
6
Explanation: Spiral traversal of matrix: 
{1, 2, 3, 6, 9, 8, 7, 4, 5}. Fourth element
is 6.
Example 2:

Input: 
N = 2, M = 2, K = 2 
A[] = {{1, 2},
       {3, 4}} 
Output: 
2
Explanation: Spiral traversal of matrix: 
{1, 2, 4, 3}. Second element is 2.
Your Task:  
You don't need to read input or print anything. Complete the function findK() which takes the matrix A[ ][ ], number of rows N, number of columns M, and integer K as input parameters and returns the Kth element in the spiral traversal of the matrix.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ K ≤ N*M ≤ 106

*/

public class Spiral_Matrix {

	public int findK(int a[][], int n, int m, int k) {
		int left_bound = 0, upper_bound = 0, right_bound = m-1, i;
		while(left_bound <= right_bound) {
			for(i=left_bound; i<=right_bound; i++) {
				// System.out.print(a[upper_bound][i] + " ");
				if(--k == 0) return a[upper_bound][i];
			}
			for(i=upper_bound+1; i<n-upper_bound; i++) {
				// System.out.print(a[i][right_bound] + " ");
				if(--k == 0) return a[i][right_bound];
			}
			for(i=right_bound-1; i>=left_bound; i--) {
				// System.out.print(a[n-upper_bound-1][i] + " ");
				if(--k == 0) return a[n-upper_bound-1][i];
			}
			for(i=n-upper_bound-2; i>upper_bound; i--) {
				// System.out.print(a[i][left_bound] + " ");
				if(--k == 0) return a[i][left_bound];
			}
			left_bound++;
			right_bound--;
			upper_bound++;
		}
		return 0;
	}

	
}