package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/counting-bits/

Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

 

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= n <= 105
 

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

*/

public class threehundredandthirtyeight {

	// Hamming code method with DP O(n)
	public int[] countBits(int n) {
		int[] answer = new int[n+1];
		answer[0] = 0;
		for(int i=1; i<=n; i++) answer[i] = 1 + answer[i&(i-1)];
		return answer;
	}
	

	// Hamming code method n&n-1 : O(nlogn)
	/*
	public int[] countBits(int n) {
		int[] answer = new int[n+1];
		answer[0] = 0;
		int i, temp, count;
		for(i=1; i<=n; i++){
			temp = i;
			count = 0;
			while(temp!=0){
				temp = temp & (temp-1);
				count++;
			}
			answer[i] = count;
		}
		return answer;
	}
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number n: ");
		int n = sc.nextInt();
		threehundredandthirtyeight objThreehundredandthirtyeight = new threehundredandthirtyeight();
		int[] answer = objThreehundredandthirtyeight.countBits(n);
		for(int ans: answer) System.out.printf("%d, ", ans);
		sc.close();
	}
}
