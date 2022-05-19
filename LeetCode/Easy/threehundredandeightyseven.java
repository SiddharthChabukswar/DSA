package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

*/

public class threehundredandeightyseven {
	
	public int firstUniqChar(String s) {
		int[] charCount = new int[26];
		for(char s_char: s.toCharArray()) charCount[s_char - 'a']++;
		for(int i=0; i<s.length(); i++) if(charCount[s.charAt(i) - 'a'] == 1) return i;
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter string s: ");
		String s = sc.next();
		threehundredandeightyseven objThreehundredandeightyseven = new threehundredandeightyseven();
		System.out.println(objThreehundredandeightyseven.firstUniqChar(s));
		sc.close();
	}

}
