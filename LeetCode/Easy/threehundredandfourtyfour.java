package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/reverse-string/

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.

*/

public class threehundredandfourtyfour {

	public void reverseString(char[] s) {
		int n = s.length;
		char temp;
		for(int i=0; i<n/2; i++){
			temp = s[i];
			s[i] = s[n-1-i];
			s[n-1-i] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String inp = sc.next();
		char[] s = inp.toCharArray();
		threehundredandfourtyfour objThreehundredandfourtyfour = new threehundredandfourtyfour();
		objThreehundredandfourtyfour.reverseString(s);
		for(char s_char: s) System.out.print(s_char);
		sc.close();	
	}

}
