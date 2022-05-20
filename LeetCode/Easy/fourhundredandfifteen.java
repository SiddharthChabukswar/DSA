package LeetCode.Easy;

/*

https://www.youtube.com/watch?v=uncay27JjOA

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.

*/

public class fourhundredandfifteen {

	public String addStrings(String num1, String num2) {
		String answer = "";
		int n1len = num1.length()-1, n2len = num2.length()-1, carry = 0, sum;
		while(n1len >= 0 && n2len >= 0){
			sum = (int)(num1.charAt(n1len) - '0' + num2.charAt(n2len) - '0' + carry);
			carry = sum/10;
			sum = sum%10;
			answer = (char)(sum + '0') + answer;
			n1len--;
			n2len--;
		}
		while(n1len >= 0){
			sum = (int)(num1.charAt(n1len) - '0' + carry);
			carry = sum/10;
			sum = sum%10;
			answer = (char)(sum + '0') + answer;
			n1len--;
		}
		while(n2len >= 0){
			sum = (int)(num2.charAt(n1len) - '0' + carry);
			carry = sum/10;
			sum = sum%10;
			answer = (char)(sum + '0') + answer;
			n2len--;
		}
		if(carry != 0) answer = '1' + answer; 
		return answer;
	}

}
