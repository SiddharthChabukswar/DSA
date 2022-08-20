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

	public int reverse(int x) {
		if(x == -2147483648) return 0;
		int answer = 0;
		Boolean isNegative = false;
		if(x<0){
			isNegative = true;
			x *= -1;
		}
		while(x!=0){
			answer *= 10;
			answer += x%10;
			x /= 10;
			if(answer < 0) return 0;
			System.out.println(answer);
		}
		if(isNegative == true) answer *= -1;
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter int x: ");
		int x = sc.nextInt();
		_7 obj_7 = new _7();
		System.out.printf("Answer: %d\n", obj_7.reverse(x));
		sc.close();
	}
	
}
