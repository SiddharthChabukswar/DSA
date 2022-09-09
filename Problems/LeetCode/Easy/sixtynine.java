package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/sqrtx/

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1

*/



public class sixtynine {
	
	public int mySqrt(int x) {
		int answer = 0;
		
		// Binary Search O(logn)
		long left = 0, right = x/2, mid, square;
		while(left <= right){
			mid = (right - left)/2 + left;
			square = mid * mid;
			// System.out.printf("Mid: %d  ||  Square: %d\n", mid, square);
			if(square == x){
				right = mid;
				break;
			}
			else if(square > x) right = mid - 1;
			else left = mid + 1;
		}
		answer = (int)right;

		// Naive O(n) TLE
		/*
		for(long i=x/2; i>=0; i--){
			if((i*i) <= x){
				answer = (int)i;
				break;
			}
		}
		*/
		
		if(x==1) answer = 1;
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int x = sc.nextInt();
		sixtynine objSixtynine = new sixtynine();
		System.out.println(objSixtynine.mySqrt(x));
		sc.close();
	}

}
