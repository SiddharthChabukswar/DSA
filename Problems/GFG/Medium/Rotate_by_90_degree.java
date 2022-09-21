package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotate-by-90-degree

Given a square matrix of size N x N. The task is to rotate it by 90 degrees in anti-clockwise direction without using any extra space. 

Example 1:

Input:
N = 3 
matrix[][] = {{1, 2, 3},
              {4, 5, 6}
              {7, 8, 9}}
Output: 
Rotated Matrix:
3 6 9
2 5 8
1 4 7
Example 2:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 
Rotated Matrix:
2 4
1 3

Your Task:
You dont need to read input or print anything. Complete the function rotateby90() which takes the matrix as input parameter and rotates it by 90 degrees in anti-clockwise direction without using any extra space. You have to modify the input matrix in-place. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 100
1 <= matrix[][] <= 1000

1 2 3 4 5 6 7 8 9

1 2 3
4 5 6
7 8 9

3
1 2 9 
4 5 6 
1 8 7 

6
1 2 9 
2 5 8 
1 4 7 

*/

public class Rotate_by_90_degree {

	static void rotateby90(int matrix[][], int n) {
		int i, j, max_i = n/2, max_j, temp, temp2;
		for(i=0; i<n/2; i++) {
			max_j = n-i-1;
			for(j=i; j<max_j; j++) {
				max_i = n-j-1;
				temp = matrix[max_i][i];
				matrix[max_i][i] = matrix[i][j];
				temp2 = matrix[max_j][max_i];
				matrix[max_j][max_i] = temp;
				temp = matrix[j][max_j];
				matrix[j][max_j] = temp2;
				matrix[i][j] = temp;
			}
		}
	}

}