package LeetCode.Easy;

/*

https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

*/

public class _1752 {

	public boolean check(int[] nums) {
		if(nums.length == 1) return true;
		int count = 0, n = nums.length, ptr1, ptr2;
		for(int i=0; i<n*2-1; i++) {
			ptr1 = i%n;
			ptr2 = (i+1)%n;
			if(nums[ptr1] <= nums[ptr2]) {
				count++;
			}else{
				count = 0;
			}
			if(count == n-1){
				return true;
			}
		}
		return false;
	}
	
}
