package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=sort-an-array-of-0s-1s-and-2s

Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2

*/

public class Sort_an_array_of_0s_1s_and_2s {

	// Dutch National Flag Sorting Algorithm O(n)
	public static void sort012(int a[], int n) {
		int low=0, high=n-1, mid=0, temp;
		while(mid <= high) {
			if(a[mid] == 0) {
				temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				mid++;
				low++;
			} else if(a[mid] == 2) {
				temp = a[mid];
				a[mid] = a[high];
				a[high] = temp;
				high--;
			} else {
				mid++;
			}
		}
	}

	// Two pointer method O(3*N)
	/*
	public static void sort012(int a[], int n) {
		int ptr1 = 0, ptr2 = 0;
		for(int i=0; i<2; i++) {
			ptr2 = ptr1;
			while(ptr2 < n) {
				if(a[ptr2] == i) {
					a[ptr2] = a[ptr1];
					a[ptr1] = i;
				}
				if(a[ptr1] == i) ptr1++;
				ptr2++;
			}
		}
	}
	*/

}