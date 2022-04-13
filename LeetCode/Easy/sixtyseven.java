package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/add-binary/

Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

*/


public class sixtyseven {

	public String addBinary(String a, String b) {
		String answer = "";
		char curr, curra, currb;
		int alen = a.length()-1, blen = b.length()-1, carry = 0;
		while(alen>=0 && blen>=0){
			curra = a.charAt(alen);
			currb = b.charAt(blen);
			// System.out.printf("curra: %c, currb: %c, carry: %d\n", curra, currb, carry);
			if(curra == currb){
				if(carry == 1) curr = '1';
				else curr = '0';
				if(curra == '1') carry = 1;
				else carry = 0;
			}
			else{
				if(carry == 1) curr = '0';
				else curr = '1';
			}
			answer = curr + answer;
			alen--;
			blen--;
		}
		while(alen>=0){
			// System.out.printf("curra: %d\n", alen);
			curra = a.charAt(alen);
			if(curra == '1'){
				if(carry == 1){
					curr = '0';
					carry = 1;
				}
				else curr = '1';
			}
			else{
				if(carry == 1){
					curr = '1';
					carry = 0;
				}
				else curr = '0';
			}
			answer = curr + answer;
			alen--;
		}
		while(blen>=0){
			// System.out.printf("currb: %d\n", blen);
			currb = b.charAt(blen);
			if(currb == '1'){
				if(carry == 1){
					curr = '0';
					carry = 1;
				}
				else curr = '1';
			}
			else{
				if(carry == 1){
					curr = '1';
					carry = 0;
				}
				else curr = '0';
			}
			answer = curr + answer;
			blen--;
		}
		if(carry == 1) answer = "1" + answer;
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1st string: ");
		String a = sc.next();
		System.out.print("Enter 2nd string: ");
		String b = sc.next();
		sixtyseven objSixtyseven = new sixtyseven();
		System.out.println(objSixtyseven.addBinary(a, b));
		sc.close();
	}

}
