package LeetCode.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/*

https://leetcode.com/problems/word-pattern/

Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.

*/

public class twohundredandninety {

	public boolean wordPattern(String pattern, String s) {
		String[] s_arr = s.split(" ");
		int plen = pattern.length(), slen = s_arr.length;
		if(plen!=slen) return false;
		String curr_string, curr_value;
		Character curr_char;
		HashMap<Character, String> char_map = new HashMap<Character, String>();
		HashSet<String> string_set = new HashSet<String>();
		for(int i=0; i<plen; i++){
			curr_char = pattern.charAt(i);
			curr_string = s_arr[i];
			curr_value = char_map.get(curr_char);
			if(curr_value == null){
				if(string_set.contains(curr_string)) return false;
				else{
					string_set.add(curr_string);
					char_map.put(curr_char, curr_string);
				}
			}
			else{
				if(curr_value.equals(curr_string) != true) return false;
			}
		}
		return true;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter pattern: ");
		String pattern = sc.next();
		sc.nextLine();
		System.out.print("Enter string s: ");
		String s = sc.nextLine();
		twohundredandninety objTwohundredandninety = new twohundredandninety();
		System.out.println(objTwohundredandninety.wordPattern(pattern, s));
		sc.close();
	}
}
