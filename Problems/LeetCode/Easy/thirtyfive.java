package LeetCode.Easy;

// import java.util.Arrays;
import java.util.Scanner;


/*

https://leetcode.com/problems/search-insert-position/

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104

*/
public class thirtyfive {

	public int searchInsert(int[] nums, int target) {
		int answer = -1, nlen = nums.length;
		// System.out.println(Arrays.toString(nums));
		// System.out.println(target);

		// Binary search O(log(n))
		int left, right, mid;
		left = 0;
		right = nlen - 1;
		while(left <= right){
			mid = left + (right - left)/2;
			if(nums[mid] == target){
				answer = mid;
				break;
			}
			else if(nums[mid] < target){
				left = mid + 1;
			}
			else{
				right = mid - 1;
			}
		}
		if(answer == -1) answer = left;

		// System.out.printf("Answer: %d\n", answer);
		// System.out.printf("Left: %d\n", left);
		// System.out.printf("Right: %d\n", right);

		// Naive algorithm O(n)
		/*
		answer = nlen;
		for(int i=0; i<nlen; i++){
			if(nums[i] >= target){
				answer = i;
				break;
			}
		}
		*/

		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Array length: ");
		int n = sc.nextInt();
		int[] nums = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		System.out.print("Enter target: ");
		int target = sc.nextInt();
		thirtyfive objThirtyfive = new thirtyfive();
		System.out.println(objThirtyfive.searchInsert(nums, target));
		sc.close();
	}

}
