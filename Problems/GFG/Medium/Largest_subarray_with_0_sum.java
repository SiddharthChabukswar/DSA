package GFG.Medium;

import java.util.HashMap;
import java.util.Map;

/*

https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

Largest subarray with 0 sum
Difficulty: MediumAccuracy: 41.84%Submissions: 373K+Points: 4
Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The subarray is [0, -4, 3, 1, 0].
Constraints:
1 ≤ arr.size() ≤ 106
−103 ≤ arr[i] ≤ 103, for each valid i

*/
public class Largest_subarray_with_0_sum {

	int maxLen(int arr[]) {
		int maxLen = 0;
		Map<Integer, Integer> firstIdx = new HashMap<>();
		firstIdx.put(0, 0);
		Integer key = 0, value;
		for (int i=0; i<arr.length; i++) {
			key += arr[i];
			value = firstIdx.get(key);
			if (value == null) {
				firstIdx.put(key, i+1);
			} else {
				maxLen = Math.max(maxLen, i+1-value);
			}
		}
		return maxLen;
	}

}