package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashMap;
// import java.util.HashSet;
import java.util.List;

/*

https://leetcode.com/problems/3sum/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 
*/

public class _15 {

	public List<Integer> sortedPairOfThree(int[] nums) {
		List<Integer> sortedPair = new ArrayList<Integer>();
		int first = 0, second = 0, third = 0, i = 0, j = 1, k = 2;		
		if(nums[i] >= nums[j]) {
			if(nums[i] >= nums[k]) {
				third = nums[i];
				if(nums[j] >= nums[k]) {
					second = nums[j];
					first = nums[k];
				}else {
					second = nums[k];
					first = nums[j];
				}
			} else {
				third = nums[k];
				second = nums[i];
				first = nums[j];
			}
		} else {
			if(nums[j] >= nums[k]) {
				third = nums[j];
				if(nums[i] >= nums[k]) {
					second = nums[i];
					first = nums[k];
				}else {
					second = nums[k];
					first = nums[i];
				}
			} else {
				third = nums[k];
				second = nums[j];
				first = nums[i];
			}
		}
		sortedPair.add(first);
		sortedPair.add(second);
		sortedPair.add(third);
		return sortedPair;

	}

	// Two pointer optimal solution O(n^2) [-4, -1, -1, 0, 1, 2]
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> threeSumLists = new ArrayList<List<Integer>>();
		List<Integer> threeSumList;
		Arrays.sort(nums);
		int i, n = nums.length, low, high, exp_sum, sum;
		for(i=0; i<n-2; i++) {
			if(i!=0 && (nums[i] == nums[i-1])) continue;
			else {
				low = i+1;
				high = n-1;
				exp_sum = -1*nums[i];
				while(low < high) {
					sum = nums[low] + nums[high];
					// System.out.println(low + " " + high + " " + exp_sum + " " + sum);
					if(sum == exp_sum) {
						threeSumList = new ArrayList<Integer>();
						threeSumList.add(nums[i]);
						threeSumList.add(nums[low]);
						threeSumList.add(nums[high]);
						threeSumLists.add(threeSumList);
						do{
							low++;
						} while(low < high && nums[low] == nums[low-1]);
						do{
							high--;
						} while(low < high && nums[high] == nums[high+1]);
					}
					else if(exp_sum > sum) {
						do{
							low++;
						} while(low < high && nums[low] == nums[low-1]);
					} else {
						do{
							high--;
						} while(low < high && nums[high] == nums[high+1]);
					}
				}
			}
		}
		return threeSumLists;
	}


	// HashSet Approach O(n^2.logn) :: Also TLE
	/*
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> threeSumLists = new ArrayList<List<Integer>>();
		List<Integer> threeSumList = new ArrayList<Integer>();
		HashSet<List<Integer>> uniqueList = new HashSet<List<Integer>>();
		HashMap<Integer, Integer> numsFreq = new HashMap<Integer, Integer>();
		Integer value;
		for(int num: nums) {
			value = numsFreq.get(num);
			if(value == null) value = 0;
			numsFreq.put(num, ++value);
		}
		int i, j, sum, n = nums.length;
		for(i=0; i<n-2; i++) {
			value = numsFreq.get(nums[i]);
			numsFreq.put(nums[i], --value);
			for(j=i+1; j<n-1; j++) {
				value = numsFreq.get(nums[j]);
				numsFreq.put(nums[j], --value);
				sum = -1 * (nums[i] + nums[j]);
				value = numsFreq.get(sum);
				if(value != null && value != 0) {
					threeSumList = this.sortedPairOfThree(new int[]{nums[i], nums[j], sum});
					if(uniqueList.contains(threeSumList) == false) {
						uniqueList.add(threeSumList);
						threeSumLists.add(threeSumList);
					}
				}
				value = numsFreq.get(nums[j]);
				numsFreq.put(nums[j], ++value);
			}
			value = numsFreq.get(nums[i]);
			numsFreq.put(nums[i], ++value);
		}
		return threeSumLists;
	}
	*/

	// TLE Approach O(n^3.logn)
	/*
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> threeSumLists = new ArrayList<List<Integer>>();
		List<Integer> threeSumList;
		HashSet<String> stringSet = new HashSet<String>();
		int n = nums.length, sum = 0, i, j, k;
		String sortedPairString;
		for(i=0; i<n-2; i++) {
			for(j=i+1; j<n-1; j++) {
				for(k=j+1; k<n; k++) {
					sum = nums[i] + nums[j] + nums[k];
					if(sum == 0){
						threeSumList = this.sortedPairOfThree(new int[]{nums[i], nums[j], nums[k]});
						sortedPairString = "";
						sortedPairString += String.valueOf(threeSumList.get(0));
						sortedPairString += String.valueOf(threeSumList.get(1));
						sortedPairString += String.valueOf(threeSumList.get(2));
						System.out.print(sortedPairString + " " + threeSumList);
						if(stringSet.contains(sortedPairString)) continue;
						else {
							System.out.print(" - new");
							stringSet.add(sortedPairString);
							threeSumLists.add(threeSumList);
						}
						System.out.println();
					}
				}
			}
		}
		return threeSumLists;
	}
	*/
	
}
