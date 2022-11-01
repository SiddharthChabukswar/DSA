package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/largest-odd-number-in-string/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-odd-number-in-string

Given an string S, representing a large interger. Return the largest-valued odd integer (as a string) that is substring of the given string S.


Note : A substring is a contiguous sequence of characters within a string. Null string ("") is also a substring.

Example 1:

Input: s = "504"
Output: "5"
Explanation: The only subtring "5" is odd number.
 

Example 2:

Input: s = "2042"
Output: ""
Explanation: All the possible non-empty substring have even value.
 


Your Task:
You don't need to read input or print anything. Your task is to complete the function maxOdd() which takes the string S as input and returns the largest-valued odd integer that is substring of the given string.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1<=|S|<=2*105

S only consists of digits and does not contain any leading zeros.

*/

public class Largest_odd_number_in_string {

	String maxOdd(String s) {
		int slen = s.length()-1;
		while(slen >= 0) {
			if((s.charAt(slen)-'0')%2 == 0) slen--;
			else return s.substring(0, slen+1);
		}
		if(slen == -1) return "";
		return "";
	}

}