package Algorithms.Z_Extra.Easy;

/*

Purpose: Find the contiguous sub-array(containing at least one number) which has the maximum sum and return its sum.
Time complexity: O(n)

Approach:

1. Set a global_sum and local_sum pointer to MIN_VALUE
2. traverse the array and check local_sum = MAX(local_sum+arr[i], arr[i]), i.e. to include the element in the sum or start over from that element
3. set global_sum = MAX(local_sum, global_sum)

i/p: [1, 2, 3, -2, 5]
o/p: 9

*/

public class KadaneAlgorithm {
	
	public static long getMaxSumSubArray(int[] arr) {
		long global_max = arr[0], local_max = arr[0];
		int n = arr.length;
		for(int i=1; i<n; i++) {
			local_max = Math.max(local_max + arr[i], arr[i]);
			global_max = Math.max(local_max, global_max);
		}
		return global_max;
	}

	public static void main(String[] args) {
		int[] array = new int[]{ 1, 2, 3, -2, 5 };
		System.out.print("Given array: ");
		for(int element: array) System.out.print(element + ", ");
		System.out.println();
		long max_sum = getMaxSumSubArray(array);
		System.out.print("Max sum sub array: " + max_sum);
		System.out.println();
	}

}
