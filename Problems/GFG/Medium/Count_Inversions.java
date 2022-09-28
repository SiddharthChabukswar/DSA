package GFG.Medium;

// import java.util.Scanner;

/*

https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array

Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ N ≤ 5*105
1 ≤ arr[i] ≤ 1018

*/

class MergeSortInversion {

	long mergeAndCount(long arr[], int left, int mid, int right) {
		long[] temp = new long[right-left+1];
		int ptr1 = left;
		int ptr2 = mid+1;
		int k = 0;
		long count = 0l;
		while(ptr1 <= mid && ptr2 <= right) {
			if(arr[ptr1] <= arr[ptr2]) {
				temp[k++] = arr[ptr1++];
			} else {
				count += (long)(mid-ptr1+1);
				temp[k++] = arr[ptr2++];
			}
		}
		while(ptr1 <= mid) temp[k++] = arr[ptr1++];
		while(ptr2 <= right) temp[k++] = arr[ptr2++];
		for(k=left; k<=right; k++) arr[k] = temp[k-left];
		return count;
	}

	long mergeSort(long arr[], int left, int right) {
		long count = 0l;
		if(left < right) {
			int mid = (left+right)/2;
			count += mergeSort(arr, left, mid);
			count += mergeSort(arr, mid+1, right);
			count += mergeAndCount(arr, left, mid, right);
		}
		return count;
	}

}

public class Count_Inversions {

	// Merge Sort approach O(NlogN)
	static long inversionCount(long arr[], long N) {
		MergeSortInversion mergeSortInversion = new MergeSortInversion(); 
		return mergeSortInversion.mergeSort(arr, 0, (int)(N-1));
	}



	// Linear search O(N^2) (T.L.E.)
	/*
	static long inversionCount(long arr[], long N) {
		long answer = 0l;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i] > arr[j]) answer++;
			}
		}
		return answer;
	}
	*/

}