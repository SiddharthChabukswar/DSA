package LeetCode.Easy;

import java.util.HashMap;
import java.util.Set;

/*

https://leetcode.com/problems/longest-harmonious-subsequence/

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Example 2:

Input: nums = [1,2,3,4]
Output: 2
Example 3:

Input: nums = [1,1,1,1]
Output: 0
 

Constraints:

1 <= nums.length <= 2 * 104
-109 <= nums[i] <= 109

*/

public class fivehundredandninetyfour {

	// HashMap solution O(n)
	public int findLHS(int[] nums) {
		int answer = 0;
		HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		Integer value = null;
		for(int i=0; i<nums.length; i++) {
			value = frequencyMap.get(nums[i]);
			if(value == null) value = 0;
			frequencyMap.put(nums[i], ++value);
		}
		Set<Integer> keySet = frequencyMap.keySet();
		for(Integer key: keySet) {
			if(keySet.contains(key+1)) answer = Math.max(frequencyMap.get(key) + frequencyMap.get(key+1), answer);
		}
		return answer;
	}

	// Brute force O(n^2) T.L.E.
	/*
	public int findLHS(int[] nums) {
		int answer = 0, count = 0, n = nums.length;
		boolean valid = false;
		for(int i=0; i<n; i++) {
			count = 0;
			valid = false;
			for(int j=i; j<n; j++) {
				if(nums[j] == nums[i]) count++;
				else if(nums[j]+1 == nums[i]) {
					count++;
					valid = true;
				} 
			}
			if(valid) {
				answer = Math.max(answer, count);
			}
		}
		return answer;
	}
	*/
	
}
