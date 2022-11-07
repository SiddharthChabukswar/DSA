package LeetCode.Medium;

import java.util.HashMap;

/*

https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

1781. Sum of Beauty of All Substrings
Medium

The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of "abaacc" is 3 - 1 = 2.
Given a string s, return the sum of beauty of all of its substrings.

 

Example 1:

Input: s = "aabcb"
Output: 5
Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
Example 2:

Input: s = "aabcbaa"
Output: 17
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.

*/

public class _1781 {

	public int beautySum(String s) {
		int slen = s.length(), i = 0, j = 0, sum = 0;
		Character curr_char, max_char, min_char;
		HashMap<Character, Integer> charMap;
		Integer val;
		for(i=0; i<slen; i++) {
			charMap = null;
			charMap = new HashMap<Character, Integer>();
			max_char = s.charAt(i);
			min_char = s.charAt(i);
			for(j=i; j<slen; j++) {
				curr_char = s.charAt(j);
				val = charMap.get(curr_char);
				if(val == null) val = 0;
				charMap.put(curr_char, ++val);
				if(charMap.get(curr_char) > charMap.get(max_char)) max_char = curr_char;
				for(Character key: charMap.keySet()) min_char = (charMap.get(key) < charMap.get(min_char))?key:min_char;
				sum += (charMap.get(max_char) - charMap.get(min_char));
			}
		}
		return sum;
	}
	
}
