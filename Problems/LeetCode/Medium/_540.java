package LeetCode.Medium;

/*

https://leetcode.com/problems/single-element-in-a-sorted-array/

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

*/

public class _540 {
	
	public int singleNonDuplicate(int[] nums) {
		int low = 0, high = nums.length-1, mid;
		while(low <= high) {
			mid = (low+high)/2;
			if(mid!=0 && nums[mid]==nums[mid-1]) {
				if((mid-low+1)%2 == 0) low = mid+1;
				else high = mid-2;
			} else if(mid!=nums.length-1 && nums[mid]==nums[mid+1]) {
				if((high-mid+1)%2 == 0) high = mid-1;
				else low = mid+2;
			} else return nums[mid];
		}
		return -1;
	}

}
