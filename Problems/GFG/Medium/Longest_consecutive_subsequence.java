package GFG.Medium;

import java.util.HashSet;
// import java.util.SortedSet;
// import java.util.TreeSet;

/*

https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/0?problemType=functional&page=1&query=problemTypefunctionalpage1&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-consecutive-subsequence

Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= N <= 105
0 <= a[i] <= 105

*/

public class Longest_consecutive_subsequence {

	// HashSet Approach O(n) - Still slower
	static int findLongestConseqSubseq(int arr[], int N) {
		HashSet<Integer> presentElements = new HashSet<Integer>();
		for(Integer a: arr) presentElements.add(a);
		Integer count, max_count;
		count = max_count = 0;
		for(int i=0; i<100001; i++) {
			if(presentElements.contains(i)) {
				if(presentElements.contains(i-1)) count++;
				else count = 1;
			}else{
				count = 1;
			}
			max_count = Math.max(count, max_count);
		}
		return max_count;
	}

	// Sorted Set approach O(nlogn)
	/*
	static int findLongestConseqSubseq(int arr[], int N) {
		SortedSet<Integer> sortedSet = new TreeSet<Integer>();
		for(Integer a: arr) sortedSet.add(a);
		Integer count = 1, max_count = Integer.MIN_VALUE;
		Integer prev = -2;
		for(Integer element: sortedSet) {
			if((element - prev) == 1) count++;
			else count = 1;
			prev = element;
			max_count = Math.max(count, max_count);
		}
		return max_count;
	}
	*/

}