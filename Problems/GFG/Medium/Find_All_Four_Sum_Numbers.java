package GFG.Medium;

import java.util.ArrayList;
import java.util.Arrays;

/*

https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-all-four-sum-numbers

Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.
Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function fourSum() which takes the array arr[] and the integer k as its input and returns an array containing all the quadruples in a lexicographical manner. Also note that all the quadruples should be internally sorted, ie for any quadruple [q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.  (In the output each quadruple is separate by $. The printing is done by the driver's code)

Expected Time Complexity: O(N3).
Expected Auxiliary Space: O(N2).

Constraints:
1 <= N <= 100
-1000 <= K <= 1000
-100 <= A[] <= 100

*/

public class Find_All_Four_Sum_Numbers {

	public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
		ArrayList<ArrayList<Integer>> fourSumLists = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> fourSumList;
		Arrays.sort(arr);
		int n = arr.length, i, j, low, high;
		long sum;
		for(i=0; i<n-3; i++) {
			if(i!=0 && arr[i] == arr[i-1]) continue;
			for(j=i+1; j<n-2; j++) {
				if(j!=i+1 && arr[j] == arr[j-1]) continue;
				low = j+1;
				high = n-1;
				while(low < high) {
					sum = ((long)arr[i] + (long)arr[j] + (long)arr[low] + (long)arr[high]);
					if(sum == k) {
						fourSumList = new ArrayList<Integer>();
						for(int a: new int[]{arr[i], arr[j], arr[low], arr[high]}) fourSumList.add(a);
						fourSumLists.add(fourSumList);
						do {
							low++;
						} while(low < high && arr[low] == arr[low-1]);
						do {
							high--;
						} while(low < high && arr[high] == arr[high+1]);
					}
					else if(sum < k) {
						do {
							low++;
						} while(low < high && arr[low] == arr[low-1]);
					} else {
						do {
							high--;
						} while(low < high && arr[high] == arr[high+1]);
					}
				}
			}
		}
		return fourSumLists;
	}

}