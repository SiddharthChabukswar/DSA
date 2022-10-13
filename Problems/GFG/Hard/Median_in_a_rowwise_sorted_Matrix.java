package GFG.Hard;

/* 

Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

Example 1:

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]

Output: 5

Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

Example 2:

Input:
R = 3, C = 1
M = [[1], [2], [3]]
Output: 2

Your Task:  
You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

Expected Time Complexity: O(32 * R * log(C))
Expected Auxiliary Space: O(1)


Constraints:
1<= R,C <=150
1<= matrix[i][j] <=2000

*/

public class Median_in_a_rowwise_sorted_Matrix {

	int findLowerBound(int[] row, int element) {
		int low = 0, high = row.length-1, mid;
		while(low <= high) {
			mid = (low+high)/2;
			if(row[mid] < element) {
				low = mid+1;
			} else if(row[mid] > element) {
				high = mid-1;
			} else {
				if(mid == row.length-1 || row[mid+1] != element) return mid+1;
				else low = mid+1;
			}
		}
		return low;
	}

	int median(int matrix[][], int r, int c) {
		int middle = (r*c)/2, low = 1, high = 2000, mid, row, count;
		while(low <= high) {
			mid = (low+high)/2;
			count = 0;
			for(row=0; row<r; row++) count += findLowerBound(matrix[row], mid);
			System.out.println(low + " " + high + " "+ mid + " " + count);
			if(count <= middle) low = mid+1;
			else high = mid-1;
		}
		return low;
	}

}