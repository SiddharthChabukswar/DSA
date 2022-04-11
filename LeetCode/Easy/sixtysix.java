package LeetCode.Easy;

import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/plus-one/

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

*/

public class sixtysix {
	
	public int[] plusOne(int[] digits) {
		int dlen = digits.length, i = dlen - 1, carry = 1;
		int[] answer = new int[dlen];
		do{
			answer[i] = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			i--;
			// System.out.printf("%s : %d : %d: \n", Arrays.toString(answer), carry, i);
		}while(i >= 0);
		if(carry == 1){
			int[] finalanswer = new int[dlen + 1];
			finalanswer[0] = 1;
			answer = finalanswer;
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the lenght of digits: ");
		int n = sc.nextInt();
		int[] digits = new int[n];
		for(int i=0; i<n; i++) digits[i] = sc.nextInt();
		sixtysix objSixtysix = new sixtysix();
		System.out.println(Arrays.toString(objSixtysix.plusOne(digits)));
		sc.close();
	}

}
