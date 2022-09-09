package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/move-zeroes/

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Could you minimize the total number of operations done?

*/

public class twohundredandeightythree {

	public void moveZeroes(int[] nums) {
		int i=0, j=0, n=nums.length;
		while(j<n){
			if(nums[j]!=0){
				nums[i++] = nums[j];
			}
			j++;
		}
		while(i<n) nums[i++] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		twohundredandeightythree objTwohundredandeightythree = new twohundredandeightythree();
		objTwohundredandeightythree.moveZeroes(nums);
		for(int i=0; i<n; i++) System.out.printf("%d, ", nums[i]);
		sc.close();
	}
	
}
