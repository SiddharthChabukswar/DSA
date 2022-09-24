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

	public int[][] merge(int[][] intervals) {
		Comparator<int[]> pairComparator = (int[] pair1, int[] pair2) -> pair1[0] - pair2[0];
		Arrays.sort(intervals, pairComparator);
		List<int[]> answerList = new ArrayList<int[]>();
		int[] answerPair;
		int i = 0, j = 0, n = intervals.length, max_ele;
		while(i<n) {
			answerPair = new int[2];
			answerPair[0] = intervals[i][0];
			max_ele = intervals[i][1];
			j = i+1;
			while(j<n && intervals[j][0] <= max_ele) max_ele = Math.max(max_ele, intervals[j++][1]);
			answerPair[1] = max_ele;
			i = j;
			answerList.add(answerPair);
			// System.out.println(answerPair[0] + " " + answerPair[1]);
		}
		n = answerList.size();
		i = 0;
		int[][] answerArray = new int[n][2];
		for(int[] ansPair: answerList) {
			answerArray[i++] = ansPair;
		}
		return answerArray;
	}
	
}
