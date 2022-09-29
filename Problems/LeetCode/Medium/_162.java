package LeetCode.Medium;

/*

https://leetcode.com/problems/find-peak-element/#:~:text=Find%20Peak%20Element%20%2D%20LeetCode&text=A%20peak%20element%20is%20an,to%20any%20of%20the%20peaks.

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 

Constraints:

1 <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
nums[i] != nums[i + 1] for all valid i.

*/

public class _162 {

	int divideAndConquer(int[] nums, int low, int high) {
		if(low <= high) {
			int mid = (low + high)/2;
			if(mid == 0) {
				if(nums[mid] > nums[mid+1]) return mid;
				else return divideAndConquer(nums, mid+1, high);
			} else if(mid == nums.length-1) {
				if(nums[mid] > nums[mid-1]) return mid;
				else return divideAndConquer(nums, low, mid-1);
			} else {
				if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) return mid;
				int left_val = divideAndConquer(nums, low, mid-1);
				if(left_val != -1) return left_val;
				int right_val = divideAndConquer(nums, mid+1, high);
				if(right_val != -1) return right_val;
			}
		}
		return -1;
	}

	public int findPeakElement(int[] nums) {
		if(nums.length == 1) return 0;
		return divideAndConquer(nums, 0, nums.length-1);
	}
	
}
