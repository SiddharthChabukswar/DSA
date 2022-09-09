package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

*/

public class fourhundredandfourtyeight {
	
	// HashSet method O(n)
	/*
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> answer = new ArrayList<Integer>();
		int[] num_set = new int[nums.length + 1];
		for(int num: nums) num_set[num] = 1;
		for(int i=1; i<=nums.length; i++) if(num_set[i] == 0) answer.add(i);
		return answer;
	}
	*/

	// Inplace sign change
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> answer = new ArrayList<Integer>();
		int temp = 0, n = nums.length;
		for(int i=0; i<n; i++){
			temp = Math.abs(nums[i]) - 1;
			if(nums[temp]>0) nums[temp] *= -1;
		}
		for(int i=0; i<n; i++) if(nums[i] > 0) answer.add(i+1);
		return answer;
	}

}
