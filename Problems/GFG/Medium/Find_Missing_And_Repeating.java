package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-missing-and-repeating

Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 105
1 ≤ Arr[i] ≤ N

*/

public class Find_Missing_And_Repeating {

	int[] findTwoElement(int arr[], int n) {
		int sum = 0, idx=-1, exp_sum;
		if(n%2 == 0) exp_sum = (n/2)*(n+1);
		else exp_sum = (n)*((n+1)/2);
		for(int a: arr) sum += a;
		for(int i=0; i<n; i++) {
			idx = Math.abs(arr[i])-1;
			if(arr[idx] < 0) break;
			else arr[idx] = -1*arr[idx];
		}
		sum -= (idx+1);
		return new int[]{idx+1, exp_sum-sum};
	}

}