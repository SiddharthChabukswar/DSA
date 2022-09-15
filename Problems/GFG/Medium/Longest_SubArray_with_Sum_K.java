package GFG.Medium;

import java.util.HashMap;

/*

https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k

Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.
Example 2:

Input : 
A[] = {-1, 2, 3}
K = 6
Output : 0
Explanation: 
There is no such sub-array with sum 6.
Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function lenOfLongSubarr() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1<=N<=105
-105<=A[i], K<=105


*/

public class Longest_SubArray_with_Sum_K {
	
	// prefix sum HashMap solution O(n) 
	public static int lenOfLongSubarr(int A[], int N, int K) {
		HashMap<Long, Integer> occuredFirstMap = new HashMap<Long, Integer>();
		occuredFirstMap.put(0l, -1);
		int i, answer = 0;
		Long curr_sum = 0l;
		Integer value;
		for(i=0; i<N; i++) {
			curr_sum += A[i];
			value = occuredFirstMap.get(curr_sum-K);
			if(value != null) {
				answer = Math.max(answer, i-value);
			}
			value = occuredFirstMap.get(curr_sum);
			if(value == null) {
				occuredFirstMap.put(curr_sum, i);
			}
		}
		return answer;
	}

	// prefix sum solution O(n^2) - TLE
	/*
	private static int[] getPrefixSum(int A[]) {
		int n = A.length;
		int[] prefixSumArr = new int[n+1];
		for(int i=1; i<=n; i++) prefixSumArr[i] = prefixSumArr[i-1] + A[i-1];
		return prefixSumArr;
	}

	public static int lenOfLongSubarr(int A[], int N, int K) {
		int[] prefixSumArr = getPrefixSum(A);
		int i, j, k, n=N;
		for(i=0; i<n; i++) {
			for(j=0; j<=i; j++) {
				k=j+n-i;
				if((prefixSumArr[k] - prefixSumArr[j]) == K) return k-j;
			}
		}
		return 0;
	}
	*/
}
