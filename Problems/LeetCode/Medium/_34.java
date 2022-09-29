package LeetCode.Medium;

/*

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

*/

public class _34 {

	public int[] searchRange(int[] nums, int target) {
		int[] first_last_pair = new int[2];
		int low = 0, high = nums.length-1, mid, first = -1, last = -1;
		while(low <= high) {
			mid = (low + high)/2;
			if(nums[mid] > target) high = mid-1;
			else if(nums[mid] < target) low = mid+1;
			else {
				if(mid == 0 || nums[mid-1] != target) {
					first = mid;
					break;
				} else {
					high = mid-1;
				}
			}
		}
		low = 0;
		high = nums.length-1;
		while(low <= high) {
			mid = (low + high)/2;
			if(nums[mid] > target) high = mid-1;
			else if(nums[mid] < target) low = mid+1;
			else {
				if(mid == nums.length-1 || nums[mid+1] != target) {
					last = mid;
					break;
				} else {
					low = mid+1;
				}
			}
		}
		first_last_pair[0] = first;
		first_last_pair[1] = last;
		return first_last_pair;
	}
	
}
