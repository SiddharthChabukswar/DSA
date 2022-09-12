package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/quick-left-rotation3806/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=quick-left-rotation

Given an array arr[] of size N and an integer K, the task is to left rotate the array K indexes

Example 1:

Input: N = 7, K = 2
arr[] = {1, 2, 3, 4, 5, 6, 7}
Output: 3 4 5 6 7 1 2
Explanation: Rotation of the above 
array by 2 will make the output array .

Example 2:

Input: N = 6, K = 12
arr[] = {1, 2, 3, 4, 5, 6}
Output: 1 2 3 4 5 6

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function leftRotate() that takes array arr, integer K and integer N as parameters and rotate the given array by d value.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 105

Dry-run:
K=2, N=7
I/p:{1, 2, 3, 4, 5, 6, 7}
Exp o/p:{3, 4, 5, 6, 7, 1, 2}
for(0->N-(K%N))
*/

public class Quick_Left_Rotation {

	void leftRotate(long arr[], int k,int n) {
		if(k%n == 0) return;
		// long temp;
		
	}
	
}
