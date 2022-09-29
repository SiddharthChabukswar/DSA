package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/0?qa-rewrite=3336/print-all-valid-combinations-of-ip-address&show=3350&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=maximum-product-subarray

Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is [6, -3, -10] which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is [2, 3, 4, 5] which gives product as 120.
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
Note: Use 64-bit integer data type to avoid overflow.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 500
-102 ≤ Arri ≤ 102

*/

public class Maximum_Product_Subarray {

	// Kadane's algorithm one pass
	long maxProduct(int[] arr, int n) {
		long result = arr[0], max_product = arr[0], min_product = arr[0], temp;
		for(int i=1; i<n; i++) {
			temp = Math.max(arr[i], Math.max(max_product*arr[i], min_product*arr[i]));
			min_product = Math.min(arr[i], Math.min(max_product*arr[i], min_product*arr[i]));
			max_product = temp;
			result = Math.max(max_product, result);
		}
		return result;
	}

	// Two pass from left to right and right to left
	/*
	long maxProduct(int[] arr, int n) {
		long result = (long)arr[0], curr_prod;
		boolean isZeroPresent = false;
		curr_prod = 1l;
		for(int i=0; i<n; i++) {
			curr_prod *= (long)arr[i];
			if(arr[i] == 0) {
				isZeroPresent = true;
				curr_prod = 1l;
				continue;
			}
			result = Math.max(result, curr_prod);
		}
		curr_prod = 1l;
		for(int i=n-1; i>=0; i--) {
			curr_prod *= arr[i];
			if(arr[i] == 0) {
				isZeroPresent = true;
				curr_prod = 1l;
				continue;
			}
			result = Math.max(result, curr_prod);
		}
		if(isZeroPresent == true) result = Math.max(result, 0l);
		return result;
	}
	*/

}