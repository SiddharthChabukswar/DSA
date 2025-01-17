package LeetCode.Medium;

// import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


-2
1
-3
4
-1
2
1
-5
4

*/

public class _53 {

	/* Kadane's alogorithm - DP O(n)

	public int maxSubArray(int[] nums) {
		int nlen = nums.length;
		//System.out.println(Arrays.toString(nums));

		// DP - Kadane's Algorithm O(n)
		int i=1, currsum = nums[0], maxsum = nums[0];
		for(i=1; i<nlen; i++){
			// System.out.printf("%d : %d\n", nums[i], currsum);
			currsum = Math.max(nums[i], currsum + nums[i]);
			maxsum = Math.max(maxsum, currsum);
		}

		// Brute force O(n^2) (TLE)
		int i, j, currsum = 0, maxsum = Integer.MIN_VALUE;
		for(i=0; i<nlen; i++){
			currsum = 0;
			for(j=i; j<nlen; j++){
				currsum = currsum + nums[j];
				maxsum = Math.max(maxsum, currsum);
			}
		}
		return maxsum;
	}
	*/

	/* Divide and conquer approach O(nlogn) */
	private int crossMaxSum(int[] nums, int left, int mid, int right) {
		int leftMaxSum = Integer.MIN_VALUE, rightMaxSum = Integer.MIN_VALUE;
		int currSum, itr;
		for (itr=mid, currSum=0; itr>=left; itr--) {
			currSum += nums[itr];
			leftMaxSum = Math.max(leftMaxSum, currSum);
		}
		for (itr=mid+1, currSum=0; itr<=right; itr++) {
			currSum += nums[itr];
			rightMaxSum = Math.max(rightMaxSum, currSum);
		}
		return leftMaxSum+rightMaxSum;
	}

	private int maxSubArray(int[] nums, int left, int right) {
		if (left == right)
			return nums[left];
		int mid = (left+right)/2;
		int leftMaxSum = maxSubArray(nums, left, mid);
		int rightMaxSum = maxSubArray(nums, mid+1, right);
		int crossMaxSum = crossMaxSum(nums, left, mid, right);
		return Math.max(Math.max(leftMaxSum, rightMaxSum), crossMaxSum);
	}

	public int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array length: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		_53 objFiftythree = new _53();
		System.out.println(objFiftythree.maxSubArray(nums));
		sc.close();
	}

}
