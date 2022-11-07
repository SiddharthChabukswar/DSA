package GFG.Medium;

import java.util.HashSet;

/*

https://practice.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sum-of-beauty-of-all-substrings

Given a string S, return the sum of beauty of all its substrings.
The beauty of a string is defined as the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of string "aaac" is 3 - 1 = 2.
Example 1:

Input:
S = "aaac"
Output:
3
Explanation: The substrings with non - zero beauty are ["aaac","aac"] where beauty of "aaac" is 2 and beauty of "aac" is 1.
 

Example 2:

Input:
S = "geeksforgeeks"
Output:
62
Your Task:
You don't need to read input or print anything. Your task is to complete the function beautySum() which takes string S as input paramters and returns the sum of beauty of all its substrings. 

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(1)

Constraints: 
1 ≤ |S| ≤ 500
S only contains lower case alphabets.

*/

public class Sum_of_Beauty_of_All_Substrings {

	public static int beautySum(String s) {
		int sum = 0, slen = s.length(), i, j;
		char curr_char, max_char, min_char;
		int[] charMap;
		HashSet<Character> occuredChars;
		for(i=0; i<slen; i++) {
			charMap = null;
			occuredChars = null;
			charMap = new int[26];
			occuredChars = new HashSet<>();
			max_char = s.charAt(i);
			min_char = s.charAt(i);
			for(j=i; j<slen; j++) {
				curr_char = s.charAt(j);
				occuredChars.add(curr_char);
				charMap[curr_char - 'a']++;
				if(charMap[curr_char - 'a'] >= charMap[max_char - 'a']) max_char = curr_char;
				for(Character key: occuredChars) if(charMap[key - 'a'] < charMap[min_char - 'a']) min_char = key;
				sum += (charMap[max_char - 'a'] - charMap[min_char - 'a']);
			}
		}
		return sum;
	}

}