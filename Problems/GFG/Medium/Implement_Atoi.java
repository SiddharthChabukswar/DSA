package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/implement-atoi/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-atoi

Implement Atoi

Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.

Note: You are not allowed to use inbuilt function.

Example 1:

Input:
str = 123
Output: 123
Example 2:

Input:
str = 21a
Output: -1
Explanation: Output is -1 as all
characters are not digit only.
Your Task:
Complete the function atoi() which takes a string as input parameter and returns integer value of it. if the input string is not a numerical string then returns -1.
Note: Numerical strings are the string where either every character is in between 0-9 or where the first character is '-' and the rest all characters are in between 0-9.

Expected Time Complexity: O(|S|), |S| = length of string str.
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ length of S ≤ 10


Note:The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

*/

public class Implement_Atoi {

	String removeLeadingSpaces(String str) {
		int start = 0, strlen = str.length();
		while(start < strlen && str.charAt(start) == ' ') start++;
		return str.substring(start, strlen);
	}

	Boolean checkIfNegative(String str) {
		if(str.length()!=0 && str.charAt(0)!='-') return false;
		return true;
	}

	Boolean checkIfValid(String str) {
		for(Character str_char: str.toCharArray()) {
			if(str_char >= '0' && str_char <= '9') continue;
			else return false;
		}
		return true;
	}

	int atoi(String str) {
		str = removeLeadingSpaces(str);
		Boolean isNegative = checkIfNegative(str);
		if(isNegative == true) {
			if(str.length() == 1) return -1;
			else str = str.substring(1, str.length());
		}
		if(checkIfValid(str) == false) return -1;
		int strInt = 0, pow = 1;
		for(int start = str.length()-1; start >= 0; start--) {
			strInt += (pow*(str.charAt(start)-'0'));
			pow *= 10;
		}
		if(isNegative == true) strInt *= -1;
		return strInt;
	}

}