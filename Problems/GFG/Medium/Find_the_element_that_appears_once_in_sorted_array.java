package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-the-element-that-appears-once-in-sorted-array

Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 

Example 1:

Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that 
appears exactly once.
 

Your Task:  
You don't need to read input or print anything. Complete the function findOnce() which takes sorted array and its size as its input parameter and returns the element that appears only once. 


Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
-105 <= arr[i] <= 105

*/

public class Find_the_element_that_appears_once_in_sorted_array {

	int findOnce(int arr[], int n) {
		int low = 0, high = n-1, mid;
		while(low <= high) {
			mid = (low+high)/2;
			if(mid!=0 && arr[mid]==arr[mid-1]) {
				if((mid-low+1)%2 == 0) low = mid+1;
				else high = mid-1;
			} else if(mid!=n-1 && arr[mid] == arr[mid]+1) {
				if((high-mid+1)%2 == 0) high = mid-1;
				else low = mid+1;
			} else return arr[mid];
		}
		return -1;
	}

}