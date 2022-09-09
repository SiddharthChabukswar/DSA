package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/palindrome-number/

Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 
*/


public class nine {
	
	public boolean isPalindrome(int x) {
		Boolean answer = false;
		if(x<0 || (x%10 == 0 && x!=0)) return answer;
		
		int number = x, numberInv = 0;
		
		// Basic full number reversal O(n)
		/*
		while(number > 0){
			numberInv = (numberInv*10) + (number%10);
			number = number/10;
		}
		if((x-numberInv) == 0) answer = true;
		*/

		//Optimized half number reversal O(n/2)
		while(number > numberInv){
			numberInv = (numberInv*10) + (number%10);
			number = number/10;
		}
		if((number == numberInv) || (number == (numberInv/10))) answer = true;
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		nine objNine = new nine();
		System.out.print(objNine.isPalindrome(x));
		sc.close();
	}
}
