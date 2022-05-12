package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/power-of-four/

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?

*/

public class threehundredandfourtytwo {
	
	// Iterative solution
	/*
	public boolean isPowerOfFour(int n) {
		if(n<1) return false;
		while(n!=1){
			if(n%4!=0) return false;
			n = n/4;
		}
		return true;
	}
	*/

	// Mathematics
	/*
	public boolean isPowerOfFour(int n) {
		if(n<1) return false;
		return (Math.log10(n)/Math.log10(4) % 1 == 0);
	}
	*/

	// Compute the limits
	public boolean isPowerOfFour(int n) {
		switch(n){
			case 1: return true;
			case 4: return true;
			case 16: return true;
			case 64: return true;
			case 256: return true;
			case 1024: return true;
			case 4096: return true;
			case 16384: return true;
			case 65536: return true;
			case 262144: return true;
			case 1048576: return true;
			case 4194304: return true;
			case 16777216: return true;
			case 67108864: return true;
			case 268435456: return true;
			case 1073741824: return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number n: ");
		int n = sc.nextInt();
		threehundredandfourtytwo objThreehundredandfourtytwo = new threehundredandfourtytwo();
		System.out.println(objThreehundredandfourtytwo.isPowerOfFour(n));
		sc.close();
	}
}
