package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=check-if-strings-are-rotations-of-each-other-or-not

Given two strings s1 and s2. The task is to check if s2 is a rotated version of the string s1. The characters in the strings are in lowercase.

 

Example 1:

Input:
geeksforgeeks
forgeeksgeeks
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

	public static boolean isSubString(String input, String pattern) {
		// KMP substring search
		return true;
	}

	public static boolean areRotations(String s1, String s2) {
		if(s2.length() != s1.length()) return false;
		if(s2.equals(s1) == true) return true;
		s2 = s2+s2;
		return isSubString(s2, s1);
	}

}