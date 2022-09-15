package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-a-matrix

Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.


Example 1:

Input:
N = 3, M = 3
mat[][] = 3 30 38 
         44 52 54 
         57 60 69
X = 62
Output:
0
Explanation:
62 is not present in the
matrix, so output is 0

Example 2:

Input:
N = 1, M = 6
mat[][] = 18 21 27 38 55 67
X = 55
Output:
1
Explanation:
55 is present in the
matrix at 5th cell.

Your Task:
You don't need to read input or print anything. You just have to complete the function matSearch() which takes a 2D matrix mat[][], its dimensions N and M and integer X as inputs and returns 1 if the element X is present in the matrix and 0 otherwise.


Expected Time Complexity: O(N+M).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N, M <= 1005
1 <= mat[][] <= 10000000
1<= X <= 10000000

*/

public class Search_In_a_Matrix {

	public static int matSearch(int mat[][], int N, int M, int X) {
		int i=0, j=M-1;
		while(i<N && j>=0) {
			if(mat[i][j] == X) return 1;
			else if(mat[i][j] > X) j--;
			else i++;
		}
		return 0;
	}

	// Binary Search on row (N*log(M)) - ACC
	/*
	public static boolean binSearchArray(int[] arr, int target) {
		int left = 0, right = arr.length-1, mid = -1;
		while(right >= left) {
			mid = (left+right)/2;
			if(arr[mid] == target) return true;
			else if(arr[mid] > target) right = mid-1;
			else left = mid+1;
		}
		return false;
	}

	public static int matSearch(int mat[][], int N, int M, int X) {
		int i=0;
		while(i<N){
			if(mat[i][M-1] >= X) {
				if(binSearchArray(mat[i], X)) return 1;
			}
			i++;
		}
		return 0;
	}
	*/
}
