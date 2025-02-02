package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

*/
public class _40 {

	private void combinationSumRecursive(
		final int[] candidates, 
		final int target,
		final int idx,
		final List<List<Integer>> combinations,
		final List<Integer> currList
		) {
			// System.out.println(idx+"_"+currList);
			if (target == 0) {
				// System.out.println("Answer: " + currList);
				combinations.add(new ArrayList<>(currList));
				return;
			}
			for (int i=idx; i<candidates.length; i++) {
				if (i>idx && candidates[i] == candidates[i-1]) continue;
				if (candidates[i] > target) return;
				// System.out.println(idx+"_"+currList+"_Added: "+candidates[i]);
				currList.add(candidates[i]);
				combinationSumRecursive(candidates, target-candidates[i], i+1, combinations, currList);
				currList.remove(currList.size()-1);
				// System.out.println(idx+"_"+currList+"_Removed: "+candidates[i]);
			}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		final List<List<Integer>> combinations = new ArrayList<>();
		combinationSumRecursive(candidates, target, 0, combinations, new ArrayList<>());
		return combinations;
	}
	
}
