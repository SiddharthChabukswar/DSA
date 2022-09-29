package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/peak-element/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=peak-element

An element is called a peak element if its value is not smaller than the value of its adjacent elements(if they exists).
Given an array arr[] of size N, Return the index of any one of its peak elements.
Note: The generated output will always be 1 if the index that you return is correct. Otherwise output will be 0. 


Example 1:

Input: 
N = 3
arr[] = {1,2,3}
Possible Answer: 2
Generated Output: 1
Explanation: index 2 is 3.
It is the peak element as it is 
greater than its neighbour 2.
If 2 is returned then the generated output will be 1 else 0.
Example 2:

Input:
N = 2
arr[] = {3,4}
Possible Answer: 1
Output: 1
Explanation: 4 (at index 1) is the 
peak element as it is greater than 
its only neighbour element 3.
If 1 is returned then the generated output will be 1 else 0.
 

Your Task:
You don't have to read input or print anything. Complete the function peakElement() which takes the array arr[] and its size N as input parameters and return the index of any one of its peak elements.

Can you solve the problem in expected time complexity?

 

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ A[] ≤ 106

*/

public class Peak_element {

	int divideAndConquer(int[] arr, int low, int high) {
		int mid, left_opt, right_opt;
		if(low <= high) {
			mid = (low + high)/2;
			if(mid == 0) {
				if(arr[mid] >= arr[mid+1]) return mid;
				else return divideAndConquer(arr, mid+1, high);
			} else if(mid == arr.length-1) {
				if(arr[mid] >= arr[mid-1]) return mid;
				else return divideAndConquer(arr, low, mid-1);
			} else{
				if(arr[mid] >= arr[mid+1] && arr[mid] >= arr[mid-1]) return mid;
				left_opt = divideAndConquer(arr, low, mid-1);
				if(left_opt != -1) return left_opt;
				right_opt = divideAndConquer(arr, mid+1, high);
				if(right_opt != -1) return right_opt;
			}
		}
		return -1;
	}

	public int peakElement(int[] arr,int n) {
		if(arr.length == 1) return arr[0];
		return divideAndConquer(arr, 0, n-1);
	}

}