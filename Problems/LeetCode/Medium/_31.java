package LeetCode.Medium;

import java.util.Arrays;

/*

https://leetcode.com/problems/next-permutation/

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

*/

public class _31 {
	
	public void nextPermutation(int[] nums) {
		int n = nums.length, i, j, min_ele_val, min_ele_idx;
		i = n-2;
		while(i >= 0) {
			j = i+1;
			if(nums[i] >= nums[j]) i--;
			else{
				min_ele_val = 101;
				min_ele_idx = 101;
				while(j<n){
					if(nums[j] > nums[i] && min_ele_val > nums[j]) {
						min_ele_val = nums[j];
						min_ele_idx = j;
					}
					j++;
				}
				min_ele_val = nums[i];
				nums[i] = nums[min_ele_idx];
				nums[min_ele_idx] = min_ele_val;
				break;
			}
		}
		if(i<0) Arrays.sort(nums);
		else Arrays.sort(nums, i+1, n);
	}

}