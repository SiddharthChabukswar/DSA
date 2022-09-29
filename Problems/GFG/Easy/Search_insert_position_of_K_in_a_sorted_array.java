package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=search-insert-position-of-k-in-a-sorted-array

Given a sorted array Arr[](0-index based) consisting of N distinct integers and an integer k, the task is to find the index of k, if its present in the array Arr[]. Otherwise, find the index where k must be inserted to keep the array sorted.


Example 1:

Input:
N = 4
Arr = {1, 3, 5, 6}
k = 5
Output: 2
Explaination: Since 5 is found at index 2 
as Arr[2] = 5, the output is 2.

Example 2:

Input:
N = 4
Arr = {1, 3, 5, 6}
k = 2
Output: 1
Explaination: Since 2 is not present in 
the array but can be inserted at index 1 
to make the array sorted.

Your Task:
You don't need to read input or print anything. Your task is to complete the function searchInsertK() which takes the array Arr[] and its size N and k as input parameters and returns the index.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
-103 ≤ Arr[i] ≤ 103
-103 ≤ k ≤ 103


*/

public class Search_insert_position_of_K_in_a_sorted_array {

	static int searchInsertK(int Arr[], int N, int k) {
		int low = 0, high = N-1, mid;
		while(low <= high) {
			mid = (low + high)/2;
			if(Arr[mid] == k) return mid;
			else if(Arr[mid] > k) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

}