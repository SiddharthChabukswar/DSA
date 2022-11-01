package GFG.Easy;

import java.util.HashMap;
import java.util.HashSet;

/*

https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=isomorphic-strings

Given two strings 'str1' and 'str2', check if these two strings are isomorphic to each other.
Two strings str1 and str2 are called isomorphic if there is a one to one mapping possible for every character of str1 to every character of str2 while preserving the order.
Note: All occurrences of every character in str1 should map to the same character in str2

Example 1:

Input:
str1 = aab
str2 = xxy
Output: 1
Explanation: There are two different
charactersin aab and xxy, i.e a and b
with frequency 2and 1 respectively.
Example 2:

Input:
str1 = aab
str2 = xyz
Output: 0
Explanation: There are two different
charactersin aab but there are three
different charactersin xyz. So there
won't be one to one mapping between
str1 and str2.
Your Task:
You don't need to read input or print anything.Your task is to complete the function areIsomorphic() which takes the string str1 and string str2 as input parameter and  check if two strings are isomorphic. The function returns true if strings are isomorphic else it returns false.

Expected Time Complexity: O(|str1|+|str2|).
Expected Auxiliary Space: O(Number of different characters).
Note: |s| represents the length of string s.

Constraints:
1 <= |str1|, |str2| <= 2*104

*/

public class Isomorphic_Strings {

	public static boolean areIsomorphic(String str1, String str2) {
		int str1len = str1.length(), str2len = str2.length();
		if(str1len != str2len) return false;
		HashMap<Character, Character> charMap = new HashMap<Character, Character>();
		HashSet<Character> charSet = new HashSet<Character>();
		Character key, value, expValue;
		for(int i=0; i<str1len; i++) {
			key = str1.charAt(i);
			expValue = str2.charAt(i);
			value = charMap.get(key);
			if(value == null) {
				if(charSet.contains(expValue) == true) return false;
				else charSet.add(expValue);
				value = expValue;
				charMap.put(key, expValue);
			}
			if(expValue != value) return false;
		}
		return true;
	}

}