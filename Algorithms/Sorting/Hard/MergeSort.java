package Algorithms.Sorting.Hard;

/*

Purpose: Sort an unsorted array
Time complexity: O(n.log(n))

Approach:

1. Divide and Conquer strategy
2. Split the array in half at each iteration and work on each half DFS.
3. When a single element occurs, merge the two children arrays (elements) using two pointer merge resulting in a sorted sub array
4. repeat (Travel back up)
eg: { 55, 42, 14, 96, 24, 5, 988, -55, 24 }

iterations: 
{ 55, 42, 14, 96, 24, 5, 988, -55, 24 }
{ { 55, 42, 14, 96, 24 }, { 5, 988, -55, 24 } }
{ { { 55, 42, 14 }, { 96, 24 } }, { {5, 988}, {-55, 24 } } }
{ { { { 55, 42 }, { 14 } }, { { 96 }, { 24 } } }, { { { 5 }, { 988 } }, { { -55 } , { 24 } } } }
{ { { { { 55 }, { 42 } }, { 14 } }, { { 96 }, { 24 } } }, { { { 5 }, { 988 } }, { { -55 } , { 24 } } } }
{ { { { 42, 55 }, { 14 } }, { { 96 }, { 24 } } }, { { { 5 }, { 988 } }, { { -55 } , { 24 } } } }
{ { { 14, 42, 55 }, { 24, 96 } }, { {5, 988}, {-55, 24 } } }
{ { 14, 24, 42, 55, 96 }, { -55, 5, 24, 988 } }
{ -55, 5, 14, 24, 24, 42, 55, 96, 988 }

*/

public class MergeSort {

	private static void mergeSubArrays(int[] arr, int start, int mid, int end) {
		System.out.println(start + " : " + mid + " :: " + (mid + 1) + " : " + end);
		int[] tempArr = new int[end+1-start];
		int ptr1 = start, ptr2 = mid+1, ptr = 0;
		while(ptr1 <= mid && ptr2 <= end) {
			if(arr[ptr1] <= arr[ptr2]) {
				tempArr[ptr++] = arr[ptr1++];
			}else {
				tempArr[ptr++] = arr[ptr2++];
			}
		}
		while(ptr1 <= mid) {
			tempArr[ptr++] = arr[ptr1++];
		}
		while(ptr2 <= end) {
			tempArr[ptr++] = arr[ptr2++];
		}
		for(int i = start; i <= end; i++) arr[i] = tempArr[i-start];
	}

	private static void sortSubArrays(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start+end)/2;
			sortSubArrays(arr, start, mid);
			sortSubArrays(arr, mid+1, end);
			mergeSubArrays(arr, start, mid, end);
		}
	}
	
	private static void performMergeSort(int[] array) {
		sortSubArrays(array, 0, array.length-1);
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		performMergeSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}
}
