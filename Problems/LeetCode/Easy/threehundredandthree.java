package LeetCode.Easy;

/*

https://leetcode.com/problems/range-sum-query-immutable/

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.

*/

public class threehundredandthree {

	int[] nums;
	int[] numsSum;

	public threehundredandthree(int[] nums) {
		this.nums = nums;
		int n = nums.length;
		numsSum = new int[n+1];
		numsSum[0] = 0;
		for(int i=0; i<n; i++){
			numsSum[i+1] = numsSum[i] + nums[i];
		}
	}

	/*
	public NumArray(int[] nums) {
		this.nums = nums;
		int n = nums.length;
		numsSum = new int[n+1];
		numsSum[0] = 0;
		for(int i=0; i<n; i++){
			numsSum[i+1] = numsSum[i] + nums[i];
		}
	}
	*/
	public int sumRange(int left, int right) {
		return numsSum[right+1] - numsSum[left];
	}
	
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		threehundredandthree objThreehundredandthree = new threehundredandthree(nums);
		int left = 0, right = 5;
		System.out.println(objThreehundredandthree.sumRange(left, right));
	}

}
