package Algorithms.Sorting.Medium;

/*

Purpose: Sort an unsorted array
Time complexity: O(n^2)

Approach:

1. Grow from inwards to outwards
2. Each iteration place the minimum element to the correct position to its left, shifting the entire left part
3. Start the outer loop from 1st indexed element

eg: { 55, 42, 14, 96, 24, 5, 988, -55, 24}

iterations: 
1. { 42, 55, 14, 96, 24, 5, 988, -55, 24}
2. { 14, 42, 55, 96, 24, 5, 988, -55, 24}
3. { 14, 42, 55, 96, 24, 5, 988, -55, 24}
4. { 14, 24, 42, 55, 96, 5, 988, -55, 24}
5. { 5, 14, 24, 42, 55, 96, 988, -55, 24}
6. { 5, 14, 24, 42, 55, 96, 988, -55, 24}
7. { -55, 5, 14, 24, 42, 55, 96, 988, 24}
8. { -55, 5, 14, 24, 24, 42, 55, 96, 988}

*/

public class InsertionSort {

	private static void performInsertionSort(int[] array) {
		int i, j, current_value, n = array.length;
		for(i=1; i<n; i++) {
			current_value = array[i];
			j = i-1;
			while(j>=0 && array[j] > current_value) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = current_value;
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		performInsertionSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}
	
}
