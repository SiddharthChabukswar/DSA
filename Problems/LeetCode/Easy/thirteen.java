package LeetCode.Easy;

import java.util.HashMap;
import java.util.Scanner;

/* 

https://leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/

public class thirteen {

	public int romanToInt(String s) {
		int number = 0, slength = s.length();
		
		// HashMap Solution O(n)
		HashMap<Character, Integer> RomanMap = new HashMap<Character, Integer>();
		
		RomanMap.put('I', 1);
		RomanMap.put('V', 5);
		RomanMap.put('X', 10);
		RomanMap.put('L', 50);
		RomanMap.put('C', 100);
		RomanMap.put('D', 500);
		RomanMap.put('M', 1000);

		int current = 0, previous = 0;
		for(int i=slength-1; i>=0; i--){
			current = RomanMap.get(s.charAt(i));
			if(current < previous) number -= current;
			else number += current;
			previous = current;
		}

		// Naive conditional operations O(n)
		/*
		char currChar;
		for(int i=0; i<slength; i++){
			currChar = s.charAt(i);
			if(currChar == 'M') number += 1000;
			else if(currChar == 'D') number += 500;
			else if(currChar == 'C'){
				if((i+1)==slength) number += 100;
				else if(s.charAt(i+1) == 'D'){
					number += 400;
					i++;
				}
				else if(s.charAt(i+1) == 'M'){
					number += 900;
					i++;
				}
				else{
					number += 100;
				}
			}
			else if(currChar == 'L') number += 50;
			else if(currChar == 'X'){
				if((i+1)==slength) number += 10;
				else if(s.charAt(i+1) == 'L'){
					number += 40;
					i++;
				}
				else if(s.charAt(i+1) == 'C'){
					number += 90;
					i++;
				}
				else{
					number += 10;
				}
			}
			else if(currChar == 'V') number += 5;
			else if(currChar == 'I'){
				if((i+1)==slength) number += 1;
				else if(s.charAt(i+1) == 'V'){
					number += 4;
					i++;
				}
				else if(s.charAt(i+1) == 'X'){
					number += 9;
					i++;
				}
				else{
					number += 1;
				}
			}
			// System.out.print("I: ");
			// System.out.println(i);
			// System.out.println(number);
		}
		*/
		return number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		thirteen objThirteen = new thirteen();
		System.out.print(objThirteen.romanToInt(s));
		sc.close();
	}
}
