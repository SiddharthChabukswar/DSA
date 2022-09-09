package LeetCode.Easy;

import java.util.Scanner;


/*

https://leetcode.com/problems/power-of-three/

Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

 

Example 1:

Input: n = 27
Output: true
Example 2:

Input: n = 0
Output: false
Example 3:

Input: n = 9
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?

*/

public class threehundredandtwentysix {


	// Loop method O(log3(n))
	public boolean isPowerOfThree(int n) {
		if(n<1) return false;
		while(n!=1){
			if(n%3!=0) return false;
			n = n/3;
		}
		return true;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number n: ");
		int n = sc.nextInt();
		threehundredandtwentysix objThreehundredandtwentysix = new threehundredandtwentysix();
		System.out.println(objThreehundredandtwentysix.isPowerOfThree(n));
		sc.close();
	}

}
