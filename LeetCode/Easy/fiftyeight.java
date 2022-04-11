package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/length-of-last-word/

Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.

*/

public class fiftyeight {

	public int lengthOfLastWord(String s) {
		int answer = 0, slen = s.length(), i;
		for(i=slen-1; i>=0; i--){
			if(s.charAt(i) == ' '){
				if(answer != 0) break;
			}
			else answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		fiftyeight objFiftyeight = new fiftyeight();
		System.out.println(objFiftyeight.lengthOfLastWord(s));
		sc.close();	
	}

}
