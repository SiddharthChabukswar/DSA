package LeetCode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*

https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

public class _3 {

	// Sliding Window O(n)
	public int lengthOfLongestSubstring(String s) {
		char[] s_char_arr = s.toCharArray();
		int max_len = 0, n = s_char_arr.length, i=0, j=0;
		char curr_char;
		HashSet<Character> visited = new HashSet<Character>();
		while(j<n){
			curr_char = s_char_arr[j];
			while(visited.contains(curr_char)){
				visited.remove(s_char_arr[i++]);
			}
			visited.add(curr_char);
			max_len = Math.max(max_len, j-i+1);
		}
		return max_len;
	}


	// HashSet set previous index O(n^2)
	/*
	int[] getPreviousOccuranceArray(char[] s_char_array){
		int n = s_char_array.length, i;
		int[] prev_occ_index = new int[n];
		HashMap<Character, Integer> prev_occ_map = new HashMap<Character, Integer>();
		Integer prev_index;
		char curr_char;
		for(i=0; i<n; i++){
			curr_char = s_char_array[i];
			prev_index = prev_occ_map.get(curr_char);
			if(prev_index == null) prev_index = -1;
			prev_occ_index[i] = prev_index;
			prev_occ_map.put(curr_char, i);
		}
		return prev_occ_index;
	}

	HashSet<Character> modifyCharSet(char[] s_char_array, int end, int start){
		HashSet<Character> char_set = new HashSet<Character>();
		for(int i=start; i<end; i++) char_set.add(s_char_array[i]);
		return char_set;
	}

	public int lengthOfLongestSubstring(String s) {
		int max_len = 0, count = 0, i, n;
		char[] s_char_array = s.toCharArray();
		int[] prev_occ_index = getPreviousOccuranceArray(s_char_array);
		HashSet<Character> char_set = new HashSet<Character>();
		n = s_char_array.length;
		i = 0;
		char curr_char;
		while(i<n){
			curr_char = s_char_array[i];
			if(!char_set.contains(curr_char)){
				count++;
				char_set.add(curr_char);
			}else{
				count = i - prev_occ_index[i];
				char_set = modifyCharSet(s_char_array, i, prev_occ_index[i]);
			}
			i++;
			max_len = Math.max(count, max_len);
		}
		return max_len;
	}
	*/


	// Two loops O(n^2)
	/*
	public int lengthOfLongestSubstring(String s) {
		int max_len = 0, count = 0, i, j, n = s.length();
		HashSet<Character> visited = new HashSet<Character>();
		for(i=0; i<n; i++){
			count = 0;
			visited.clear();
			for(j=i; j<n; j++){
				Character s_char = s.charAt(j);
				if(!visited.contains(s_char)){
					visited.add(s_char);
					count++;
				}
				else break;
			}
			max_len = Math.max(max_len, count);
		}
		return max_len;
	}
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.nextLine();
		_3 obj_3 = new _3();
		System.out.println(obj_3.lengthOfLongestSubstring(s));
		sc.close();
	}
	
}
