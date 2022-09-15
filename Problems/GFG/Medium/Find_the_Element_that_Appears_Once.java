package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/element-appearing-once2552/0?company[]=Qualcomm&company[]=Qualcomm&difficulty[]=1&page=1&query=company[]Qualcommdifficulty[]1page1company[]Qualcomm&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=element-appearing-once

Given a sorted array A[] of N positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.

Example 1:

Input:
N = 5
A = {1, 1, 2, 5, 5}
Output: 2
Explanation: 
Since 2 occurs once, while
other numbers occur twice, 
2 is the answer.
Example 2:

Input:
N = 7
A = {2, 2, 5, 5, 20, 30, 30}
Output: 20
Explanation:
Since 20 occurs once, while
other numbers occur twice, 
20 is the answer.
Your Task:
You don't need to read input or print anything. Your task is to complete the function search() which takes two arguments(array A and integer N) and returns the number occurring only once.

Expected Time Complexity: O(Log(N)).
Expected Auxiliary Space: O(1).

Constraints
0 <   N  <= 10^6
0 <= A[i] <= 10^9

*/

public class Find_the_Element_that_Appears_Once {

	public static int search(int A[], int N) {
		if(N==1) return A[0];
		int left=0, right=N-1, mid;
		while(right >= left) {
			mid = (left + right)/2;
			if(mid == 0) {
				if(A[mid] != A[mid+1]) return A[mid];
			}else if(mid == N-1){
				if(A[mid] != A[mid-1]) return A[mid];
			}else {
				if(A[mid] == A[mid-1]) {
					if((mid-left+1)%2 != 0) {
						right = mid;
					}else {
						left = mid+1;
					}
				}else if(A[mid] == A[mid+1]) {
					if((right-mid+1)%2 != 0) {
						left = mid;
					}else {
						right = mid-1;
					}
				}else return A[mid];
			}
		}
		return 0;
	}
	
	
}
