package LeetCode.Medium;

/*

https://leetcode.com/problems/rotate-array/

Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?


*/

public class _189 {

	// Reversing the two parts of array [0 to n-k) and [n-k, n)
	public void reverseArray(int[] nums, int start, int end) {
		int temp;
		end--;
		while(end > start) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n;
		if(k==0) return;
		reverseArray(nums, 0, n-k);
		reverseArray(nums, n-k, n);
		reverseArray(nums, 0, n);
	}


	// Dividing the array into GCD(n, k) segments and working on each // Swapping technique
	/*
	public int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k%=n;
		if(k%n == 0) return;
		int segments_to_work = gcd(k, n), i, j, l, temp, curr;
		for(i=0; i<segments_to_work; i++) {
			j=i;
			curr = nums[j];
			while(true){
				l = (j+k)%n;
				if(l == i) break;
				temp = nums[l];
				nums[l] = curr;
				curr = temp;
				j = l;
			}
			nums[i] = curr;
		}
	}
	*/

}
