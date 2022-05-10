package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*

https://leetcode.com/problems/valid-anagram/

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

*/

public class twohundredandfourtytwo {

	// HashMap : O(n)
	/*
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		int slen = s.length(), tlen = t.length(), i;
		Integer count;
		Character curr;
		HashMap<Character, Integer> char_map = new HashMap<Character, Integer>();
		for(i=0; i<slen; i++){
			curr = s.charAt(i);
			count = char_map.get(curr);
			if(count == null) count = 0;
			char_map.put(curr, count+1);
		}
		for(i=0; i<tlen; i++){
			curr = t.charAt(i);
			count = char_map.get(curr);
			if(count == null || count == 0) return false;
			char_map.put(curr, count-1);
		}
		return true;
	}
	*/

	// ArrayMap : O(n)
	public boolean isAnagram(String s, String t){
		if(s.length() != t.length()) return false;
		int[] arr_map = new int[26];
		for(char curr: s.toCharArray()) arr_map[curr - 'a']++;
		for(char curr: t.toCharArray()) arr_map[curr - 'a']--;
		for(int i=0; i<26; i++) if(arr_map[i] != 0) return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s, t;
		System.out.print("Enter string s: ");
		s = sc.next();
		System.out.print("Enter string t: ");
		t = sc.next();
		twohundredandfourtytwo objTwohundredandfourtytwo = new twohundredandfourtytwo();
		System.out.println(objTwohundredandfourtytwo.isAnagram(s, t));
		sc.close();
	}
	
}
