package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=who-will-win

Given an array arr[] sorted in ascending order of size N and an integer K. Check if K is present in the array or not.


Example 1:

Input:
N = 5, K = 6
arr[] = {1,2,3,4,6}
Output: 1
Exlpanation: Since, 6 is present in 
the array at index 4 (0-based indexing),
output is 1.
 

Example 2:

Input:
N = 5, K = 2
arr[] = {1,3,4,5,6}
Output: -1
Exlpanation: Since, 2 is not present 
in the array, output is -1.
 

Your Task:
You don't need to read input or print anything. Complete the function searchInSorted() which takes the sorted array arr[], its size N and the element K as input parameters and returns 1 if K is present in the array, else it returns -1. 


Expected Time Complexity: O(Log N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 106
1 <= K <= 106
1 <= arr[i] <= 106

*/

public class Searching_an_Element_in_a_Sorted_Array {
	
	static int searchInSorted(int arr[], int N, int K) {
		int left, right, mid;
		left = 0;
		right = N;
		while(right > left) {
			mid = (left + right)/2;
			if(arr[mid] == K) return 1;
			if(arr[mid] < K) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return -1;
	}
}
