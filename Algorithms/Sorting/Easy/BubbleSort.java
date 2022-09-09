package Algorithms.Sorting.Easy;

/*

Purpose: Sort an unsorted array
Time complexity: O(n)

Approach:

1. Compare and swap adjacent elements, hence placing the max element in the last position in each iteration
2. Used two nested loops

{ 55, 42, 14, 96, 24, 5, 988, -55, 24}

*/

public class BubbleSort {

	private static void performBubbleSort(int[] array) {
		int i, j, temp, n = array.length;
		for(i=0; i<n; i++) {
			for(j=0; j<n-i-1; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		performBubbleSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}
	
}
