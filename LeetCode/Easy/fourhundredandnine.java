package LeetCode.Easy;

// import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
// import java.util.Set;


/*

https://leetcode.com/problems/longest-palindrome/

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

*/

public class fourhundredandnine {

	// Efficient HashSet solution O(n)
	public int longestPalindrome(String s) {
		HashSet<Character> char_set = new HashSet<Character>();
		int count = 0;
		for(Character s_char: s.toCharArray()){
			if(char_set.contains(s_char) == true){
				count++;
				char_set.remove(s_char);
			}else{
				char_set.add(s_char);
			}
		}
		if(char_set.isEmpty() == true) return count*2;
		else return count*2 + 1;
	}

	// HashMap solution O(n)
	/*
	public int longestPalindrome(String s) {
		int answer = 0, i, temp, temp2, temp3;
		HashMap<Character, Integer> char_map = new HashMap<Character, Integer>();
		Set<Character> char_set;
		for(i=0; i<26; i++){
			char_map.put((char)('a'+ i), 0);
			char_map.put((char)('A'+ i), 0);
		}
		char_set = char_map.keySet();
		System.out.println(char_set.toString());
		for(Character curr_char: s.toCharArray()){
			temp = char_map.get(curr_char);
			char_map.put(curr_char, temp+1);
		}
		temp = 0;
		for(Character curr_char: char_set){
			temp3 = char_map.get(curr_char);
			temp2 = temp3%2;
			temp += temp2;
			answer += temp3 - temp2;
		}
		if(temp != 0) answer++;
		return answer;
	}
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		fourhundredandnine objFourhundredandnine = new fourhundredandnine();
		System.out.println(objFourhundredandnine.longestPalindrome(s));
		sc.close();	
	}

}
