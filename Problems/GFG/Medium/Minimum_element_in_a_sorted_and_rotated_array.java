package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-element-in-a-sorted-and-rotated-array

A sorted(in ascending order) array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

Example 1

Input:
N = 5
arr[] = {4 ,5 ,1 ,2 ,3}
Output: 1
Explanation: 1 is the minimum element inthe array.
Example 2

Input:
N = 7
arr[] = {10, 20, 30, 40, 50, 5, 7}
Output: 5
Explanation: Here 5 is the minimum element.
 

Your Task:
Complete the function findMin() which takes an array arr[] and n, size of the array as input parameters, and returns the minimum element of the array.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(log N).

Constraints:
1 ≤ N ≤ 100000
1 ≤ A[i] ≤ 1000000

*/

public class Minimum_element_in_a_sorted_and_rotated_array {

	int findMin(int arr[], int n) {
		int low = 0, high = n-1, mid;
		while(low <= high) {
			mid = (low+high)/2;
			if(arr[mid] >= arr[low] && arr[mid] <= arr[high]) return arr[low];
			else if(arr[mid] < arr[low]) high = mid;
			else low = mid+1;
		}
		return -1;
	}

}