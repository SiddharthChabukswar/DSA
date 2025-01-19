package InterviewBit.Medium;

/*

https://www.interviewbit.com/problems/repeat-and-missing-number-array/

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

*/

public class Repeat_and_Missing_Number_Array {

	public int[] repeatedNumber(final int[] A) {
		long n = A.length;
		long sumN = (n*(n+1))/2l;
		long sumN2 = (sumN*(2l*n+1l))/3l;
		long sumA = 0l, sumA2 = 0l;
		for (int a: A) {
			sumA += (long) a;
			sumA2 += (long) a * (long) a;
		}
		long r = (((sumA-sumN)+((sumA2-sumN2)/(sumA-sumN)))/2l);
		long m = (r-(sumA-sumN));
		int[] answer = new int[2];
		answer[0] = (int) r;
		answer[1] = (int) m;
		return answer;
	}

}