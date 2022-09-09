package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/convert-a-number-to-hexadecimal/

405. Convert a Number to Hexadecimal

Given an integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.

All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

 

Example 1:

Input: num = 26
Output: "1a"
Example 2:

Input: num = -1
Output: "ffffffff"
 

Constraints:

-231 <= num <= 231 - 1

*/


public class fourhundredandfive {

	public String toHex(int num) {
		long n = (long)num;
		if(n == 0) return "0";
		if(n < 0) n += 4294967296L;
		String answer = "";
		String hexString = "0123456789abcdef";
		long rem;
		while(n!=0){
			rem = n%16L;
			answer = hexString.charAt((int)rem) + answer;
			n /= 16;
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num: ");
		int num = sc.nextInt();
		fourhundredandfive objFourhundredandfive = new fourhundredandfive();
		System.out.println(objFourhundredandfive.toHex(num));
		sc.close();
	}

}