package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*

https://leetcode.com/problems/is-subsequence/

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

*/

public class threehundredandninetytwo {

	// Two pointer method: O(s+t)
	/*
	public boolean isSubsequence(String s, String t) {
		int i=0, j=0, slen = s.length(), tlen = t.length();
		while(i<slen && j<tlen){
			if(s.charAt(i) == t.charAt(j)){
				i++;
				j++;
			}
			else j++;
		}
		if(i!=slen) return false;
		return true;
	}
	*/

	// Dynamic Programming: O(s + tlogt)
	HashMap<Character, List<Integer>> processT(String t) {
		HashMap<Character, List<Integer>> answer_map = new HashMap<Character, List<Integer>>();
		List<Integer> curr;
		int i, tlen = t.length();
		char t_char;
		for(i=0; i<tlen; i++) {
			t_char = t.charAt(i);
			curr = answer_map.get(t_char);
			if(curr == null) curr = new ArrayList<Integer>();
			curr.add(i);
			answer_map.put(t_char, curr);
		}
		return answer_map;
	}

	public boolean isSubsequence(String s, String t) {
		HashMap<Character, List<Integer>> t_map = processT(t);
		List<Integer> curr;
		int curr_low = -1, left, right, mid, k;
		for(char s_char: s.toCharArray()){
			curr = t_map.get(s_char);
			if(curr == null) return false;
			// System.out.println(s_char);
			// System.out.println(curr_low);
			// System.out.println(curr.toString());
			left = 0;
			right = curr.size()-1;
			while(left <= right){
				mid = (right - left)/2 + left;
				k = curr.get(mid);
				if(k > curr_low) right = mid-1;
				else left = mid+1;
			}
			if(left>=curr.size() || curr_low > curr.get(left)) return false;
			curr_low = curr.get(left);
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		System.out.print("Enter string t: ");
		String t = sc.next();
		threehundredandninetytwo objThreehundredandninetytwo = new threehundredandninetytwo();
		System.out.println(objThreehundredandninetytwo.isSubsequence(s, t));
		sc.close();
	}

}
