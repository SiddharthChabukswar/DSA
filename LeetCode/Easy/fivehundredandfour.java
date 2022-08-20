package LeetCode.Easy;

import java.util.Scanner;

public class fivehundredandfour {

	public String convertToBase7(int num) {
		if(num == 0) return "";
		Boolean isNegative = (num < 0)?true:false;
		num = Math.abs(num);
		StringBuilder ans = new StringBuilder();
		while(num != 0) {
			ans.append(num%7);
			num /= 7;
		}
		if(isNegative == true)
			ans.append("-");
		return ans.reverse().toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number num: ");
		int num = sc.nextInt();
		fivehundredandfour objfFivehundredandfour = new fivehundredandfour();
		System.out.println(objfFivehundredandfour.convertToBase7(num));
		sc.close();
	}
	
}
