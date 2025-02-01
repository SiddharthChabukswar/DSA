package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/subsets-ii/description/

Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10

*/
public class _90 {

	private List<Integer> cloneList(final List<Integer> currList) {
		List<Integer> clonedList = new ArrayList<>();
		clonedList.addAll(currList);
		return clonedList;
	}

	private void generatePowersetWithDuplicates(
		final int[] nums,
		final int idx,
		final List<Integer> currList,
		final List<List<Integer>> powerSet,
		final boolean check
	) {
		if (idx == nums.length) {
			powerSet.add(currList);
			return;
		}

		if (check == false || (idx != 0 && nums[idx] != nums[idx-1])) {
			generatePowersetWithDuplicates(nums, idx+1, cloneList(currList), powerSet, false);
		}
		List<Integer> clonedList = cloneList(currList);
		clonedList.add(nums[idx]);
		generatePowersetWithDuplicates(nums, idx+1, clonedList, powerSet, true);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> powerSet = new ArrayList<>();
		Arrays.sort(nums);
		generatePowersetWithDuplicates(nums, 0, new ArrayList<>(), powerSet, false);
		return powerSet;
	}
	
}
