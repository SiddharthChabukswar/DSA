package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

https://leetcode.com/problems/summary-ranges/

You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.

*/

public class twohundredandtwentyeight {
	
	public List<String> summaryRanges(int[] nums) {
		List<String> answer = new ArrayList<String>();
		String curr = "";
		int i=0, j=1, n=nums.length;
		if(n == 0) return answer;
		while(j<n){
			if((nums[j] - nums[j-1]) != 1){
				curr = new String();
				if(i==j-1) curr = String.valueOf(nums[i]);
				else curr = String.valueOf(nums[i]) + "->" + String.valueOf(nums[j-1]);
				answer.add(curr);
				i = j;
			}
			j++;
		}
		curr = new String();
		if(i==j-1) curr = String.valueOf(nums[i]);
		else curr = String.valueOf(nums[i]) + "->" + String.valueOf(nums[j-1]);
		answer.add(curr);
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of input array: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		System.out.println("Enter array elements one by one: ");
		for(int i=0; i<n; i++) nums[i] = sc.nextInt();
		twohundredandtwentyeight objTwohundredandtwentyeight = new twohundredandtwentyeight();
		List<String> answer = objTwohundredandtwentyeight.summaryRanges(nums);
		for(String ans: answer) System.out.println(ans);
		sc.close();
	}
}
