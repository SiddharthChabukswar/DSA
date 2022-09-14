package GFG.Easy;

import java.util.ArrayList;

/*

https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays

Union of two arrays can be defined as the common and distinct elements in the two arrays.
Given two sorted arrays of size n and m respectively, find their union.


Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 3, arr2 [] = {1, 2, 3}
Output: 1 2 3 4 5
Explanation: Distinct elements including 
both the arrays are: 1 2 3 4 5.
 

Example 2:

Input: 
n = 5, arr1[] = {2, 2, 3, 4, 5}  
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 1 2 3 4 5
Explanation: Distinct elements including 
both the arrays are: 1 2 3 4 5.
 

Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 1 2
Explanation: Distinct elements including 
both the arrays are: 1 2.

Your Task: 
You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays. 
 

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).
 

Constraints:
1 <= n, m <= 105
1 <= arr[i], brr[i] <= 106


*/

public class Union_of_Two_Sorted_Arrays {
	
	public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
		ArrayList<Integer> union_list = new ArrayList<Integer>();
		Integer ptr1=0, ptr2=0, curr;
		while(ptr1 < n && ptr2 < m) {
			if(arr1[ptr1] == arr2[ptr2]){
				curr = arr1[ptr1];
				while(ptr1 < n && arr1[ptr1] == curr) ptr1++;
				while(ptr2 < m && arr2[ptr2] == curr) ptr2++;
			} else if(arr1[ptr1] < arr2[ptr2]){
				curr = arr1[ptr1];
				while(ptr1 < n && arr1[ptr1] == curr) ptr1++;
			} else{
				curr = arr2[ptr2];
				while(ptr2 < m && arr2[ptr2] == curr) ptr2++;
			}
			union_list.add(curr);
		}
		while(ptr1 < n) {
			curr = arr1[ptr1];
			while(ptr1 < n && arr1[ptr1] == curr) ptr1++;
			union_list.add(curr);
		}
		while(ptr2 < m) {
			curr = arr2[ptr2];
			while(ptr2 < m && arr2[ptr2] == curr) ptr2++;
			union_list.add(curr);
		}
		return union_list;
	}
}
