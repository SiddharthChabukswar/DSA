package LeetCode.Easy;

/*

https://leetcode.com/problems/kth-missing-positive-number/#:~:text=Given%20an%20array%20arr%20of,13%2C...%5D.

1539. Kth Missing Positive Number

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.

 

Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 1000
1 <= k <= 1000
arr[i] < arr[j] for 1 <= i < j <= arr.length
 

Follow up:

Could you solve this problem in less than O(n) complexity?

*/

public class _1539 {

	int getMissingCount(int curr, int idx) {
		return curr - (idx+1);
	}

	public int findKthPositive(int[] arr, int k) {
		int n = arr.length, low = 0, high = n-1, mid;
		while(low <= high) {
			mid = low + (high-low)/2;
			if(getMissingCount(arr[mid], mid) < k) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		if(high == -1) return k;
		return arr[high]+k-getMissingCount(arr[high], high);
	}
	
}
