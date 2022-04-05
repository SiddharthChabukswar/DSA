package LeetCode.Easy;

import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one twoSum, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

*/

class one{

	public int[] twoSum(int[] nums, int target) {
		int[] answer = new int[2];
		int diff = 0;
		int arrayLength = nums.length;
		boolean done = false;

		// System.out.println(Arrays.toString(nums));
		// System.out.println(target);
		
		// Brute force O(n^2)
		for(int i=0; i<arrayLength; i++){
			diff = target - nums[i];
			for(int j=i+1; j<arrayLength; j++){
				if(nums[j] == diff){
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
			if(done == true) break;
		}

		// HashMap O(n)
		/*
		for(int i=0; i<arrayLength; i++){

		}
		*/
		return answer;
	}

	public static void main(String[] args){
		one obj = new one();
		Scanner sc = new Scanner(System.in);
		int arraysize = sc.nextInt();
		int[] nums = new int[arraysize];
		for(int i=0; i<arraysize; i++) nums[i] = sc.nextInt();
		int target = sc.nextInt();
		int[] answer = obj.twoSum(nums, target);
		System.out.print(Arrays.toString(answer));
		sc.close();
	}

}