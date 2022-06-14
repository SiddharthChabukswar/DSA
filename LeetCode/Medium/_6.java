package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
https://leetcode.com/problems/zigzag-conversion/

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

public class _6 {

	// Visit a row at a time O(n)
	/*
	public String convert(String s, int numRows) {
		StringBuilder answer = new StringBuilder();
		if(numRows == 1) return s;
		int i = 0, j = 0, up = 0, down = 0, n = s.length(), mul = 0;
		for(i=0; i<numRows; i++){
			up = i*2;
			down = (numRows - i - 1)*2;
			mul = down;
			j = i;
			while(j<n){
				if(mul != 0) answer.append(s.charAt(j));
				j += mul;
				mul = mul ^ up ^ down;
			}
		}
		return answer.toString();
	}
	*/


	// Iterate through rows (Back and forth) O(n)
	public String convert(String s, int numRows) {
		if(numRows == 1) return s;
		StringBuilder answer = new StringBuilder();
		List<StringBuilder> RowList = new ArrayList<StringBuilder>();
		int i = 0, n = s.length(), row = 0;
		Boolean down = true;
		for(i=0; i<numRows; i++) RowList.add(new StringBuilder());
		for(i=0; i<n; i++){
			// System.out.println(row);
			RowList.get(row).append(s.charAt(i));
			if(row == 0) down = true;
			else if(row == numRows-1) down = false;
			if(down == true) row++;
			else row--;
		}
		for(i=0; i<numRows; i++) answer.append(RowList.get(i).toString());
		return answer.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string s: ");
		String s = sc.next();
		System.out.print("Enter number of rows: ");
		int numRows = sc.nextInt();
		_6 obj_6 = new _6();
		System.out.printf("Answer: %s\n", obj_6.convert(s, numRows));
		sc.close();
	}
}
