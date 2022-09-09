package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/power-of-two/

Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?

*/

public class twohundredandthirtyone {

	// Loop method O(logn)
	/*
	public boolean isPowerOfTwo(int n) {
		if(n<1) return false;
		if(n==1 || n==2) return true;
		long pow = 2;
		while(pow<n){
			pow = pow*2;
		}
		if(n==pow) return true;
		return false;
	}
	*/

	// Weird Bit manipulation O(len(num))
	public boolean isPowerOfTwo(int n) {
		if(n<1) return false;
		if(n==1 || n==2) return true;
		if((n & n-1) == 0) return true;
		return false;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number 'n': ");
		int n = sc.nextInt();
		twohundredandthirtyone objTwohundredandthirtyone = new twohundredandthirtyone();
		System.out.println(objTwohundredandthirtyone.isPowerOfTwo(n));
		sc.close();
	}
	
}
