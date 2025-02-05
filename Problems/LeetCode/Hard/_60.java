package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutation-sequence/description/
 * 
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
 */
public class _60 {

	/*
	Recusion O(N!*N)
	private void swap(final char[] charArr, final int i, final int j) {
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
	}

	private void reverse(final char[] charArr, final int i, final int j) {
		int ptr1 = i;
		int ptr2 = j-1;
		while (ptr1 < ptr2) {
			swap(charArr, ptr1, ptr2);
			ptr1++;
			ptr2--;
		}
	}

	private String nextPermutation(final String input, final int k) {
		if (k==0) return input;
		String prevString = nextPermutation(input, k-1);
		// System.out.println(k+"_"+prevString);
		char[] prevStringArr = prevString.toCharArray();
		int n = prevString.length(), i, j;
		for (i=n-1; i>=1; i++) {
			if (prevStringArr[i] < prevStringArr[i-1]) continue;
			for (j=i; j<n; j++) {
				if (prevStringArr[i-1] > prevStringArr[j]) break;
			}
			swap(prevStringArr, i-1, j-1);
			reverse(prevStringArr, i, n);
			break;
		}
		return String.valueOf(prevStringArr);
	}

	public String getPermutation(int n, int k) {
		char[] charArr = new char[n];
		for (int i=1; i<=n; i++) charArr[i-1] = (char) (i+'0');
		String input = String.valueOf(charArr);
		return nextPermutation(input, k);
	}
	*/

	// Mathematics O(n)
	public String getPermutation(int n, int k) {
		final List<Integer> numbers = new ArrayList<>();
		int factorial = 1;
		for (int i=1; i<=n; i++) {
			factorial = factorial*i;
			numbers.add(i);
		}
		StringBuilder answerStringBuilder = new StringBuilder();
		k -= 1;
		int num;
		while (!numbers.isEmpty()) {
			factorial = factorial/numbers.size();
			num = k/factorial;
			answerStringBuilder.append(numbers.get(num));
			k = k%factorial;
			numbers.remove(num);
			System.out.println(answerStringBuilder.toString()+"_"+numbers);
		}
		
		return answerStringBuilder.toString();
	}
}
