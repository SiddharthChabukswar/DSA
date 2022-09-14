package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=maximize-number-of-1s

Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.
 

Example 1:

Input:
N = 3
arr[] = {1, 0, 1}
M = 1
Output:
3
Explanation:
Maximum subarray is of size 3
which can be made subarray of all 1 after
flipping two zeros to 1.
Example 2:

Input:
N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output:
8
Explanation:
Maximum subarray is of size 8
which can be made subarray of all 1 after
flipping two zeros to 1.
 

Your Task:
Complete the function findZeroes() which takes array arr and two integers n, m, as input parameters and returns an integer denoting the answer.
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 

Constraints:
1 <= N <= 107
0 <= M <= N
0 <= arri <= 1


*/

public class Maximize_Number_of_1s {

	// Sliding window: maintain a window of size M
	int findZeroes(int arr[], int n, int m) {
		if(m==n) return n;
		int start = 0, end = 0, count_zero = 0, answer = 0;
		while(end < n) {
			if(arr[end] == 0) count_zero++;
			while(count_zero > m && start < end) {
				if(arr[start] == 0) count_zero--;
				start++;
			}
			answer = Math.max(answer, end-start+1);
			end++;
		}
		return answer;
	}
}
