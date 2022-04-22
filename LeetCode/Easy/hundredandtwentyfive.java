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

	// Naive approach O(n)
	/*
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
	*/

	// Two pointer method O(n) No extra space needed.

	public boolean isAlphaNumeric(char c){
		if(c >= 'a' && c <= 'z') return true;
		else if(c >= '0' && c <= '9') return true;
		return false;
	}

	public boolean isPalindrome(String s){
		int left = 0, slen = s.length(), right = slen-1;
		s = s.toLowerCase();
		char l_curr_char, r_curr_char;
		while(left < right){
			l_curr_char = s.charAt(left);
			r_curr_char = s.charAt(right);
			if(!isAlphaNumeric(l_curr_char)){
				left++;
				continue;
			}
			if(!isAlphaNumeric(r_curr_char)){
				right--;
				continue;
			}
			if(l_curr_char != r_curr_char) return false;
			left++;
			right--;
		}
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
