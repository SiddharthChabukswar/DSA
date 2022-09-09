package Algorithms.Sorting.Easy;

/*

Purpose: Sort an unsorted array
Time complexity: O(n)

Approach:

1. Find the minimum element from the current location and place it with the current location
2. Used two nested loops

{ 55, 42, 14, 96, 24, 5, 988, -55, 24}

*/

public class SelectionSort {

	private static void performSelectionSort(int[] array) {
		int i, j, temp, local_min, n = array.length;
		for(i=0; i<n; i++) {
			local_min = array[i];
			for(j=i+1; j<n; j++) {
				if(array[j] < local_min) {
					local_min = array[j];
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		performSelectionSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}
	
}
