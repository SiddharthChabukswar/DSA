package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-palindrome-in-a-string

Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).


Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".
Example 2:

Input: 
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the 
longest palindromes with same length.
The result is the one with the least
starting index.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input and returns the longest palindromic substring of S.


Expected Time Complexity: O(|S|2).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ |S| ≤ 103

*/

public class Longest_Palindrome_in_a_String {

	static String expandAroundCentre(String s, int left, int right) {
		int slen = s.length();
		while(left >= 0 && right < slen && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		left++;
		if(left >= right) return "";
		return s.substring(left, right);
	}

	static String longestPalin(String s) {
		String answerString = "", evenPalindrome = "", oddPalindrome = "", currMaxString = "";
		int slen = s.length();
		for(int i=0; i<slen; i++) {
			evenPalindrome = expandAroundCentre(s, i, i+1);
			oddPalindrome = expandAroundCentre(s, i-1, i+1);
			System.out.println(evenPalindrome + " - " + oddPalindrome);
			currMaxString = (evenPalindrome.length() > oddPalindrome.length())?evenPalindrome:oddPalindrome;
			answerString = (currMaxString.length() > answerString.length())?currMaxString:answerString;
		}
		return answerString;
	}

}