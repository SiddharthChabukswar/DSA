package GFG.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=overlapping_intervals

Given a collection of Intervals, the task is to merge all of the overlapping Intervals.

Example 1:

Input:
Intervals = {{1,3},{2,4},{6,8},{9,10}}
Output: {{1, 4}, {6, 8}, {9, 10}}
Explanation: Given intervals: [1,3],[2,4]
[6,8],[9,10], we have only two overlapping
intervals here,[1,3] and [2,4]. Therefore
we will merge these two and return [1,4],
[6,8], [9,10].
Example 2:

Input:
Intervals = {{6,8},{1,9},{2,4},{4,7}}
Output: {{1, 9}}
Your Task:
Complete the function overlappedInterval() that takes the list N intervals as input parameters and returns sorted list of intervals after merging.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(Log(N)) or O(N).

Constraints:
1 ≤ N ≤ 100
0 ≤ x ≤ y ≤ 1000

[1, 9]
[2, 4]
[4, 7]
[6, 8]

{1,3}
{2,4}
{6,8}
{9,10}
{9,15}

{1,4}, {6,8}, {9,15}

*/

public class Overlapping_Intervals {

	public int[][] overlappedInterval(int[][] Intervals) {
		Comparator<int[]> pairComparator = (int[] interval1, int[] interval2) -> interval1[0]-interval2[0];
		Arrays.sort(Intervals, pairComparator);
		// for(int[] interval: Intervals) System.out.println(Arrays.toString(interval));
		List<int[]> outputList = new ArrayList<int[]>();
		int[] mergedPair;
		int i = 0, j, n = Intervals.length, max_ele;
		while(i<n) {
			mergedPair = new int[2];
			mergedPair[0] = Intervals[i][0];
			max_ele = Intervals[i][1];
			j = i+1;
			while(j<n && Intervals[j][0] < max_ele) max_ele = Math.max(max_ele, Intervals[j][1]);
			mergedPair[1] = max_ele;
			outputList.add(mergedPair);
			i = j;
		}
		n = outputList.size();
		i = 0;
		int[][] outputArray = new int[n][2];
		for(int[] outputPair: outputList) outputArray[i++] = outputPair;
 		return outputArray;
	}


}