package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/perfect-number/

A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

Given an integer n, return true if n is a perfect number, otherwise return false.

 

Example 1:

Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
Example 2:

Input: num = 7
Output: false
 

Constraints:

1 <= num <= 108

*/

public class fivehundredandseven {

	public boolean checkPerfectNumber(int num) {
		if(num == 1) return false;
		int sum = 1, sqrt_num = (int) Math.sqrt(num);
		for(int i=2; i<=sqrt_num; i++) {
			if(num%i == 0) sum += (i + (num/i));
		}
		// System.out.println(sum);
		return (sum==num)?true:false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num: ");
		int num = sc.nextInt();
		fivehundredandseven objFivehundredandseven = new fivehundredandseven();
		System.out.println(objFivehundredandseven.checkPerfectNumber(num));
		sc.close();
	}

}
