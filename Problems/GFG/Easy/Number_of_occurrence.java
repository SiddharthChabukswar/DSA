package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence

Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
Example 2:

Input:
N = 7, X = 4
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 0
Explanation: 4 is not present in the
given array.
Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes the array of integers arr, n and x as parameters and returns an integer denoting the answer.

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
1 ≤ X ≤ 106

*/

public class Number_of_occurrence {

	int count(int[] arr, int n, int x) {
		int low = 0, high = n-1, mid, first = -1, last = -1;
		while(low <= high) {
			mid = (low + high)/2;
			if(arr[mid] > x) high = mid-1;
			else if(arr[mid] < x) low = mid+1;
			else {
				if(mid == 0 || arr[mid-1] != x) {
					first = mid;
					break;
				} else {
					high = mid-1;
				}
			}
		}
		if(first == -1) return 0;
		low = 0;
		high = n-1;
		while(low <= high) {
			mid = (low + high)/2;
			if(arr[mid] > x) high = mid-1;
			else if(arr[mid] < x) low = mid+1;
			else {
				if(mid == n-1 || arr[mid+1] != x) {
					last = mid;
					break;
				} else {
					low = mid+1;
				}
			}
		}
		return last-first+1;
	}

}