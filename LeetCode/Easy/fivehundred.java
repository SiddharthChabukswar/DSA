package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*

https://leetcode.com/problems/keyboard-row/

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 

*/

public class fivehundred {
	
	public String[] findWords(String[] words) {
		List<String> ans_list = new ArrayList<String>();
		int i, n, check;
		char[] curr_arr;
		String fr = "qwertyuiop", sr = "asdfghjkl", tr = "zxcvbnm";
		HashMap<Character, Integer> keyboard_map = new HashMap<Character, Integer>();
		for(Character c: fr.toCharArray()){
			keyboard_map.put(c, 1);
			keyboard_map.put(Character.toUpperCase(c), 1);
		}
		for(Character c: sr.toCharArray()){
			keyboard_map.put(c, 2);
			keyboard_map.put(Character.toUpperCase(c), 2);
		}
		for(Character c: tr.toCharArray()){
			keyboard_map.put(c, 3);
			keyboard_map.put(Character.toUpperCase(c), 3);
		}

		for(String curr: words){
			curr_arr = curr.toCharArray();
			n = curr_arr.length;
			check = keyboard_map.get(curr_arr[0]);
			for(i=0; i<n; i++) if(keyboard_map.get(curr_arr[i]) != check) break;
			if(i==n) ans_list.add(curr);
		}
		
		n = ans_list.size();
		String[] answer = new String[n];
		for(i=0; i<n; i++) answer[i] = ans_list.get(i);
		return answer;
	}

}
