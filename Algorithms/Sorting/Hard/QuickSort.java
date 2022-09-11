package Algorithms.Sorting.Hard;

/*

Purpose: Sort an unsorted array
Time complexity: O(n^2) (Worst case)

Approach:

1. Divide and Conquer strategy
2. Select a pivot element : (First, Last, Median, Random element of the array)
3. Place all the elements lesser than pivot to its left and greater elements to its right
4. Place the pivot in correct position and then divide the array from pivot
5. repeat for all the elements as pivots
eg: { 55, 42, 14, 96, 24, 5, 988, -55, 24 }

iterations :: Pivot as first element: 
{ -55, 42, 14, 24, 24, 5, 55d, 988, 96 }
{ -55d, 42, 14, 24, 24, 5, 55d, 988, 96 }
{ -55d, 5, 14, 24, 24, 42d, 55d, 988, 96 }
{ -55d, 5d, 14, 24, 24, 42d, 55d, 988, 96 }
{ -55d, 5d, 14d, 24, 24, 42d, 55d, 988, 96 }
{ -55d, 5d, 14d, 24d, 24, 42d, 55d, 988, 96 }
{ -55d, 5d, 14d, 24d, 24d, 42d, 55d, 988, 96 }
{ -55d, 5d, 14d, 24d, 24d, 42d, 55d, 96, 988d }
{ -55d, 5d, 14d, 24d, 24d, 42d, 55d, 96d, 988d }

{ -55, 5, 14, 24, 24, 42, 55, 96, 988 }

*/

public class QuickSort {

	public static int partition(int arr[], int low, int high) {
		// System.out.println(low + " : " + high);
		int pivot_index = high, pivot = arr[high], temp = 0;
		while(high > low) {
			while(low < high && arr[low] <= pivot) low++;
			while(high > low && arr[high] >= pivot) high--;
			if(high > low) {
				temp = arr[high];
				arr[high] = arr[low];
				arr[low] = temp;
			}
		}
		temp = arr[high];
		arr[high] = pivot;
		arr[pivot_index] = temp;
		return high;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if(high <= low) return;
		int mid = partition(arr, low, high);
		quickSort(arr, low, mid-1);
		quickSort(arr, mid+1, high);
	}

	public static void performQuickSort(int[] arrays) {
		quickSort(arrays, 0, arrays.length-1);
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 55, 42, 14, 96, 24, 5, 988, -55, 24};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		performQuickSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}
	
}
