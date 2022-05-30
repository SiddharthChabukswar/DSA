package LeetCode.Easy;

import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/repeated-substring-pattern/

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

*/

public class fourhundredandfiftynine {
	
	// Brute force: O(n^2) solution
	/*
	public boolean repeatedSubstringPattern(String s) {
		int n = s.length(), i, j, mul;
		String pattern, s2;
		for(i=1; i<=n/2; i++){
			if(n%i != 0) continue;
			mul = n/i;
			pattern = s.substring(0, i);
			s2 = "";
			for(j=0; j<mul; j++) s2 = s2 + pattern;
			// System.out.printf("Pattern: %s || S2: %s\n", pattern, s2);
			if(s2.equals(s)) return true;
		}
		return false;
	}
	*/


	// KMP Algorithm O(n) solution
	int[] KMPPatternHelper(char[] s){
		int n = s.length, i = 0, j = 1;
		int[] pattern_array = new int[n];
		pattern_array[0] = 0;
		while(j<n){
			System.out.printf("i: %d || j: %d\n", i, j);
			if(s[i] == s[j]) pattern_array[j++] = ++i;
			else{
				if(i == 0) pattern_array[j++] = 0;
				else i = pattern_array[i-1];
			}
		}
		return pattern_array;
	}

	public boolean repeatedSubstringPattern(String s) {
		int n = s.length();
		char[] s_arr = s.toCharArray();
		int[] pattern_arr = KMPPatternHelper(s_arr);
		System.out.println(Arrays.toString(pattern_arr));
		return (pattern_arr[n-1] != 0 && (n % pattern_arr[n-1] == 0));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		fourhundredandfiftynine objFourhundredandfiftynine = new fourhundredandfiftynine();
		System.out.println(objFourhundredandfiftynine.repeatedSubstringPattern(s));
		sc.close();
	}

}
