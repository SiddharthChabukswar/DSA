package LeetCode.Easy;

import java.util.HashSet;
import java.util.Scanner;

/*

https://leetcode.com/problems/contains-duplicate/

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

public class twohundredandseventeen {

	// HashSet check time and space O(n)
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> checked = new HashSet<Integer>();
		for(int num: nums){
			if(checked.contains(num)) return true;
			checked.add(num);
		}
		return false;
	}

	// Sort check time O(nlogn) and space O(1)
	/*
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=1; i<nums.length; i++) if(nums[i-1] == nums[i]) return true;
		return false;
	}
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements one by one: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		twohundredandseventeen objTwohundredandseventeen = new twohundredandseventeen();
		System.out.println(objTwohundredandseventeen.containsDuplicate(nums));
		sc.close();
	}
}
