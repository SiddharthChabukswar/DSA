package GFG.Medium;

/*

Given an array and a number k, find the largest sum of the subarray containing at least k numbers. It may be assumed that the size of array is at-least k.
 

Example 1:

Input : 
n = 4
arr[] = {-4, -2, 1, -3}
k = 2
Output : 
-1
Explanation :
The sub array is {-2, 1}
 
Example 2:
Input :
n = 6 
arr[] = {1, 1, 1, 1, 1, 1}
k = 2
Output : 
6
Explanation :
The sub array is {1, 1, 1, 1, 1, 1}
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function maxSumWithK() which takes the array A[], its size N and an integer K as inputs and returns the value of the largest sum of the subarray containing at least k numbers.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1<=n<=105
-105<=a[i]<=105
1<=k<=n

*/

public class Largest_Sum_Subarray_of_Size_at_least_K {

	public long maxSumWithK(long a[], long n, long k) {
		long answer = Long.MIN_VALUE, sum = 0l, prev = 0l;
		for(int i=0; i<(int)k; i++) {
			sum += a[i];
		}
		int low = 0;
		answer = Math.max(sum, answer);
		for(int i=(int)k; i<(int)n; i++) {
			sum += a[i];
			prev += a[low++];
			answer = Math.max(sum, answer);
			if(prev < 0) {
				sum = sum - prev;
				prev = 0l;
				answer = Math.max(sum, answer);
			}
		}
		return answer;
	}

}