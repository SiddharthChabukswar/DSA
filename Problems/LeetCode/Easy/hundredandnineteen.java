package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

https://leetcode.com/problems/pascals-triangle-ii/

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 

Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?

*/


public class hundredandnineteen {
	
	// Using iterative method DP O(n^2) (Top-down approach)
	/*
	public List<Integer> getRow(int rowIndex) {
		rowIndex = rowIndex + 1;
		List<Integer> answer = new ArrayList<Integer>();
		List<Integer> prev_row;
	
		answer.add(1);
		
		int[] curr_int_array;
		int level_pointer, i, j, curr_sum;

		for(level_pointer = 2; level_pointer <= rowIndex; level_pointer++){
			j = (level_pointer + 1)/2;
			prev_row = answer;
			curr_int_array = new int[level_pointer];
			curr_int_array[0] = 1;
			for(i=1; i<j; i++){
				curr_sum = prev_row.get(i-1) + prev_row.get(i);
				curr_int_array[i] = curr_sum;
				curr_int_array[level_pointer - i - 1] = curr_sum;
			}
			curr_int_array[level_pointer - 1] = 1;
			answer = new ArrayList<Integer>();
			for(int k: curr_int_array) answer.add(k);
		}
		return answer;
	}
	*/

	// Using Combination formula method: O(n)
	// nCr = ((n-r+1)/(r))*(nC(r-1))
	public List<Integer> getRow(int rowIndex) {
		List<Integer> answer = new ArrayList<Integer>();
		if(rowIndex == 0){
			answer.add(1);
			return answer;
		}
		long rowIndexlong = (long)rowIndex;
		int i, j = rowIndex/2;
		long[] answer_int_array = new long[rowIndex+1];
		long temp_mul = 0;
		answer_int_array[0] = 1;
		for(i=1; i<=j; i++){
			temp_mul = (long)((rowIndexlong - i + 1) * answer_int_array[i-1]);
			answer_int_array[i] =  (long)(temp_mul / i);
			answer_int_array[rowIndex - i] = answer_int_array[i];
		}
		answer_int_array[rowIndex] = 1;
		for(long k: answer_int_array) answer.add((int)k);
		return answer;
	}

	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter level number: ");
		int rowIndex = sc.nextInt();
		hundredandnineteen objHundredandnineteen = new hundredandnineteen();
		List<Integer> answer = objHundredandnineteen.getRow(rowIndex);
		System.out.println(answer);
		sc.close();
	}

}
