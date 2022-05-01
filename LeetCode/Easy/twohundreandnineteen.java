package LeetCode.Easy;

import java.util.HashMap;
import java.util.Scanner;

/*

https://leetcode.com/problems/contains-duplicate-ii/

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

*/

public class twohundreandnineteen {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> check_index = new HashMap<Integer, Integer>();
		Integer get_index;
		for(int i=0; i<nums.length; i++){
			get_index = check_index.get(nums[i]);
			if(get_index == null){
				check_index.put(nums[i], i);
			}else{
				if(i - get_index <= k) return true;
				else check_index.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements one by one: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		System.out.print("Enter the value of k: ");
		int k = sc.nextInt();

		twohundreandnineteen objTwohundreandnineteen = new twohundreandnineteen();
		System.out.println(objTwohundreandnineteen.containsNearbyDuplicate(nums, k));
		sc.close();
	}
	
}
