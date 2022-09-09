package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/add-digits/

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.
Example 2:

Input: num = 0
Output: 0
 

Constraints:

0 <= num <= 231 - 1
 

Follow up: Could you do it without any loop/recursion in O(1) runtime?

*/

public class twohundredandfiftyeight {

	// Naive approach O(n)
	/*
	public int addDigits(int num) {
		int sum = 0;
		while(num>9){
			sum = 0;
			while(num!=0){
				sum += num%10;
				num /= 10;
			}
			num = sum;
		}
		return num;
	}
	*/


	// Finding pattern on paper O(1)
	public int addDigits(int num) {
		if(num == 0) return 0;
		num = num % 9;
		if(num == 0) num = 9;
		return num;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		twohundredandfiftyeight objTwohundredandfiftyeight = new twohundredandfiftyeight();
		System.out.println(objTwohundredandfiftyeight.addDigits(num));
		sc.close();
	}
}
