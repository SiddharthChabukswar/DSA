package GFG.Easy;

import java.util.ArrayList;

/*

https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=first-and-last-occurrences-of-x

Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5. 
 

Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 6 

Your Task:
Since, this is a function problem. You don't need to take any input, as it is already accomplished by the driver code. You just need to complete the function find() that takes array arr, integer n and integer x as parameters and returns the required answer.
Note: If the number x is not found in the array just return both index as -1.

 

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N ≤ 107

*/

public class First_and_last_occurrences_of_x {

	ArrayList<Long> find(long arr[], int n, int x) {
		ArrayList<Long> first_last_pair = new ArrayList<Long>();
		int low = 0, high = n-1, mid;
		Long first = -1l, last = -1l;
		while(low <= high) {
			mid = (low + high)/2;
			if(arr[mid] > x) high = mid-1;
			else if(arr[mid] < x) low = mid+1;
			else {
				if(mid == 0) {
					first = 0l;
					break;
				} else if(arr[mid-1] != x) {
					first = (long)mid;
					break;
				} else {
					high = mid-1;
				}
			}
		}
		low = 0;
		high = n-1;
		while(low <= high) {
			mid = (low + high)/2;
			if(arr[mid] > x) high = mid-1;
			else if(arr[mid] < x) low = mid+1;
			else {
				if(mid == n-1) {
					last = (long)(n-1);
					break;
				} else if(arr[mid+1] != x) {
					last = (long)mid;
					break;
				} else {
					low = mid+1;
				}
			}
		}
		first_last_pair.add(first);
		first_last_pair.add(last);
		return first_last_pair;
	}

}