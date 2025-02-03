package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/palindrome-partitioning/description/

Given a string s, partition s such that every 
substring
 of the partition is a 
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/
public class _131 {

	private boolean isPalindrome(final String s, int startIdx, int endIdx) {
		if (startIdx >= s.length() || endIdx >= s.length() || startIdx > endIdx || startIdx < 0 || endIdx < 0) return false;
		while (startIdx < endIdx) {
			if (s.charAt(startIdx) != s.charAt(endIdx)) {
				return false;
			}
			startIdx++;
			endIdx--;
		}
		return true;
	}

	private void recursivePalindromePartitioning(final String s, final int idx, final List<List<String>> palindromeSubstrings, final List<String> currList) {
		if (idx == s.length()) {
			palindromeSubstrings.add(new ArrayList<>(currList));
			return;
		}
		for (int i=idx; i<s.length(); i++) {
			if (isPalindrome(s, idx, i)) {
				currList.add(s.substring(idx, i+1));
				recursivePalindromePartitioning(s, i+1, palindromeSubstrings, currList);
				currList.remove(currList.size()-1);
			}
		}
	}

	public List<List<String>> partition(String s) {
		List<List<String>> palindromeSubstrings = new ArrayList<>();
		recursivePalindromePartitioning(s, 0, palindromeSubstrings, new ArrayList<>());
		return palindromeSubstrings;
	}
}
