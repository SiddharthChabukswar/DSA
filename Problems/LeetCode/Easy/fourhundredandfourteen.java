package LeetCode.Easy;

// import java.util.Arrays;
import java.util.HashSet;
// import java.util.Set;

/*

https://leetcode.com/problems/third-maximum-number/

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Can you find an O(n) solution?

*/

public class fourhundredandfourteen {

	// Sorting the array O(nlogn)
	/*
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);
		HashSet<Integer> nums_set = new HashSet<Integer>();
		for(int i=nums.length-1; i>=0; i--){
			if(nums_set.contains(nums[i])) continue;
			else nums_set.add(nums[i]);
			if(nums_set.size() == 3) return nums[i];
		}
		return nums[nums.length-1];
	}
	*/
	
	// Traversing the array three times O(3*n)
	/*
	public int thirdMax(int[] nums) {
		int fdm, sdm;
		int i, max = Integer.MIN_VALUE;
		for(i=0; i<nums.length; i++) if(nums[i] > max) max = nums[i];
		fdm = max;
		max = Integer.MIN_VALUE;
		for(i=0; i<nums.length; i++){
			if(nums[i] == fdm) continue;
			else if(nums[i] > max) max = nums[i];
		}
		if(max == Integer.MIN_VALUE) return fdm;
		sdm = max;
		max = Integer.MIN_VALUE;
		Boolean changed = false;
		for(i=0; i<nums.length; i++){
			if(nums[i] == fdm || nums[i] == sdm) continue;
			else if(nums[i] > max){
				max = nums[i];
				changed = true;
			}
		}
        if(changed!=true) return fdm;
		return max;
	}
	*/

	public int thirdMax(int[] nums) {
		Integer max1 = null, max2 = null, max3 = null;
		HashSet<Integer> num_set = new HashSet<Integer>();
		for(Integer num: nums){
			if(num_set.contains(num)) continue;
			if(max1 == null || num > max1){
				max3 = max2;
				max2 = max1;
				max1 = num;
			}else if(max2 == null || num > max2){
				max3 = max2;
				max2 = num;
			}else if(max3 == null || num > max3){
				max3 = num;
			}
			num_set.add(num);
		}
		if(max3 == null) return max1;
		return max3;
	}
}
