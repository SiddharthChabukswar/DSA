package GFG.Easy;

import java.util.HashMap;

/*

Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other.

Example 1:

Input:a = geeksforgeeks, b = forgeeksgeeks
Output: YES
Explanation: Both the string have same characters with
        same frequency. So, both are anagrams.
Example 2:

Input:a = allergy, b = allergic
Output: NO
Explanation: Characters in both the strings are 
        not same, so they are not anagrams.
Your Task:
You don't need to read input or print anything. Your task is to complete the function isAnagram() which takes the string a and string b as input parameter and check if the two strings are an anagram of each other. The function returns true if the strings are anagram else it returns false.

Note: In python, you have to return True or False.

Expected Time Complexity:O(|a|+|b|).
Expected Auxiliary Space:O(Number of distinct characters).

Note: |s| represents the length of string s.

Constraints:
1 ≤ |a|,|b| ≤ 105

*/

public class Anagram {

	public static boolean isAnagram(String a, String b) {
		int alen = a.length(), blen = b.length();
		if(alen != blen) return false;
		if(a.equals(b) == true) return true;
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		Character key;
		Integer value;
		for(int i=0; i<alen; i++) {
			key = a.charAt(i);
			value = charMap.get(key);
			if(value == null) value = 0;
			charMap.put(key, ++value);
		}
		for(int i=0; i<blen; i++) {
			key = b.charAt(i);
			value = charMap.get(key);
			if(value == null || value == 0) return false;
			charMap.put(key, --value);
		}
		return true;
	}

}