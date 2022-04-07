package LeetCode.Easy;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;

/*

https://leetcode.com/problems/valid-parentheses/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/

public class twenty {

	public boolean isValid(String s) {
		boolean answer = false;
		int slength = s.length();
		HashMap<Character, Character> charMap = new HashMap<Character, Character>();
		charMap.put(')', '(');
		charMap.put('}', '{');
		charMap.put(']', '[');

		//Java Stack implementation O(n)
		Stack<Character> charStack = new Stack<Character>();
		char currChar;
		int i;
		for(i=0; i<slength; i++){
			currChar = s.charAt(i);
			if(currChar == ')' || currChar == '}' || currChar == ']'){
				if(charStack.isEmpty() == true) break;
				else{
					if(charStack.pop() == charMap.get(currChar)) continue;
					else break;
				}
			}
			else{
				charStack.add(currChar);
			}
		}

		if(i == slength && charStack.isEmpty() == true) answer = true;

		// Custom array implementation of stack O(n)
		/*
		char[] charStack = new char[slength];
		char currChar;
		int ptr = -1, i;
		for(i=0; i<slength; i++){
			currChar = s.charAt(i);
			if(currChar == ')' || currChar == '}' || currChar == ']'){
				if(ptr == -1) break;
				else {
					if(charMap.get(currChar) == charStack[ptr]){
						ptr--;
					}
					else break;
				}
			}
			else{
				charStack[++ptr] = currChar;
			}
		}
		if(i == slength && ptr == -1) answer = true;
		*/
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		twenty objTwenty = new twenty();
		System.out.print(objTwenty.isValid(s));
		sc.close();
	}
}
