package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/subsets/description/

Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

*/
public class _78 {

	private List<Integer> cloneList(final List<Integer> inputList) {
		List<Integer> clonedList = new ArrayList<>();
		clonedList.addAll(inputList);
		return clonedList;
	}
	
	private void generatePowerset(final int[] nums, final int idx, final List<Integer> currList,
		 final List<List<Integer>> powerSet) {
			if (idx == nums.length) {
				powerSet.add(currList);
				return;
			}
			List<Integer> list1 = cloneList(currList);
			List<Integer> list2 = cloneList(currList);
			list2.add(nums[idx]);
			generatePowerset(nums, idx+1, list1, powerSet);
			generatePowerset(nums, idx+1, list2, powerSet);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<>();
		generatePowerset(nums, 0, new ArrayList<>(), powerSet);
		return powerSet;
	}
}
