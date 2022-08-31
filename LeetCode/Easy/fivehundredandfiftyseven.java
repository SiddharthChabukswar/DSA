package LeetCode.Easy;

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
