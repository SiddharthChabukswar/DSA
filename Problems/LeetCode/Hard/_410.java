package LeetCode.Hard;

/*

https://leetcode.com/problems/split-array-largest-sum/

Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)

*/

public class _410 {

	boolean isSplitPossible(int[] nums, int k, long capacity) {
		long sum = 0l;
		int subArrays = 1, n = nums.length;
		for(int i=0; i<n; i++) {
			sum += nums[i];
			if(sum > capacity) {
				subArrays++;
				sum = nums[i];
			}
		}
		if(subArrays > k) return false;
		return true;
	}

	public int splitArray(int[] nums, int k) {
		long low = Long.MIN_VALUE, high = 0l, mid;
		int n = nums.length;
		for(int i=0; i<n; i++) {
			low = Math.max(low, (long) nums[i]);
			high += (long) nums[i];
		}
		while(low <= high) {
			mid = low + (high-low)/2;
			if(isSplitPossible(nums, k, mid) == true) high = mid-1;
			else low = mid+1;
		}
		return (int) low;
	}
	
}
