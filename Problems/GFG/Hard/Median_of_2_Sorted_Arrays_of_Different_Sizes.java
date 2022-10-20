package GFG.Hard;

/*

https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-of-2-sorted-arrays-of-different-sizes

Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.

Example 1:
1
Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
1 2 3 5 6 7 9
Output: 5
Explanation: The middle element for
{1,2,3,5,6,7,9} is 5
Example 2:

Input:
m = 2, n = 4
array1[] = {4,6}
array2[] = {1,2,3,5}
Output: 3.5
Your Task:
The task is to complete the function MedianOfArrays() that takes array1 and array2 as input and returns their median. 

Can you solve the problem in expected time complexity?

Expected Time Complexity: O(min(log n, log m)).
Expected Auxiliary Space: O((n+m)/2).

Constraints: 
0 ≤ m,n ≤ 104
1 ≤ array1[i], array2[i] ≤ 105

*/
public class Median_of_2_Sorted_Arrays_of_Different_Sizes {

	static double medianOfArrays(int m, int n, int a[], int b[]){
		if(m > n) return medianOfArrays(n, m, b, a);
		int cut1, cut2, low, high, median = (m+n)/2;
		int l1, l2, r1, r2;
		low = 0;
		high = m;
		while(low <= high) {
			cut1 = low + (high-low)/2;
			cut2 = median - cut1;
			l1 = (cut1 == 0)?Integer.MIN_VALUE:a[cut1-1];
			r1 = (cut1 == m)?Integer.MAX_VALUE:a[cut1];
			l2 = (cut2 == 0)?Integer.MIN_VALUE:b[cut2-1];
			r2 = (cut2 == n)?Integer.MAX_VALUE:b[cut2];
			if(l1 <= r2 && l2 <= r1) {
				if((m+n)%2 == 0) return (double)(Math.max(l1, l2) + Math.min(r1, r2))/2.0;
				else return (double) Math.min(r1, r2);
			} else if(l1 > r2) {
				high = cut1 - 1;
			} else {
				low = cut1 + 1;
			}
		}
		return 0.0;
	}

}