package LeetCode.Easy;

import java.util.HashMap;
import java.util.Scanner;

/*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1
 

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

*/

public class hundredandthirtysix {

	// Brute force O(n^2)
	/*
	public int singleNumber(int[] nums) {
		int count, i, j, n = nums.length;
		for(i=0; i<n; i++){
			count = 0;
			for(j=0; j<n; j++){
				if(nums[j] == nums[i]) count++;
			}
			if(count != 2) return nums[i];
		}
		return 0;
	}
	*/
	
	// 

	// Using hashmap O(n) Extra space O(n)

	public int singleNumber(int[] nums) {
		HashMap<Integer, Boolean> present = new HashMap<Integer, Boolean>();
		int answer = 0, n = nums.length, i;
		for(i=0; i<n; i++){
			if(present.get(nums[i]) == null || present.get(nums[i]) == false){
				present.put(nums[i], true);
				answer += nums[i];
			}else{
				present.put(nums[i], false);
				answer -= nums[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array length: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		hundredandthirtysix objHundredandthirtysix = new hundredandthirtysix();
		int answer = objHundredandthirtysix.singleNumber(nums);
		System.out.println(answer);
		sc.close();
	}
}
