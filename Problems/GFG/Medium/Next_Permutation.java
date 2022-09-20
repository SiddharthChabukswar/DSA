package GFG.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://practice.geeksforgeeks.org/problems/next-permutation5226/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=next-permutation

Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.
Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.
Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10000

*/

public class Next_Permutation {

	// Better Approach O(nlogn)
	static List<Integer> nextPermutation(int N, int arr[]) {
		List<Integer> nextArr = new ArrayList<Integer>();
		int i, j, min_ele, min_ele_idx = -1, temp;
		i = N-2;
		while(i>=0) {
			j = i+1;
			if(arr[i] >= arr[j]) i--;
			else {
				min_ele = Integer.MAX_VALUE;
				min_ele_idx = -1;
				while(j<N) {
					if(arr[j] > arr[i] && min_ele > arr[j]) {
						min_ele = arr[j];
						min_ele_idx = j;
					}
					j++;
				}
				break;
			}
		}
		if(i<0) Arrays.sort(arr);
		else {
			j = min_ele_idx;
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			Arrays.sort(arr, i+1, N);
		}
		for(int a: arr) nextArr.add(a);
		return nextArr;
	}

	// O(n^2) Approach
	/*
	static List<Integer> nextPermutation(int N, int arr[]) {
		List<Integer> nextArr = new ArrayList<Integer>();
		int i, j, min_ele, min_ele_idx = -1, temp;
		i = N-2;
		j = 0;
		while(i>=0) {
			j = i+1;
			min_ele = Integer.MAX_VALUE;
			min_ele_idx = -1;
			while(j<N) {
				if(arr[j] > arr[i] && min_ele > arr[j]) {
					min_ele = arr[j];
					min_ele_idx = j;
				}
				j++;
			}
			if(min_ele_idx == -1) i--;
			else break;
		}
		if(i<0) Arrays.sort(arr);
		else {
			j = min_ele_idx;
			System.out.println(i + " " + j);
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			Arrays.sort(arr, i+1, N);
		}
		for(int a: arr) nextArr.add(a);
		return nextArr;
	}
	*/

}