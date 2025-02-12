package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/permutations/description/

Given an array nums of distinct integers, return all the possible 
permutations
. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/
public class _46 {

	/*
	Recursion O(N!xN) extra space for storing visited elements.
	*/
	/*
	private void recursivePermutation(final int[] nums, final int[] visited, final List<Integer> currList, final List<List<Integer>> permutationList) {
		if (currList.size() == nums.length) {
			permutationList.add(new ArrayList<>(currList));
			return;
		}
		for (int i=0; i<nums.length; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				currList.add(nums[i]);
				recursivePermutation(nums, visited, currList, permutationList);
				currList.remove(currList.size()-1);
				visited[i] = 0;
			}
		}
	}
	*/

	private void swap(final int[] nums, final int i, final int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/*
	Recursion backtracking (N!xN) no extra space.
	*/
	private void backtrackingPermutation(final int[] nums, final int index, final List<List<Integer>> permutationList) {
		if (index == nums.length) {
			final List<Integer> currList = new ArrayList<>();
			for (int num: nums) {
				currList.add(num);
			}
			permutationList.add(currList);
			return;
		}
		for (int i=index; i<nums.length; i++) {
			swap(nums, i, index);
			backtrackingPermutation(nums, index+1, permutationList);
			swap(nums, i, index);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		final List<List<Integer>> permutationList = new ArrayList<>();
		backtrackingPermutation(nums, 0, permutationList);
		return permutationList;
	}
	
}
