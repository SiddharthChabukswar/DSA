package LeetCode.Hard;

/*

https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

*/
public class _42 {

	/*
	prefix Max, suffix Max - O(3*n) time O(2*n) space
	*/
	public int trap(int[] height) {
		int n = height.length;
		if (n < 3) return 0;
		int[] prefixMax = new int[n];
		int[] suffixMax = new int[n];
		prefixMax[0] = height[0];
		suffixMax[n-1] = height[n-1];
		for (int i=1; i<n; i++) {
			prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
		}
		for (int i=n-2; i>=0; i--) {
			suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
		}
		int currMin, answer = 0;
		for (int i=0; i<n; i++) {
			currMin = Math.min(prefixMax[i], suffixMax[i]);
			if (height[i] < currMin) answer += (currMin - height[i]);
		}
		return answer;
	}
	
}
