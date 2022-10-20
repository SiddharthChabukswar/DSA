package LeetCode.Hard;

/*

https://leetcode.com/problems/median-of-two-sorted-arrays/

4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

*/

public class _4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
		int n1len = nums1.length, n2len = nums2.length;
		int low, high, cut1, cut2, median = (n1len+n2len)/2;
		int l1, l2, r1, r2;
		low = 0;
		high = n1len;
		while(low <= high) {
			cut1 = low + (high-low)/2;
			cut2 = median - cut1;
			l1 = (cut1 == 0)?Integer.MIN_VALUE:nums1[cut1-1];
			r1 = (cut1 == n1len)?Integer.MAX_VALUE:nums1[cut1];
			l2 = (cut2 == 0)?Integer.MIN_VALUE:nums2[cut2-1];
			r2 = (cut2 == n2len)?Integer.MAX_VALUE:nums2[cut2];
			if(l1 <= r2 && l2 <= r1) {
				if((n1len+n2len)%2 == 0) return (double) (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
				else return (double) Math.min(r1, r2);
			}
			else if(l1 > r2) {
				high = cut1-1;
			} else {
				low = cut1+1;
			}
		}
		return 0.0;
	}
	
}
