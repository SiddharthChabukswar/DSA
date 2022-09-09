package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/hamming-distance/

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1

*/

public class fourhundredandsixtyone {

	public int hammingDistance(int x, int y) {
		int ans = 0;
		while(x!=0 || y!=0){
			if(x%2 != y%2) ans++;
			x = x>>1;
			y = y>>1;
			System.out.printf("x: %d, y: %d\n", x, y);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter int x: ");
		int x = sc.nextInt();
		System.out.print("Enter int y: ");
		int y = sc.nextInt();
		fourhundredandsixtyone objFourhundredandsixtyone = new fourhundredandsixtyone();
		System.out.printf("Answer: %d", objFourhundredandsixtyone.hammingDistance(x, y));
		sc.close();
	}

}
