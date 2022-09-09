package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/arranging-coins/

You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

 

Example 1:


Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:


Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 

Constraints:

1 <= n <= 231 - 1

*/

public class fourhundredandfourtyone {
	
	// Binary search O(log(n))
	/*
	public int arrangeCoins(int n) {
		int left=0, right=n;
		long sum = 0, mid = 0;
		while(left<=right){
			mid = (right - left)/2 + left;
			if(mid%2 == 0) sum = (mid/2) * (mid+1);
			else sum = (mid)*((mid+1)/2);
			if(sum > n) right = (int)mid - 1;
			else left = (int)mid + 1;
			System.out.printf("left: %d || right: %d || mid: %d || sum: %d\n", left, right, mid, sum);
		}
		return right;
	}
	*/
	
	// Square root method O(1)
	public int arrangeCoins(int n) {
		return (int)(Math.sqrt(((2*(double)n) + (0.25))) - (0.5));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number n: ");
		int n = sc.nextInt();
		fourhundredandfourtyone objFourhundredandfourtyone = new fourhundredandfourtyone();
		System.out.printf("Answer: %d", objFourhundredandfourtyone.arrangeCoins(n));
		sc.close();
	}
}
