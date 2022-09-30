package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-in-a-rotated-array

Given a sorted and rotated array A of N distinct elements which is rotated at some point, and given an element key. The task is to find the index of the given element key in the array A.

Example 1:

Input:
N = 9
A[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}
key = 10
Output:
5
Explanation: 10 is found at index 5.
Example 2:

Input:
N = 4
A[] = {3, 5, 1, 2}
key = 6
Output:
-1
Explanation: There is no element that has value 6.
Your Task:
Complete the function search() which takes an array arr[] and start, end index of the array and the K as input parameters, and returns the answer.

Can you solve it in expected time complexity?

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 108
1 ≤ key ≤ 108

*/

public class Search_in_a_Rotated_Array {

	// Direct Binary Search O(logn)
	int search(int A[], int l, int h, int key) {
		int mid;
		while(l <= h) {
			mid = (l+h)/2;
			if(A[mid] == key) return mid;
			else if(A[mid] > key) {
				if(A[l] > key) {
					if(A[l] > A[mid]) h = mid-1;
					else l = mid+1;
				}
				else h = mid-1;
			} else {
			    if(A[l] > key) l = mid+1;
				else {
					if(A[l] > A[mid]) h = mid-1;
					else l = mid+1;
				}
			}
		}
		return -1;
	}

}