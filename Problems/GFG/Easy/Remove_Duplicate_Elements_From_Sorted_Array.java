package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicate-elements-from-sorted-array

Given a sorted array A[] of size N, delete all the duplicated elements from A[].Update the array such that if there are X distinct elements in it then the first X positions of the array should be filled with them in increasing order.

Note: Don't use set or HashMap to solve the problem.

Example 1:

Input:
N = 5
Array = {2, 2, 2, 2, 2}
Output: 1
Explanation: After removing all the duplicates 
only one instance of 2 will remain.
Example 2:

Input:
N = 3
Array = {1, 2, 2}
Output: 2

Your Task:  
You don't need to read input or print anything. Complete the function remove_duplicate() which takes the array A[] and its size N as input parameters and modifies it in place to delete all the duplicates. The function must return an integer X denoting the new modified size of the array. 

Note: The generated output will print all the elements of the modified array from index 0 to X-1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 104
1 ≤ A[i] ≤ 106

[1, 2, 3, 3, 3, 4, 5, 9, 10, 10, 12]
[1, 2, 3, 3, 3, 4, 5, 9, 10, 10, 12]

1 2 3 3 3 4 5 9 10 10 12

*/

public class Remove_Duplicate_Elements_From_Sorted_Array {

	int remove_duplicate(int A[],int N){
		if(N==1) return 1;
		int ptr1=0, ptr2=1;
		while(ptr2<N) {
			if(A[ptr1] != A[ptr2]){
				ptr1++;
				A[ptr1] = A[ptr2];
			}
			ptr2++;
		}
		return ptr1;
	}

}