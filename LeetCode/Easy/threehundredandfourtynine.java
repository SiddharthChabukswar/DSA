package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*

https://leetcode.com/problems/intersection-of-two-arrays/

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

*/

public class threehundredandfourtynine {

	public int[] intersection(int[] nums1, int[] nums2) {
		int[] hash_array = new int[1001];
		HashSet<Integer> answer_set = new HashSet<Integer>();
		List<Integer> answer_list = new ArrayList<Integer>();
		for(int i: nums1) hash_array[i] = 1;
		for(int i: nums2) if(hash_array[i] == 1) answer_set.add(i);
		for(int i: answer_set) answer_list.add(i);
		int[] answer = new int[answer_list.size()];
		for(int i=0; i<answer_list.size(); i++) answer[i] = answer_list.get(i);
		return answer;
	}

}
