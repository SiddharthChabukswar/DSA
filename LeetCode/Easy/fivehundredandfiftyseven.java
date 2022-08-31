package LeetCode.Easy;

/*

https://leetcode.com/problems/reverse-words-in-a-string-iii/

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 

Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.

*/

import java.util.Scanner;
// import java.util.Stack;

public class fivehundredandfiftyseven {

	// Slow answer (Because I have to iterate through Stack?)
	/*
	public String reverseWords(String s) {
		StringBuilder answerBuilder = new StringBuilder();
		Stack<Character> charStack = new Stack<Character>();
		for(Character curr_char: s.toCharArray()) {
			if(curr_char == ' ') {
				while(charStack.isEmpty() == false) {
					answerBuilder.append(charStack.pop());
				}
				answerBuilder.append(' ');
			} else {
				charStack.push(curr_char);
			}
		}
		while(charStack.isEmpty() == false) {
			answerBuilder.append(charStack.pop());
		}
		return answerBuilder.toString();
	}
	*/

	public String reverseWords(String s) {
		StringBuilder answerBuilder = new StringBuilder();
		StringBuilder wordBuilder = new StringBuilder();
		for(Character curr_char: s.toCharArray()) {
			if(curr_char == ' ') {
				answerBuilder.append(wordBuilder.reverse().toString() + " ");
				wordBuilder = new StringBuilder();
			} else {
				wordBuilder.append(curr_char);
			}
		}
		answerBuilder.append(wordBuilder.reverse().toString());
		return answerBuilder.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.nextLine();
		System.out.println(new fivehundredandfiftyseven().reverseWords(s));
		sc.close();
	}

}
