package LeetCode.Medium;

import java.util.ArrayList;
// import java.util.HashMap;
import java.util.List;

/*

https://leetcode.com/problems/majority-element-ii/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?

*/

public class _229 {

	// Modified BoyerMoore's Voting algorithm: O(1) space
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> majorityElements3 = new ArrayList<Integer>();
		int maj_ele1 = -1, maj_ele2 = -1, count1 = 0, count2 = 0;
		for(int num: nums) {
			System.out.println(maj_ele1 + " " + count1 + " " + maj_ele2 + " " + count2);
			if(num == maj_ele1) {
				count1++;
			} else if(num == maj_ele2) {
				count2++;
			} else if(count1 == 0) {
				maj_ele1 = num;
				count1++;
			} else if(count2 == 0) {
				maj_ele2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}
		System.out.println(maj_ele1 + " " + count1 + " " + maj_ele2 + " " + count2);
		count1 = 0;
		count2 = 0;
		for(int num: nums) {
			if(num == maj_ele1) count1++;
			else if(num == maj_ele2) count2++;
		}
		if(count1 > nums.length/3) majorityElements3.add(maj_ele1);
		if(count2 > nums.length/3) majorityElements3.add(maj_ele2);
		return majorityElements3;
	}


	// HashMap solution : O(n) space
	/*
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> majorityElements3 = new ArrayList<Integer>();
		Integer n = nums.length, value, min_freq = n/3;
		HashMap<Integer, Integer> numFrequency = new HashMap<Integer, Integer>();
		for(Integer num: nums) {
			value = numFrequency.get(num);
			if(value == null) value = 0;
			numFrequency.put(num, ++value);
		}
		for(Integer num: numFrequency.keySet()) {
			value  = numFrequency.get(num);
			if(value > min_freq) majorityElements3.add(num);
		}
		return majorityElements3;
	}
	*/
	
}
