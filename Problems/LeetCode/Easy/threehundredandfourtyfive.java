package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/reverse-vowels-of-a-string/

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

*/

public class threehundredandfourtyfive {

	public String reverseVowels(String s) {
		String answer = "";
		int left = 0, right = s.length() - 1, i, n = s.length();
		char[] s_arr = s.toCharArray();
		char temp;
		while(left<right){
			if(!isVowel(Character.toLowerCase(s_arr[left]))){
				left++;
				continue;
			}
			if(!isVowel(Character.toLowerCase(s_arr[right]))){
				right--;
				continue;
			}
			temp = s_arr[left];
			s_arr[left] = s_arr[right];
			s_arr[right] = temp;
			left++;
			right--;
		}
		for(i=0; i<n; i++) answer += s_arr[i];
		return answer;
	}

	public Boolean isVowel(char c) {
		switch(c){
			case 'a': return true;
			case 'e': return true;
			case 'i': return true;
			case 'o': return true;
			case 'u': return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		threehundredandfourtyfive objThreehundredandfourtyfive = new threehundredandfourtyfive();
		System.out.println(objThreehundredandfourtyfive.reverseVowels(s));
		sc.close();
	}
}
