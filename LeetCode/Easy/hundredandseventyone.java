package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/excel-sheet-column-number/

Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

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

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].

*/

public class hundredandseventyone {

	public int titleToNumber(String columnTitle) {
		int i, n = columnTitle.length(), answer = 0, power = 1;
		for(i=n-1; i>=0; i--){
			answer += (power) * (int)(columnTitle.charAt(i) - 'A' + 1);
			power *= 26;
		}		
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter valid string: ");
		String columnTitle = sc.next();
		hundredandseventyone objHundredandseventyone = new hundredandseventyone();
		System.out.println(objHundredandseventyone.titleToNumber(columnTitle));
		sc.close();
	}

}
