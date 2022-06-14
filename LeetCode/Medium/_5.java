package LeetCode.Medium;

import java.util.Scanner;

/* 

https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

*/

public class _5 {

	// Dynamic Programming O(n^2)
	/*
	public String longestPalindrome(String s) {
		String answer = "";
		char[] s_char_arr = s.toCharArray();
		int[][] dp_arr = createDPMatrix(s_char_arr);
		int i=0, j=0, n = s_char_arr.length;
		for(i=n-1; i>=0; i--) for(j=0; j<n-i; j++) if(dp_arr[j][j+i] == 1) return s.substring(j, j+i+1);
		return answer;
	}

	int[][] createDPMatrix(char[] s_char_arr) {
		int n = s_char_arr.length, i, j;
		int[][] dp_arr = new int[n][n];
		for(i=0; i<n; i++) for(j=0; j<n; j++) dp_arr[i][j] = 1;
		for(i=1; i<n; i++) {
			for(j=0; j<n-i; j++) {
				if(s_char_arr[j] != s_char_arr[j+i] || dp_arr[j+1][j+i-1] != 1) dp_arr[j][j+i] = 0;
				else dp_arr[j][j+i] = 1;
			}
		}
		return dp_arr;
	}
	*/


	// Expand around corner method O(n^2)
	char[] s_char_arr;
	int n;

	public String longestPalindrome(String s) {
		String answer = "";
		s_char_arr = s.toCharArray();
		n = s_char_arr.length;
		int i, even, odd, gmax = 0, l, r;
		for(i=0; i<n; i++){
			odd = expandAroundCorner(i, i);
			even = expandAroundCorner(i, i+1);
			System.out.printf("i: %d, even: %d, odd: %d\n", i, even, odd);
			if(odd > even){
				if(odd > gmax){
					l = i - odd/2;
					r = i + odd/2;
					answer = s.substring(l, r + 1);
					gmax = odd;
				}
			}else{
				if(even > gmax){
					l = i - even/2 + 1;
					r = i + even/2;
					answer = s.substring(l, r + 1);
					gmax = even;
				}
			}
		}
		return answer;
	}

	int expandAroundCorner(int left, int right){
		if(left == right) return 1 + expandAroundCorner(left-1, right+1);
		if(left < 0 || right > n-1 || s_char_arr[left] != s_char_arr[right]) return 0;
		else return 2 + expandAroundCorner(left-1, right+1);
	}


	// Brute force O(n^3) %TLE%
	/*
	public String longestPalindrome(String s) {
		String answer = "";
		int n = s.length(), i, j, max_len = 0;
		char[] s_char_arr = s.toCharArray();
		for(i=0; i<n; i++){
			for(j=0; j<n; j++){
				if(isPalindrome(s_char_arr, i, j)){
					if(max_len < j-i+1){
						max_len = j-i+1;
						answer = charArrToStr(s_char_arr, i, j);
					}
				}
			}
		}
		return answer;
	}

	Boolean isPalindrome(char[] s_char_arr, int start, int end) {
		while(start < end){
			if(s_char_arr[start] != s_char_arr[end]) return false;
			start++;
			end--;
		}
		return true;
	}

	String charArrToStr(char[] s_char_arr, int start, int end) {
		String answer = "";
		while(start <= end) answer += s_char_arr[start++];
		return answer;
	}
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		_5 obj_5 = new _5();
		System.out.printf("Answer: %s\n", obj_5.longestPalindrome(s));
		sc.close();
	}
}
