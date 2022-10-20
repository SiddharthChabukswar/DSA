package GFG.Hard;

/*

https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-of-2-sorted-arrays-of-different-sizes

Given two sorted arrays array1 and array2 of size m and n respectively. Find the median of the two sorted arrays.

Example 1:

Input:
m = 3, n = 4
array1[] = {1,5,9}
array2[] = {2,3,6,7}
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
		if(m==0 && n==0) return 0.0;
		if(m==0) {
			if(n%2 != 0) return (double)b[n/2];
			else return (double)(b[n/2]+b[n/2-1])/2.0;
		}
		if(n==0) {
			if(m%2 != 0) return (double)a[m/2];
			else return (double)(a[m/2]+a[m/2-1])/2.0;
		}
		int ptr1, ptr2, median = (m+n)/2;
		int l1, l2, r1, r2;
		ptr2 = Math.min(median, n-1);
		ptr1 = median - ptr2 - 1;
		while(ptr1 < m && ptr2 < n) {
			l1 = (ptr1 == -1)?Integer.MIN_VALUE:a[ptr1];
			r1 = (ptr1 == m-1)?Integer.MAX_VALUE:a[ptr1+1];
			l2 = (ptr2 == -1)?Integer.MIN_VALUE:b[ptr2];
			r2 = (ptr2 == n-1)?Integer.MAX_VALUE:b[ptr2+1];
			if(l1 <= r2 && l2 <= r1) {
				if((m+n)%2 != 0) return Math.max(l1, l2);
				else {
					if(l1 > l2 && ptr1 != 0) l2 = Math.max(l2, a[ptr1-1]);
					else if(l2 > l1 && ptr2 != 0) l1 = Math.max(l1, b[ptr2-1]);
					return (double)(l1+l2)/2.0;
				}
			} else if(l1 > r2) {
				ptr1--;
				ptr2++;
			} else if(l2 > r1) {
				ptr1++;
				ptr2--;
			}
		}
		return 0.0;
	}

}