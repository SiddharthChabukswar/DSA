package LeetCode.Easy;

import java.util.Scanner;

/*

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.

*/

public class twohundredandsixtyeight {

	public int missingNumber(int[] nums) {
		int n = nums.length, sum = 0;
		int expected_ans = (n * (n+1))/2;
		for(int i=0; i<n; i++) sum += nums[i];
		return expected_ans - sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of nums: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		twohundredandsixtyeight objTwohundredandsixtyeight = new twohundredandsixtyeight();
		System.out.print(objTwohundredandsixtyeight.missingNumber(nums));
		sc.close();
	}
	
}
