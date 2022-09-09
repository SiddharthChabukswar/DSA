package LeetCode.Easy;

// import java.util.Arrays;
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

abcxabcdabxabcdabcdabcy
abcdabcy

*/


public class twentyeight {
	
	public int[] find_prefix_array(String needle){
		int nlen = needle.length(), i = 1, j = 0;
		int[] prefix_array = new int[nlen];
		prefix_array[0] = 0;
		for(i=1; i<nlen; i++){
			if(needle.charAt(i) == needle.charAt(j)){
				prefix_array[i] = ++j;
			}
			else{
				if(j == 0){
					prefix_array[i] = 0;
				}
				else{
					j = prefix_array[j-1];
					i--;
				}
			}
		}
		return prefix_array;
	}

	public int strStr(String haystack, String needle) {
		int answer = -1;
		if(needle.length() == 0) answer = 0;
		else{
			int hlen = haystack.length(), nlen = needle.length(), i = 0, j = 0;
			
			// KMP pattern search algorithm O(n+m)
			int[] prefix_array = this.find_prefix_array(needle);
			// System.out.println(Arrays.toString(prefix_array));
			for(i=0; i<hlen; i++){
				if(haystack.charAt(i) == needle.charAt(j)){
					j++;
					if(j == nlen){
						answer = i - nlen + 1;
						break;
					}
				}
				else{
					if(j == 0){
						continue;
					}
					else{
						j = prefix_array[j-1];
						i--;
					}
				}
			}

			// Brute force substring search O(n^2)
			/*
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
			*/

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
