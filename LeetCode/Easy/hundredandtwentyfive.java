package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/valid-palindrome/

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

*/

public class hundredandtwentyfive {

	public boolean isPalindrome(String s) {
		int i, slen = s.length();
		String refined_s = "";
		char curr_char;
		for(i=0; i<slen; i++){
			curr_char = s.charAt(i);
			if(curr_char >= 'a' && curr_char <= 'z') refined_s = refined_s + curr_char;
			else if(curr_char >= 'A' && curr_char <= 'Z') refined_s = refined_s + (char)(curr_char - 'A' + 'a');
			else if(curr_char >= '0' && curr_char <= '9') refined_s = refined_s + curr_char;
		}
		slen = refined_s.length();
		for(i=0; i<slen/2; i++) if(refined_s.charAt(i) != refined_s.charAt(slen - 1 - i)) return false; 
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String s = sc.nextLine();
		hundredandtwentyfive objHundredandtwentyfive = new hundredandtwentyfive();
		boolean answer = objHundredandtwentyfive.isPalindrome(s);
		System.out.println(answer);
		sc.close();
	}
	
}
