package GFG.Easy;

import java.util.Stack;

/*

https://practice.geeksforgeeks.org/problems/maximum-nesting-depth-of-the-parentheses/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=maximum-nesting-depth-of-the-parentheses

A string is a valid parentheses string (denoted VPS ) if is meets any one of the following:

It is an empty string "", or a single character not equals to " ( "  or  " ) " ,
It can be written as AB (A concatenated with B ),
where A and B are VPS's , or
It can be written as (A) , where A is a VPS.
We can similarly define the nesting depth depth (S) of any VPS S as follows:

depth ("") = 0
depth (C) = 0, where C is a string with a single character excluding "(" and ")" ,
depth (A + B) = max (depth (A) , depth (B)) , where A and B are VPS's.
depth ( "(" + A + ")" ) = 1 + depth (A) , where A is a VPS.
For example , "" , " ( ) ( ) " , and " ( ) ( ( ) ( ) ) " and VPS's (with nesting depths 0 , 1, and 2), and " ) ( " and " ( ( ) "   are not VPS's.


Given a VPS represented as string S , return the nesting depth of S.

 

Example 1:

Input: s = " ((5+2)(3+4)((6))) "
Output: 3
Explanation: Character '6' is inside three nested parentheses.
 

Example 2:

Input: " (43+4++3)((3)(9))+1 "
Output: 2
Explanation: Character '3' and '9' both are inside two nested parentheses.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxDepth() which takes the string s as input parameters and returns nesting depth of the given string s .

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(1)

Constraints:
1<=|s|<=100
s consists of digits 0-9 and characters ' + ' , ' - ' , ' * ' , ' / ' , ' ( ' , and ' ) '.
It is guaranteed that parentheses expression s is a VPS.

*/

public class Maximum_Nesting_Depth_of_the_Parentheses {

	public static int maxDepth(String s) {
		int maxDepth = 0;
		Stack<Character> openParStack = new Stack<Character>();
		for(Character s_char: s.toCharArray()) {
			if(s_char == '(') openParStack.push(s_char);
			else if(s_char == ')') openParStack.pop();
			maxDepth = Math.max(maxDepth, openParStack.size());
		}
		return maxDepth;
	}

}