package LeetCode.Easy;

import java.util.Scanner;

/*

Given two strings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

*/

public class threehundredandeightythree {
	
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] countChar = new int[26];
		for(char m: magazine.toCharArray()) countChar[m - 'a']++;
		for(char r: ransomNote.toCharArray()){
			if(countChar[r - 'a'] == 0) return false;
			countChar[r - 'a']--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ransom note: ");
		String ransomNote = sc.next();
		System.out.print("Enter magazine: ");
		String magazine = sc.next();
		threehundredandeightythree objThreehundredandeightythree = new threehundredandeightythree();
		System.out.println(objThreehundredandeightythree.canConstruct(ransomNote, magazine));
		sc.close();
	}
}
