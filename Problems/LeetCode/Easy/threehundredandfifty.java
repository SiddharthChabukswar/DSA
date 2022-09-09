package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashMap;
import java.util.List;

/*

https://leetcode.com/problems/intersection-of-two-arrays-ii/

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

public class threehundredandfifty {

	// No sort hashmap O(n+m)
	/*
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> answer_list = new ArrayList<Integer>();
		HashMap<Integer, Integer> num_map = new HashMap<Integer, Integer>();
		Integer curr = 0;
		for(int num1: nums1){
			curr = num_map.get(num1);
			if(curr == null) num_map.put(num1, 1);
			else num_map.put(num1, curr+1);
		}
		for(int num2: nums2){
			curr = num_map.get(num2);
			if(curr == null || curr == 0) continue;
			else{
				answer_list.add(num2);
				num_map.put(num2, curr-1);
			}
		}
		int n = answer_list.size();
		int[] answer = new int[n];
		for(int i=0; i<n; i++) answer[i] = answer_list.get(i);
		return answer;
	}
	*/

	// Sort algrithm
	public int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> answer_list = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int n1 = nums1.length, n2 = nums2.length;
		int i=0, j=0;
		while(i<n1 && j<n2){
			if(nums1[i] == nums2[j]){
				answer_list.add(nums1[i]);
				i++;
				j++;
			}
			else if(nums1[i] > nums2[j]) j++;
			else i++;
		}
		int n = answer_list.size();
		int[] answer = new int[n];
		for(i=0; i<n; i++) answer[i] = answer_list.get(i);
		return answer;
	}
}