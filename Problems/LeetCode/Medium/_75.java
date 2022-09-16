package LeetCode.Medium;

/*

https://leetcode.com/problems/sort-colors/

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

Accepted
1,180,136
Submissions
2,081,322


*/

public class _75 {

	// 1 Pass Three pointer approach (Dutch National Flag) O(n)
	public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1, temp;
		while(mid <= high){
			if(nums[mid] == 0) {
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
			}else if(nums[mid] == 2) {
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
			}else{
				mid++;
			}
		}
	}

	// 2 Pass Two pointer approach O(2*n)
	/*
	public void sortColors(int[] nums) {
		int n = nums.length, ptr1 = 0, ptr2 = 0, i;
		for(i = 0; i<2; i++) {
			ptr2 = ptr1;
			while(ptr2 < n) {
				if(nums[ptr2] == i) {
					nums[ptr2] = nums[ptr1];
					nums[ptr1] = i;
				}
				if(nums[ptr1] == i) ptr1++;
				ptr2++;
			}
		}
	}
	*/

}