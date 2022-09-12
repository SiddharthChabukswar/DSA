package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array

Given an array A[] of size n. The task is to find the largest element in it.
 

Example 1:

Input:
n = 5
A[] = {1, 8, 7, 56, 90}
Output:
90
Explanation:
The largest element of given array is 90.
 

Example 2:

Input:
n = 7
A[] = {1, 2, 0, 3, 2, 4, 5}
Output:
5
Explanation:
The largest element of given array is 5.
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function largest() which takes the array A[] and its size n as inputs and returns the maximum element in the array.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= n<= 103
0 <= A[i] <= 103
Array may contain duplicate elements. 



*/

public class Largest_Element_In_Array {
	
	public int largest(int arr[], int n) {
		int max = Integer.MIN_VALUE;
		for(int a: arr) max = Math.max(max, a);
		return max;
	}

}
