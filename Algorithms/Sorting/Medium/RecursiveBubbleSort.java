package Algorithms.Sorting.Medium;

/*

Purpose: Sort an unsorted array
Time complexity: O(n^2)

Approach:

See: https://www.geeksforgeeks.org/recursive-bubble-sort/

{ 55, 42, 14, 96, 24, 5, 988, -55, 24}

*/

public class RecursiveBubbleSort {
	
	private static void performBubbleSort(int[] arr, int n) {
		if(n==1) return;
        int i, temp, count = 0;
		for(i=0; i<n-1; i++) {
			if(arr[i] > arr[i+1]) {
			    temp = arr[i];
			    arr[i] = arr[i+1];
			    arr[i+1] = temp;
			    count++;
			}
		}
		if(count == 0) return;
		performBubbleSort(arr, n-1);
	}

	private static void recursiveBubbleSort(int[] array) {
		performBubbleSort(array, array.length);
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		recursiveBubbleSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}

}
