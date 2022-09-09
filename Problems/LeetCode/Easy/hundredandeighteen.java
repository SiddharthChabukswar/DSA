package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

https://leetcode.com/problems/pascals-triangle/

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30

*/


public class hundredandeighteen {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> list_row;
		List<Integer> prev_list_row;

		if(numRows == 0) return answer;
		
		// level one
		list_row = new ArrayList<Integer>();
		list_row.add(1);
		answer.add(list_row);
		

		// from level two onwards
		int level_pointer, i, j, curr_sum;
		int[] int_list_row;

		for(level_pointer = 2; level_pointer <= numRows; level_pointer++){
			j = (level_pointer+1)/2;
			int_list_row = new int[level_pointer];
			prev_list_row = answer.get(level_pointer - 2);

			int_list_row[0] = 1;
			for(i=1; i<j; i++){
				curr_sum = prev_list_row.get(i-1) + prev_list_row.get(i);
				int_list_row[i] = curr_sum;
				int_list_row[level_pointer - 1 - i] = curr_sum;
			}
			int_list_row[level_pointer - 1] = 1;

			list_row = new ArrayList<Integer>();
			for(int k: int_list_row) list_row.add(k);
			// System.out.printf("Level: %d:   ", level_pointer);
			// System.out.println(list_row);
			answer.add(list_row);
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter levels: ");
		int numRows = sc.nextInt();
		hundredandeighteen objHundredandeighteen = new hundredandeighteen();
		List<List<Integer>> answer = objHundredandeighteen.generate(numRows);
		System.out.println(answer);
		sc.close();
	}
	
}
