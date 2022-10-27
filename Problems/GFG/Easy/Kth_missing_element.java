package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/k-th-missing-element3635/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-missing-element

Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence which is not present in the sequence. If no k-th missing element is there output -1.

Example 1:

Input : arr[ ] = {1, 3, 4, 5, 7} and K = 2
Output : 6
Explanation:
K = 2, We need to find the 2nd missing 
number in the array. Missing numbers are 
2 and 6. So 2nd missing number is 6.
 

Example 2:

Input : arr[ ] = {1, 2, 3, 4, 5, 6} 
Output :  -1 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function KthMissingElement() that takes an array (arr), sizeOfArray (n), an integer K and return the Kth missing number if present otherwise returns -1. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

 

Constraints:
1 ≤ N, K, A[i] ≤ 105

*/

public class Kth_missing_element {

	int getDifference(int lb, int idx, int curr) {
		return curr - (idx+lb);
	}

	int KthMissingElement(int a[], int n, int k) {
		int lb = a[0], hb = a[n-1];
		int low = 0, high = n-1, mid;
		while(low <= high) {
			mid = low + (high-low)/2;
			if(getDifference(lb, mid, a[mid]) < k) {
				low = mid+1;
			} else {
				high = mid-1;				
			}
		}
		if(high == -1) return -1;
		// System.out.println(high + " " + a[high]);
		int ans = a[high]+k-getDifference(lb, high, a[high]);
		if(ans > hb) return -1;
		else return ans;
	}

}