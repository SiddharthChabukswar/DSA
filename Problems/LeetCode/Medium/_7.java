package LeetCode.Medium;

import java.util.Scanner;

/*

https://leetcode.com/problems/reverse-integer/

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1

*/

public class _7 {

	// check overflow
	public int reverse(int x) {
		int answer = 0, rem = 0;
		while(x!=0) {
			rem = x%10;
			x /= 10;
			if((answer > Integer.MAX_VALUE/10) || ((answer == Integer.MAX_VALUE/10) && (rem > 7))) return 0;
			if((answer < Integer.MIN_VALUE/10) || ((answer == Integer.MIN_VALUE/10) && (rem < -8))) return 0;
			answer = answer*10 + rem;
		}
		return answer;
	}

	// String approach
	/*
	private int convertStringtoInteger(String x_string, boolean isXNegative) {
		int x = 0, i=0;
		for(i=0; i<x_string.length()-1; i++) {
			x += (x_string.charAt(i) - '0');
			x *= 10;
		}
		if(isXNegative) {
			x *= -1;
			x -= (x_string.charAt(i) - '0');
		}else {
			x += (x_string.charAt(i) - '0');
		}
		return x;
	}

	private boolean compareStrings(String x_string, String compare_string) {
		if(x_string.length() != compare_string.length()) return true;
		for(int i=0; i<x_string.length(); i++) {
			if(x_string.charAt(i) == compare_string.charAt(i)) continue;
			else if(x_string.charAt(i) > compare_string.charAt(i)) return false;
			else return true;
		}
		return true;
	}

	public int reverse(int x) {
		if(x == Integer.MIN_VALUE) return 0;
		if(x>=-11 && x<=11) return x;
		boolean isXNegative = false;
		if(x<0) {
			isXNegative = true;
			x *= -1;
		}
		int answer = 0;
		StringBuilder x_stringBuilder = new StringBuilder();
		while(x!=0) {
			x_stringBuilder.append((char)((x%10) + '0'));
			x /= 10;
		}
		String x_string = x_stringBuilder.toString();
		System.out.println(x_string);
		if(isXNegative) {
			if(!compareStrings(x_string, "214748364")) return 0;
			answer = convertStringtoInteger(x_string, true);
		}else {
			if(!compareStrings(x_string, "2147483647")) return 0;
			answer = convertStringtoInteger(x_string, false);
		}
		return answer;
	}
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter int x: ");
		int x = sc.nextInt();
		_7 obj_7 = new _7();
		System.out.printf("Answer: %d\n", obj_7.reverse(x));
		sc.close();
	}
	
}
