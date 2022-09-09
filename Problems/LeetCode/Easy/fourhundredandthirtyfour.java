package LeetCode.Easy;

/*

https://leetcode.com/problems/number-of-segments-in-a-string/

Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

 

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
Example 2:

Input: s = "Hello"
Output: 1
 

Constraints:

0 <= s.length <= 300
s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '.

*/

public class fourhundredandthirtyfour {
	
	public int countSegments(String s) {
		int count = 0, i = 0, j = 0, n = s.length();
		char[] s_char = s.toCharArray();
		while(j<n){
			if(s_char[i] == ' '){
				i++;
				j++;
				continue;
			}
			if(s_char[j] == ' '){
				count++;
				i = j;
			}else{
				j++;
			}
		}
		if(i != j) count++;
		return count;
	}
}
