package Algorithms.Sorting.Medium;

/*

Purpose: Sort an unsorted array
Time complexity: O(n^2)

Approach:

See: https://www.geeksforgeeks.org/recursive-insertion-sort/

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

public class RecursiveInsertionSort {

	private static void performInsertionSort(int[] arr, int n) {
		if(n==1) return;
		performInsertionSort(arr, n-1);
		int j, current_value;
		current_value = arr[n-1];
		j = n-2;
		while(j>=0 && arr[j] > current_value) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = current_value;
	}

	private static void recursiveInsertionSort(int[] array) {
		performInsertionSort(array, array.length);
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		recursiveInsertionSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}
	
}
