package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=capacity-to-ship-packages-within-d-days

Given an array arr[] of N weights. Find the least weight capacity of a boat to ship all weights within D days.
The ith weight has a weight of arr[i]. Each day, we load the boat with weights given by arr[i].We may not load more weight than the maximum weight capacity of the ship.

Note: You have to load weights on the boat in the given order.

 

Example 1:

Input:
N = 3
arr[] = {1, 2, 1}
D = 2
Output:
3
Explanation:
We can ship the weights in 2 days
in the following way:-
Day 1- 1,2
Day 2- 1
Example 2:
Input:
N = 3
arr[] = {9, 8, 10}
D = 3
Output:
10
Explanation:
We can ship the weights in 3 days
in the following way:-
Day 1- 9
Day 2- 8
Day 3- 10
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function leastWeightCapacity() which takes 2 integers N, and D, and an array arr of size N as input and returns the least weight capacity of the boat required.


Expected Time Complexity: O(N*log(Sum of weights - max(list of weights))
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ D ≤ N ≤ 105
1 ≤ arr[i] ≤ 500

*/

public class Capacity_To_Ship_Packages_Within_D_Days {

	static int getDaysRequired(int[] arr, int capacity) {
		int days = 0, curr_sum = 0;
		for(int i=0; i<arr.length; i++) {
			curr_sum += arr[i];
			if(curr_sum > capacity) {
				curr_sum = arr[i];
				days++;
			}
		}
		days++;
		return days;
	}

	static int leastWeightCapacity(int[] arr, int N, int D) {
		int low = Integer.MIN_VALUE, high = 0, mid, daysRequired;
		for(int i=0; i<N; i++) {
			low = Math.max(low, arr[i]);
			high += arr[i];
		}
		while(low <= high) {
			mid = low + (high-low)/2;
			daysRequired = getDaysRequired(arr, mid);
			if(daysRequired <= D) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

}