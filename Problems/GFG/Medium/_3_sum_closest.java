package GFG.Medium;

import java.util.Arrays;

/*

https://practice.geeksforgeeks.org/problems/3-sum-closest/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=3-sum-closest

Given an array A[] of N integers and an integer X. The task is to find the sum of three integers in A[] such that it is closest to X.


Example 1:

Input:
N = 4
A[] = {-1 , 2, 1, -4}
X = 1
Output: 2
Explaination: 
Sums of triplets:
(-1) + 2 + 1 = 2
(-1) + 2 + (-4) = -3
2 + 1 + (-4) = -1
2 is closest to 1.

Example 2:

Input:
N = 5
A[] = {1, 2, 3, 4, -5}
X = 10
Output: 9
Explaination: 
Sums of triplets:
1 + 2 + 3 = 6
2 + 3 + 4 = 9
1 + 3 + 4 = 7
...
9 is closest to 10.

Your Task:
You don't need to read input or print anything. Your task is to complete the function closest3Sum() which takes the array Arr[] and its size N and X as input parameters and returns the sum which is closest to X.

NOTE: If there exists more than one answer then return the maximum sum.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)


Constraints:
3 ≤ N ≤ 103
-103 ≤ Arr[i] ≤ 103
-104 ≤ X ≤ 104

*/

public class _3_sum_closest {

	static int closest3Sum(int A[], int N, int X) {
		Arrays.sort(A);
		int min_diff_sum = Integer.MIN_VALUE, min_diff_abs = Integer.MAX_VALUE, i, low, high, sum, abs_diff;
		for(i=0; i<N; i++) {
			if(i!=0 && A[i]==A[i-1]) continue;
			else {
				low = i+1;
				high = N-1;
				while(low < high) {
					sum = A[i] + A[low] + A[high];
					abs_diff = Math.abs(X-sum);
					if(sum == X) {
						return sum;
					} else if(sum < X) {
						do{
							low++;
						}while(low < high && A[low] == A[low-1]);
					} else {
						do{
							high--;
						}while(low < high && A[high] == A[high+1]);
					}
					if(min_diff_abs > abs_diff) {
						min_diff_abs = abs_diff;
						min_diff_sum = sum;
					} else if(min_diff_abs == abs_diff && min_diff_sum < sum) min_diff_sum = sum;
				}
			}
		}
		return min_diff_sum;
	}

}