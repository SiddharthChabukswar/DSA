package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*

https://leetcode.com/problems/isomorphic-strings/

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

*/

public class twohundredandfive {
	
	public boolean isIsomorphic(String s, String t) {
		if(s==t) return true;
		if(s.length()!=t.length()) return false;
		HashMap<Character, Character> charMap = new HashMap<Character, Character>();
		HashSet<Character> charSet = new HashSet<Character>();
		int i, slen = s.length();
		Character value, char_s, char_t;
		for(i=0; i<slen; i++){
			char_s = s.charAt(i);
			char_t = t.charAt(i);

			value = charMap.get(char_s);
			if(value == null) {
				if(charSet.contains(char_t)) return false;
				else{
					charMap.put(char_s, char_t);
					charSet.add(char_t);
				}
			}
			else{
				if(value != char_t) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s, t;
		System.out.print("Enter string s: ");
		s = sc.next();
		System.out.print("Enter string t: ");
		t = sc.next();
		twohundredandfive objTwohundredandfive = new twohundredandfive();
		System.out.println(objTwohundredandfive.isIsomorphic(s, t));
		sc.close();
	}
}
