package LeetCode.Hard;

// import java.util.HashMap;

/*

https://leetcode.com/problems/reverse-pairs/

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1

*/

public class _493 {

	private int mergeAndCount(int[] nums, int low, int mid, int high) {
		int count = 0;
		int ptr1 = low, ptr2 = mid+1, k;
		while(ptr1 <= mid) {
			if(ptr2 > high) {
				count += high-mid;
				ptr1++;
			} else if(nums[ptr1] <= 2*(long)(nums[ptr2])) {
				count += ptr2-mid-1;
				ptr1++;
			} else {
				ptr2++;
			}
		}
		ptr1 = low;
		ptr2 = mid+1;
		k = 0;
		int[] temp = new int[high-low+1];
		while(ptr1 <= mid && ptr2 <= high) {
			if(nums[ptr1] <= nums[ptr2]) temp[k++] = nums[ptr1++];
			else temp[k++] = nums[ptr2++];
		}
		while(ptr1 <= mid) temp[k++] = nums[ptr1++];
		while(ptr2 <= high) temp[k++] = nums[ptr2++];
		for(k=low; k<=high; k++) nums[k] = temp[k-low];
		return count;
	}

	private int mergeSort(int[] nums, int low, int high) {
		int count = 0;
		if(low < high) {
			int mid = (low + high)/2;
			count += mergeSort(nums, low, mid);
			count += mergeSort(nums, mid+1, high);
			count += mergeAndCount(nums, low, mid, high);
		}
		return count;
	}

	// Modified Merge Sort approach O(nlogn)
	// https://www.youtube.com/watch?v=S6rsAlj_iB4&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=19
	public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length-1);
	}

	// Quadratic O(n^2) TLE
	/*
	public int reversePairs(int[] nums) {
		HashMap<Long, Integer> prevCount = new HashMap<>();
		Integer value, answer = 0;
		Long checkKey;
		for(int num: nums) {
			checkKey = 2*(long)(num);
			for(Long key: prevCount.keySet()) {
				if(key > checkKey) {
					answer += prevCount.get(key);
				}
			}
			value = prevCount.get((long)(num));
			if(value == null) value = 0;
			prevCount.put((long)(num), ++value);
		}
		return answer;
	}
	*/
	
}
