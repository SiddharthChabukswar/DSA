package GFG.Easy;

import java.util.Stack;

/*

https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=reverse-words-in-a-given-string

Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

Example 1:

Input:
S = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole
string(not individual words), the input
string becomes
much.very.program.this.like.i
Example 2:

Input:
S = pqr.mno
Output: mno.pqr
Explanation: After reversing the whole
string , the input string becomes
mno.pqr

Your Task:
You dont need to read input or print anything. Complete the function reverseWords() which takes string S as input parameter and returns a string containing the words in reversed order. Each word in the returning string should also be separated by '.' 


Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


Constraints:
1 <= |S| <= 105

*/

public class Reverse_words_in_a_given_string {

	String reverseWords(String S) {
		if(S.length() == 0) return "";
		StringBuilder currWordBuilder = new StringBuilder();
		Stack<String> wordStack = new Stack<String>();
		for(char currChar: S.toCharArray()) {
			if(currChar == '.') {
				wordStack.push(currWordBuilder.toString());
				currWordBuilder = null;
				currWordBuilder = new StringBuilder();
			} else {
				currWordBuilder.append(currChar);
			}
		}
		wordStack.push(currWordBuilder.toString());
		StringBuilder answerStringBuilder = new StringBuilder();
		while(wordStack.isEmpty() == false) {
			answerStringBuilder.append(wordStack.pop());
			answerStringBuilder.append('.');
		}
		answerStringBuilder.deleteCharAt(answerStringBuilder.length()-1);
		return answerStringBuilder.toString();
	}

}