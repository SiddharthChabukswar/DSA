package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array

Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K. The task is to find the element that would be at the k’th position of the final sorted array.
 

Example 1:

Input:
arr1[] = {2, 3, 6, 7, 9}
arr2[] = {1, 4, 8, 10}
k = 5
Output:
6
Explanation:
The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.
Example 2:
Input:
arr1[] = {100, 112, 256, 349, 770}
arr2[] = {72, 86, 113, 119, 265, 445, 892}
k = 7
Output:
256
Explanation:
Final sorted array is - 72, 86, 100, 112,
113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function kthElement() which takes the arrays arr1[], arr2[], its size N and M respectively and an integer K as inputs and returns the element at the Kth position.


Expected Time Complexity: O(Log(N) + Log(M))
Expected Auxiliary Space: O(Log (N))


Constraints:
1 <= N, M <= 106
1 <= arr1i, arr2i < INT_MAX
1 <= K <= N+M

*/

public class Kth_element_of_two_sorted_Arrays {
	
	public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
		if(m>n) return kthElement(arr2, arr1, m, n, k);
		int low = Math.max(0, k-m), high = Math.min(n, k), mid_cut, mid_cut_2;
		int l1, l2, r1, r2;
		while(low <= high) {
			mid_cut = (low+high)/2;
			mid_cut_2 = k-mid_cut;
			l1 = (mid_cut == 0)?Integer.MIN_VALUE:arr1[mid_cut-1];
			l2 = (mid_cut_2 == 0)?Integer.MIN_VALUE:arr2[mid_cut_2-1];
			r1 = (mid_cut == n)?Integer.MAX_VALUE:arr1[mid_cut];
			r2 = (mid_cut_2 == m)?Integer.MAX_VALUE:arr2[mid_cut_2];
			if(l1<=r2 && l2<=r1) return Math.max(l1, l2);
			else if(l1>r2) high = mid_cut-1;
			else low = mid_cut+1;
		}
		return -1l;
	}
}