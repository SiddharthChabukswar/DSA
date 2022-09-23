package GFG.Easy;

import java.util.ArrayList;

/*

https://practice.geeksforgeeks.org/problems/pascal-triangle0652/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pascal-triangle

Given a positive integer N, return the Nth row of pascal's triangle.
Pascal's triangle is a triangular array of the binomial coefficients formed by summing up the elements of previous row.

Example :
1
1 1
1 2 1
1 3 3 1
For N = 3, return 3rd row i.e 1 2 1

Example 1:

Input:
N = 4
Output: 1 3 3 1
Explanation: 4th row of pascal's triangle
is 1 3 3 1.
Example 2:

Input:
N = 5
Output: 1 4 6 4 1
Explanation: 5th row of pascal's triangle
is 1 4 6 4 1.
 

Your Task:
Complete the function nthRowOfPascalTriangle() which takes n, as input parameters and returns an array representing the answer. The elements can be large so return it modulo 109 + 7. You don't to print answer or take inputs.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ N ≤ 1000

*/

public class Pascal_Triangle {

	// Binomial coefficient approach O(n)
	/*
	ArrayList<Long> nthRowOfPascalTriangle(int n) {
		ArrayList<Long> pascalTriangleRow = new ArrayList<Long>();
		pascalTriangleRow.add(1l);
		Long coeffn;
		for(int i=1; i<n; i++) {
			if((n-i)%i == 0) coeffn = (pascalTriangleRow.get(i-1)*((n-i)/i))%1000000007l;
			else coeffn = ((pascalTriangleRow.get(i-1)/i)*(n-i))%1000000007l;
			pascalTriangleRow.add(coeffn);
		}
		return pascalTriangleRow;
	}
	*/

	// Old Approach O(n^2)
	ArrayList<Long> nthRowOfPascalTriangle(int n) {
		ArrayList<ArrayList<Long>> pascalTriangle = new ArrayList<ArrayList<Long>>();
		ArrayList<Long> pascalTriangleRow;
		ArrayList<Long> pascalTrianglePrevRow;
		Long sum;
		pascalTriangleRow = new ArrayList<Long>();
		pascalTriangleRow.add(1l);
		pascalTriangle.add(pascalTriangleRow);
		pascalTriangleRow = new ArrayList<Long>();
		pascalTriangleRow.add(1l);
		pascalTriangleRow.add(1l);
		pascalTriangle.add(pascalTriangleRow);
		for(int i=2; i<n; i++) {
			pascalTrianglePrevRow = pascalTriangle.get(i-1);
			pascalTriangleRow = new ArrayList<Long>();
			pascalTriangleRow.add(1l);
			for(int j=0; j<i-1; j++) {
				sum = (pascalTrianglePrevRow.get(j) + pascalTrianglePrevRow.get(j+1))%10000007l;
				pascalTriangleRow.add(sum);
			}
			pascalTriangleRow.add(1l);
			pascalTriangle.add(pascalTriangleRow);
		}
		return pascalTriangle.get(n-1);
	}

}