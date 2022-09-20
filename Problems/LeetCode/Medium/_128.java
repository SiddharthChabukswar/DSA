package LeetCode.Medium;

import java.util.HashSet;

/*

https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

public class _128 {

	// HashSet approach O(n) -> count from every element which doesnt have any previous
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> presentElement = new HashSet<Integer>();
		int count, max_count, j, n;
		n = nums.length;
		count = max_count = 0;
		for(int num: nums) presentElement.add(num);
		for(int i=0; i<n; i++) {
			if(presentElement.contains(nums[i] - 1) == false) {
				j = 1;
				count = 1;
				while(presentElement.contains(nums[i] + j)){
					count++;
					j++;
				}
				max_count = Math.max(max_count, count);
			}
		}
		return max_count;
	}
	
}
