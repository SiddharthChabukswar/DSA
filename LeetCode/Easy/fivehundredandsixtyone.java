package LeetCode.Easy;

// import java.util.Arrays;
// import java.util.Scanner;

/*

https://leetcode.com/problems/array-partition/

Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

 

Example 1:

Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
Example 2:

Input: nums = [6,2,6,5,1,2]
Output: 9
Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
 

Constraints:

1 <= n <= 104
nums.length == 2 * n
-104 <= nums[i] <= 104

*/

public class fivehundredandsixtyone {

	private static final int K = 10000;

	// Counting Sort
	public int arrayPairSum(int[] nums) {
		int[] presentElementArray = new int[2*K + 1];
		for(int num: nums) presentElementArray[num + K]++;
		int max_sum = 0;
		boolean to_add = false; 
		for(int i=0; i<=2*K; i++) {
			while(presentElementArray[i] > 0) {
				if(to_add == true) max_sum += i;
				to_add = !to_add;
				presentElementArray[i]--;
			}
		}
		return max_sum;
	}

	// Merge Sort
	/*
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for(int i=0; i<nums.length; i+=2){
			sum += nums[i];
		}
		return sum;
	}
	*/
	
	public static void main(String[] args) {
	}
}
