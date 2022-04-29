package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?

*/

public class hundredandsixtynine {
	
	// Brute force O(n^2)
	/*
	public int majorityElement(int[] nums) {
		int answer = -1, i, j, count, n = nums.length, key;
		for(i=0; i<n; i++){
			key = nums[i];
			count = 0;
			for(j=i; j<n; j++){
				if(nums[j] == key) count++;
			}
			if(count > n/2) answer = key;
		}
		return answer;
	}
	*/

	// Hashmap O(n) | Space O(n)
	/*
	public int majorityElement(int[] nums){
		int answer = nums[0], key, n = nums.length, i;
		Integer count;
		HashMap<Integer, Integer> element_count = new HashMap<Integer, Integer>();
		for(i=0; i<n; i++){
			key = nums[i];
			count = element_count.get(key);
			if(count == null) count = 0;
			element_count.put(key, count+1);
			if(count+1 > (n/2)) answer = key;
		}
		return answer;
	}
	*/
	
	public int majorityElement(int[] nums){
		int answer = 0;
		return answer;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter the array elements: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		hundredandsixtynine objHundredandsixtynine = new hundredandsixtynine();
		System.out.println(objHundredandsixtynine.majorityElement(nums));
		sc.close();
	}

}
