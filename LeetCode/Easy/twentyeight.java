package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/implement-strstr/

Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

*/


public class twentyeight {
	
	public int strStr(String haystack, String needle) {
		int answer = -1;
		if(needle.length() == 0) answer = 0;
		else{
			int hlen = haystack.length(), nlen = needle.length(), i = 0, j = 0;

			
			
			// Brute force substring search O(n^2)
			for(i=0; i<hlen; i++){
				if(haystack.charAt(i) == needle.charAt(0)){
					j = 1;
					while(j<nlen && j+i<hlen){
						if(haystack.charAt(i+j) != needle.charAt(j)) break;
						j++;
					}
					if(j == nlen){
						answer = i;
						break;
					}
				}
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String haystack = sc.next();
		String needle = sc.next();
		twentyeight objTwentyeight = new twentyeight();
		System.out.println(objTwentyeight.strStr(haystack, needle));
		sc.close();
	}

}
