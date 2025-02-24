package CodingNinjas.Easy;

import java.util.Scanner;

/*

https://www.naukri.com/code360/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

Problem statement
You are given two positive integers 'n' and 'm'. You have to return the 'nth' root of 'm', i.e. 'm(1/n)'. If the 'nth root is not an integer, return -1.



Note:
'nth' root of an integer 'm' is a number, which, when raised to the power 'n', gives 'm' as a result.


Example:
Input: ‘n’ = 3, ‘m’ = 27

Output: 3

Explanation: 
3rd Root of 27 is 3, as (3)^3 equals 27.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
3 27


Sample Output 1:
3


Explanation For Sample Input 1:
3rd Root of 27 is 3, as (3)^3 equals 27.


Sample Input 2:
4 69


Sample Output 2:
-1


Explanation For Sample Input 2:
4th Root of 69 is not an integer, hence -1.


Expected Time Complexity:
Try to do this in O(log(n+m)).


Constraints:
1 <= n <= 30
1 <= m <= 10^9

Time Limit: 1 sec.

*/
public class Find_Nth_Root_Of_M {

	private static long pow(final long num, final int n, final int m) {
		if (n==1) {
			return num;
		}
		long currPow = pow(num, n/2, m);
		if (currPow > m || currPow < 0) return Integer.MAX_VALUE;
		if (n%2 == 1) return (currPow*currPow*num);
		else return (currPow*currPow);
	}

	private static int findNthRoot(int left, int right, int n, int m) {
		if (left > right) {
			return -1;
		}
		int mid = (left+right)/2;
		long powMid = pow((long) mid, n, m);
		if (powMid == m) return mid;
		else if (powMid > m) return findNthRoot(left, mid-1, n, m);
		else return findNthRoot(mid+1, right, n, m);
	}

	public static int NthRoot(int n, int m) {
		return findNthRoot(1, m, n, m);
	}

	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		NthRoot(n, m);
		sc.close();
	}

}