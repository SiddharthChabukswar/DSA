package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/excel-sheet-column-title/

Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1

*/

public class hundredandsixtyeight {
	
	public String convertToTitle(int columnNumber) {
		String answer="";
		int remainder = 0;
		while(columnNumber!=0){
			remainder = columnNumber%26;
			if(remainder == 0) remainder = 26;
			answer = (char)('A' + remainder - 1) + answer;
			columnNumber = (columnNumber - remainder) / 26;
			// System.out.println(answer);
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int columnNumber = sc.nextInt();
		hundredandsixtyeight objHundredandsixtyeight = new hundredandsixtyeight();
		String answer = objHundredandsixtyeight.convertToTitle(columnNumber);
		System.out.println(answer);
		sc.close();
	}

}
