package GFG.Medium;

/*

Given an array of size N. The task is to rotate array by D elements where D ≤ N.

Example 1:

Input:
N = 7
Arr[] = {1, 2, 3, 4, 5, 6, 7}
D = 2
Output: 3 4 5 6 7 1 2
Explanation: 
Rotate by 1: [2, 3, 4, 5, 6, 7, 1]
Rotate by 2: [3, 4, 5, 6, 7, 1, 2]

Example 2:

Input:
N = 4
Arr[] = {1, 3, 4, 2}
D = 3
Output: 2 1 3 4

Your Task:
You don't need to read input or print anything. Your task is to complete the function leftRotate() which takes the array of integers arr[], its size n and d as input parameters and rotates arr[] in-place without using any extra memory.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ 1000
0 ≤ D ≤ N

{1, 2, 3, 4, 5, 6, 7} D=2 || OP: {3, 4, 5, 6, 7, 1, 2}
*/

public class Rotating_An_Array {

	// Dividing the array into GCD(n, k) segments and working on each // Swapping technique
	int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}

	void leftRotate(int[] arr, int n, int d) {
		if(d==0 || d==n) return;
		int segments_to_work = gcd(n, d), i, prev_idx, prev_val, new_idx, new_val;
		for(i=0; i<segments_to_work; i++) {
			prev_idx = i;
			prev_val = arr[i];
			do{
				new_idx = prev_idx - d;
				if(new_idx < 0) new_idx += n;
				new_val = arr[new_idx];
				arr[new_idx] = prev_val;
				prev_idx = new_idx;
				prev_val = new_val;
			}while(prev_idx != i);
		}
	}

	// Reverse each half and the reverse entire array: O(n)
	/*
	void reverseArray(int[] arr, int start, int end) {
		int temp;
		end = end-1;
		while(end > start) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	void leftRotate(int[] arr, int n, int d) {
		if(d == n) return;
		reverseArray(arr, 0, d);
		reverseArray(arr, d, n);
		reverseArray(arr, 0, n);
	}
	*/
	
}
