package LeetCode.Medium;

/*

https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

*/

public class _152 {

	// Kadane's algorithm - one pass O(n)
	public int maxProduct(int[] nums) {
		int maxProduct = nums[0], minProduct = nums[0], result = nums[0], temp, n = nums.length;
		for(int i=1; i<n; i++) {
			temp = Math.max(nums[i], Math.max(maxProduct*nums[i], minProduct*nums[i]));
			minProduct = Math.min(nums[i], Math.min(maxProduct*nums[i], minProduct*nums[i]));
			maxProduct = temp;
			result = Math.max(maxProduct, result);
		}
		return result;
	}

	// Two pass approach O(n)
	/*
	public int maxProduct(int[] nums) {
		int maxProduct = nums[0], currProduct, n = nums.length, i;
		boolean isZeroPresent = false;
		currProduct = 1;
		for(i=0; i<n; i++) {
			currProduct *= nums[i];
			if(nums[i] == 0) {
				isZeroPresent = true;
				currProduct = 1;
				continue;
			}
			maxProduct = Math.max(maxProduct, currProduct);
		}
		currProduct = 1;
		for(i=n-1; i>=1; i--) {
			currProduct *= nums[i];
			if(nums[i] == 0) {
				isZeroPresent = true;
				currProduct = 1;
				continue;
			}
			maxProduct = Math.max(maxProduct, currProduct);
		}
		if(isZeroPresent == true) maxProduct = Math.max(maxProduct, 0);
		return maxProduct;
	}
	*/
	
}
