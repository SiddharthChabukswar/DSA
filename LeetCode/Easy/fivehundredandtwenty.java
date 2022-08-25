package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/detect-capital/

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.

*/

public class fivehundredandtwenty {

	/*
	public boolean detectCapitalUse(String word) {
		if(word == "") return true;
		int sum = 0;
		for(char wordChar: word.toCharArray()){
			if(wordChar < 'a') sum++;
		}
		if(sum == 0) return true;
		else if(sum == word.length()) return true;
		else if(sum == 1) return (word.charAt(0) < 'a');
		else return false;
	}
	*/

	// Regex
	public boolean detectCapitalUse(String word) {
		return word.matches("[A-Z]*|.[a-z]*");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter word: ");
		String word = sc.next();

		fivehundredandtwenty objFivehundredandtwenty = new fivehundredandtwenty();
		System.out.println(objFivehundredandtwenty.detectCapitalUse(word));
		sc.close();
	}
}
