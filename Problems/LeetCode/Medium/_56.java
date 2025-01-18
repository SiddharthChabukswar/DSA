package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

https://leetcode.com/problems/merge-intervals/

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/

public class _56 {
	
	private void mergeSortedArrays(int[][] intervals, int left, int mid, int right) {
		int ptr1 = left, ptr2 = mid+1, ptr3 = 0;
		int[][] tempArray = new int[right-left+1][2];
		while (ptr1 <= mid && ptr2 <= right) {
			if (intervals[ptr1][0] < intervals[ptr2][0]) {
				tempArray[ptr3++] = intervals[ptr1++];
			} else if (intervals[ptr1][0] > intervals[ptr2][0]) {
				tempArray[ptr3++] = intervals[ptr2++];
			} else {
				if (intervals[ptr1][1] <= intervals[ptr2][1]) {
					tempArray[ptr3++] = intervals[ptr1++];
				} else {
					tempArray[ptr3++] = intervals[ptr2++];
				}
			}
		}
		while (ptr1 <= mid) {
			tempArray[ptr3++] = intervals[ptr1++];
		}
		while (ptr2 <= right) {
			tempArray[ptr3++] = intervals[ptr2++];
		}
		ptr3 = 0;
		while (ptr3 < (right-left+1)) {
			intervals[left+ptr3] = tempArray[ptr3];
			ptr3++;
		}
	}

	private void mergeSort(int[][] intervals, int left, int right) {
		if (left == right) return;
		int mid = (left+right)/2;
		mergeSort(intervals, left, mid);
		mergeSort(intervals, mid+1, right);
		mergeSortedArrays(intervals, left, mid, right);
	}

	public int[][] merge(int[][] intervals) {
		int itr = 1, n = intervals.length, left_bound, right_bound;
		if (n == 1) return intervals;

		mergeSort(intervals, 0, n-1);
		left_bound = intervals[0][0];
		right_bound = intervals[0][1];

		List<int[]> answerList = new ArrayList<int[]>();
		int[] answerPair;
		while (itr < n) {
			if (right_bound >= intervals[itr][0]) {
				right_bound = Math.max(right_bound, intervals[itr][1]);
			} else {
				answerPair = new int[2];
				answerPair[0] = left_bound;
				answerPair[1] = right_bound;
				answerList.add(answerPair);
			
				left_bound = intervals[itr][0];
				right_bound = intervals[itr][1];
			}
			itr++;
		}
		answerPair = new int[2];
		answerPair[0] = left_bound;
		answerPair[1] = right_bound;
		answerList.add(answerPair);
		
		n = answerList.size();
		int[][] mergedArray = new int[n][2];
		for (int i=0; i<n; i++) {
			mergedArray[i][0] = answerList.get(i)[0];
			mergedArray[i][1] = answerList.get(i)[1];
		}
		return mergedArray;
	}
	
}
