package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/reverse-string-ii/

Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
 

Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104

*/

public class fivehundredandfourtyone {
	
	public String reverseStr(String s, int k) {
		if(k == 1 || s.length() == 1) return s;
		StringBuilder answer = new StringBuilder();
		String choppedString = "";
		int endIndex = (s.length()/k)*k, i = 0;
		choppedString = s.substring(0, endIndex);
		Boolean toReverse = true;
		while(i < choppedString.length()){
			if(toReverse) {
				answer.append(new StringBuilder().append(choppedString.substring(i, i+k)).reverse().toString());
			}else{
				answer.append(choppedString.substring(i, i+k));
			}
			toReverse = !toReverse;
			i += k;
		}
		if(i<s.length()){
			if(toReverse){
				answer.append(new StringBuilder().append(s.substring(i, s.length())).reverse().toString());
			}else{
				answer.append(s.substring(i, s.length()));
			}
		}
		return answer.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		System.out.print("Enter int k: ");
		int k = sc.nextInt();
		System.out.println(new fivehundredandfourtyone().reverseStr(s, k));
		sc.close();
	}


}
