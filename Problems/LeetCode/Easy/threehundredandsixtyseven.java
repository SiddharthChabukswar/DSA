package LeetCode.Easy;

import java.util.Scanner;

/*

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Follow up: Do not use any built-in library function such as sqrt.

 

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
 

Constraints:

1 <= num <= 2^31 - 1

*/

public class threehundredandsixtyseven {
	
	public boolean isPerfectSquare(int num) {
		if(num == 0 || num == 1) return true;
		long l = 1, r = num/2, mid, sqr;
		while(l<=r){
			mid = (r-l)/2 + l;
			sqr = mid*mid;
			// System.out.printf("%d: %d\n", mid, sqr);
			if(sqr == num) return true;
			else if(sqr > num) r = mid - 1;
			else l = mid + 1;
		} 
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		threehundredandsixtyseven objThreehundredandsixtyseven = new threehundredandsixtyseven();
		System.out.println(objThreehundredandsixtyseven.isPerfectSquare(num));
		sc.close();
	}

}
