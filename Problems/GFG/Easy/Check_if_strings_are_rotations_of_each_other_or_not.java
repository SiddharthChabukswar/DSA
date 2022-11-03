package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=check-if-strings-are-rotations-of-each-other-or-not

Given two strings s1 and s2. The task is to check if s2 is a rotated version of the string s1. The characters in the strings are in lowercase.

 

Example 1:

Input:
geeksforgeeks
forgeeksgeeksforgeeksgeeks
Output: 
1
Explanation: s1 is geeksforgeeks, s2 is
forgeeksgeeks. Clearly, s2 is a rotated
version of s1 as s2 can be obtained by
left-rotating s1 by 5 units.
 

Example 2:

Input:
mightandmagic
andmagicmigth
Output: 
0
Explanation: Here with any amount of
rotation s2 can't be obtained by s1.
 

Your Task:
The task is to complete the function areRotations() which checks if the two strings are rotations of each other. The function returns true if string 1 can be obtained by rotating string 2, else it returns false.

 

Expected Time Complexity: O(N).
Expected Space Complexity: O(N).
Note: N = |s1|.

 

Constraints:
1 <= |s1|, |s2| <= 107

*/

public class Check_if_strings_are_rotations_of_each_other_or_not {

	static int[] getPrefixSuffixArr(String pattern) {
		int n = pattern.length(), i, j;
		int[] prefixSuffixArr = new int[n];
		prefixSuffixArr[0] = 0;
		i = 1;
		j = 0;
		while(i<n) {
			if(pattern.charAt(i) == pattern.charAt(j)) prefixSuffixArr[i++] = ++j;
			else if(j==0) prefixSuffixArr[i++] = 0;
			else j = prefixSuffixArr[j-1];
		}
		return prefixSuffixArr;
	}

	public static boolean isSubString(String text, String pattern) {
		int[] prefixSuffixArr = getPrefixSuffixArr(pattern);
		int textLen = text.length(), patternLen = pattern.length(), i = 0, j = 0;
		while(i<textLen) {
			if(text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else if(j==0) {
				i++;
			}
			else {
				j = prefixSuffixArr[j-1];
			}
			if(j == patternLen) return true;
		}
		return false;
	}

	public static boolean areRotations(String s1, String s2) {
		if(s2.length() != s1.length()) return false;
		if(s2.equals(s1) == true) return true;
		s2 = s2+s2;
		return isSubString(s2, s1);
	}

}