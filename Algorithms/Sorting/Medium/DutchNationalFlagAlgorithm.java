package Algorithms.Sorting.Medium;

/*

Purpose: Sort an unsorted array of only 3 distinct elements (0, 1, 2)
Time complexity: O(n)

Approach:

1. Initialize the 3 pointers such that low and mid will point to 0th index and high pointer will point to last index
2. Now there will 3 different operations / steps based on the value of arr[mid] and will be repeated until mid <= high.
	a. arr[mid] == 0:
		swap(arr[low], arr[mid])
		low++, mid++
	b. arr[mid] == 1:
		mid++
	c. arr[mid] == 2:
		swap(arr[mid], arr[high])
		high–;
3.The array formed after these steps will be a sorted array.

*/

public class DutchNationalFlagAlgorithm {
	
	private static void performDutchNationalFlagSort(int[] array) {
		int low = 0, mid = 0, high = array.length-1, temp;
		while(mid <= high) {
			if(array[mid] == 2) {
				temp = array[mid];
				array[mid] = array[high];
				array[high] = temp;
				high--;
			}else if(array[mid] == 0) {
				temp = array[low];
				array[low] = array[mid];
				array[mid] = temp;
				low++;
				mid++;
			}else {
				mid++;
			}

		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 2, 0, 1, 1, 0, 2, 1, 0, 0, 2};
		System.out.print("Unsorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		performDutchNationalFlagSort(array);
		System.out.print("Sorted array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
	}

}
