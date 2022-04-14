package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/merge-sorted-array/

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?

*/

public class eightyeight {
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if(n == 0) return;
		
		// Comparing the largest from the back and adding it from behind O(n)
		int i = m-1, j = n-1, k = m+n-1, val1, val2;
		while(i>=0 && j>=0){
			val1 = nums1[i];
			val2 = nums2[j];
			if(val1 > val2) nums1[k--] = nums1[i--];
			else nums1[k--] = nums2[j--];
		}
		while(j>=0) nums1[k--] = nums2[j--];


		// Comparing the shortest element from the front O(m+n)
		// Requires extra space of m+n
		/*
		int[] answer = new int[m+n];
		int i = 0, j = 0, k = 0, val1, val2;
		while(i<m && j<n){
			val1 = nums1[i];
			val2 = nums2[j];
			if(val1 < val2){
				answer[k++] = val1;
				i++;
			}
			else{
				answer[k++] = val2;
				j++;
			}
		}
		while(i<m) answer[k++] = nums1[i++];
		while(j<n) answer[k++] = nums2[j++];
		k = 0;
		while(k<(m+n)) nums1[k] = answer[k++];
		*/

		System.out.println("Sorted final array: ");
		for(i=0; i<m+n; i++) System.out.println(nums1[i]);
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter m: ");
		int m = sc.nextInt();
		System.out.print("Enter n:");
		int n = sc.nextInt();
		int[] nums1 = new int[m+n];
		int[] nums2 = new int[n];
		System.out.println("Enter elements of nums1: ");
		for(int i=0; i<m; i++) nums1[i] = sc.nextInt();
		System.out.println("Enter elements of nums2: ");
		for(int i=0; i<n; i++) nums2[i] = sc.nextInt();
		eightyeight objEightyeight = new eightyeight();
		objEightyeight.merge(nums1, m, nums2, n);
		sc.close();
	}
}
