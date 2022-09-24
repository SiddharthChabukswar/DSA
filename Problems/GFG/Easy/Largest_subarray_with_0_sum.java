package GFG.Easy;

import java.util.HashMap;

/*

https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1?category[]=Hash&category[]=Hash&company[]=Amazon&company[]=Amazon&page=1&query=category[]Hashcompany[]Amazonpage1company[]Amazoncategory[]Hash&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-subarray-with-0-sum

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i

*/

public class Largest_subarray_with_0_sum {

	int maxLen(int arr[], int n) {
		int[] prefix_sum_arr = new int[n+1];
		int i, curr_sum, max_len = Integer.MIN_VALUE;
		prefix_sum_arr[0] = 0;
		HashMap<Integer, Integer> latestOccurence = new HashMap<Integer, Integer>();
		latestOccurence.put(0, 0);
		Integer value;
		for(i=1; i<n+1; i++) {
			curr_sum = arr[i-1] + prefix_sum_arr[i-1];
			prefix_sum_arr[i] = curr_sum;
			latestOccurence.put(curr_sum, i);
		}
		for(i=0; i<n+1; i++) {
			value = latestOccurence.get(prefix_sum_arr[i]);
			System.out.println(prefix_sum_arr[i] + " " + value);
			max_len = Math.max(max_len, value-i-1);
		}
		return max_len;
	}

}