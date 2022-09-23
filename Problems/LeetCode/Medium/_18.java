package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/4sum/

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

0
[1, 0, -1, 0, -2, 2]
[-2, -1, 0, 0, 1, 2]
[-2, -1, 1, 2]
[-2, 0, 0, 2]
[-1, 0, 0, 1]

*/

public class _18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> fourSumLists = new ArrayList<List<Integer>>();
		List<Integer> fourSumList;
		Arrays.sort(nums);
		int i, j, low, high, n = nums.length;
		long sum;
		for(i=0; i<n-3; i++) {
			if(i!=0 && nums[i] == nums[i-1]) continue;
			for(j=i+1; j<n-2; j++) {
				if(j!=i+1 && nums[j] == nums[j-1]) continue;
				low = j+1;
				high = n-1;
				while(low < high) {
					sum = ((long)nums[i] + (long)nums[j] + (long)nums[low] + (long)nums[high]);
					// System.out.println(target + " " + sum + " " + nums[i] + " " + nums[j] + " " + nums[low] + " " + nums[high]);
					if(sum == target) {
						fourSumList = new ArrayList<Integer>();
						for(int num: new int[]{nums[i], nums[j], nums[low], nums[high]}) fourSumList.add(num);
						fourSumLists.add(fourSumList);
						do {
							low++;
						} while(low < high && nums[low] == nums[low-1]);
						do {
							high--;
						} while(low < high && nums[high] == nums[high+1]);
					}
					else if(sum < target) {
						do {
							low++;
						} while(low < high && nums[low] == nums[low-1]);
					} else {
						do {
							high--;
						} while(low < high && nums[high] == nums[high+1]);
					}
				}
			}
		}
		return fourSumLists;		
	}
	
}
