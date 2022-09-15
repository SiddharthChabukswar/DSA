package LeetCode.Medium;

import java.util.HashMap;

/*

https://leetcode.com/problems/subarray-sum-equals-k/

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

*/

public class _560 {
	
	// HashMap method to store occurance of prefix sum till point O(n)
	public int subarraySum(int[] nums, int k) {
		int answer = 0, n = nums.length;
		HashMap<Long, Integer> occurrenceFrequency = new HashMap<Long, Integer>();
		occurrenceFrequency.put(0l, 1);
		int i;
		Long curr_sum = 0l;
		Integer value;
		for(i=0; i<n; i++) {
			curr_sum += nums[i];
			value = occurrenceFrequency.get(curr_sum - k);
			if(value != null) {
				answer += value;
			}
			value = occurrenceFrequency.get(curr_sum);
			if(value == null) {
				value = 0;
			}
			occurrenceFrequency.put(curr_sum, ++value);
		}
		return answer;
	}


	// Prefix sum solution O(n^2) - TLE
	/*
	private int[] getPrefixSum(int[] nums) {
		int n = nums.length;
		int[] prefixSumArr = new int[n+1];
		for(int i=1; i<=n; i++) prefixSumArr[i] = prefixSumArr[i-1] + nums[i-1];
		return prefixSumArr;
	}

	public int subarraySum(int[] nums, int k) {
		int[] prefixSumArr = getPrefixSum(nums);
		int n = nums.length, answer = 0, i, j, l;
		for(i=0; i<n; i++) {
			for(j=0; j<=i; j++) {
				l = j+n-i;
				if((prefixSumArr[l] - prefixSumArr[j]) == k) answer++;
			}
		}
		return answer;
	}
	*/
}
