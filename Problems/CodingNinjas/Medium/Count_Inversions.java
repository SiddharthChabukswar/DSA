package CodingNinjas.Medium;

import java.util.Scanner;

/*

https://www.naukri.com/code360/problems/count-inversions_615

Problem statement
For a given integer array/list 'ARR' of size 'N' containing all distinct values, find the total number of 'Inversions' that may exist.

An inversion is defined for a pair of integers in the array/list when the following two conditions are met.

A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:

1. 'ARR[i] > 'ARR[j]' 
2. 'i' < 'j'

Where 'i' and 'j' denote the indices ranging from [0, 'N').
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 10^5 
1 <= ARR[i] <= 10^9

Where 'ARR[i]' denotes the array element at 'ith' index.

Time Limit: 1 sec
Sample Input 1 :
3
3 2 1
Sample Output 1 :
3
Explanation of Sample Output 1:
We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
Sample Input 2 :
5
2 5 1 3 4
Sample Output 2 :
4
Explanation of Sample Output 1:
We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).


Hints:
1. Start with the brute force approach.
2. Use a modified merge sort.
3. Iterate through the elements in sorted order and use a Fenwick tree to track the inversions.

*/

public class Count_Inversions {

	private static long mergeSortedArrays(final long arr[], final int left, final int mid, final int right) {
		int ptr1 = left, ptr2 = mid+1, ptr3 = 0;
		long[] sortedArr = new long[right-left+1];
		long count = 0l;
		while (ptr1 <= mid && ptr2 <= right) {
			if (arr[ptr1] <= arr[ptr2]) {
				sortedArr[ptr3++] = arr[ptr1++];
			} else {
				count += (mid-ptr1+1);
				sortedArr[ptr3++] = arr[ptr2++];
			}
		}
		while (ptr1 <= mid) {
			sortedArr[ptr3++] = arr[ptr1++];
		}
		while (ptr2 <= right) {
			sortedArr[ptr3++] = arr[ptr2++];
		}
		for (int i=left; i<=right; i++) {
			arr[i] = sortedArr[i-left];
		}
		return count;
	}

	private static long mergeSort(final long arr[], final int left, final int right) {
		if (left == right) return 0l;
		int mid = (left+right)/2;
		return mergeSort(arr, left, mid) + 
				mergeSort(arr, mid+1, right) + 
				mergeSortedArrays(arr, left, mid, right);
	}

	public static long getInversions(long arr[], int n) {
		return mergeSort(arr, 0, n-1);
    }
	
	public static void main(String[] args) {
		/*
		10
		52244275 123047899 493394237 922363607 378906890 188674257 222477309 902683641 860884025 339100162
		*/
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextLong();
		}
		System.out.println(getInversions(arr, n));
		sc.close();
	}

}