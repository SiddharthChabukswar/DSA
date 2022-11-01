package GFG.Easy;

// import java.util.Arrays;

/*

https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-common-prefix-in-an-array

Given a array of N strings, find the longest common prefix among all strings present in the array.


Example 1:

Input:
N = 4
arr[] = {geeksforgeeks, geeks, geek,
         geezer}
Output: gee
Explanation: "gee" is the longest common
prefix in all the given strings.
Example 2:

Input: 
N = 2
arr[] = {hello, world}
Output: -1
Explanation: There's no common prefix
in the given strings.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestCommonPrefix() which takes the string array arr[] and its size N as inputs and returns the longest common prefix common in all the strings in the array. If there's no prefix common in all the strings, return "-1".


Expected Time Complexity: O(N*max(|arri|)).
Expected Auxiliary Space: O(max(|arri|)) for result.


Constraints:
1 ≤ N ≤ 103
1 ≤ |arri| ≤ 103

*/

public class Longest_Common_Prefix_in_an_Array {

	String longestCommonPrefix(String arr[], int n) {
		int maxCheck = Integer.MAX_VALUE;
		for(String a: arr) maxCheck = Math.min(maxCheck, a.length());
		Character currChar;
		String answer = "";
		Boolean loopBreak = false;
		for(int itr=0; itr<maxCheck; itr++) {
			currChar = arr[0].charAt(itr);
			for(int i=0; i<n; i++) {
				if(arr[i].charAt(itr) != currChar) {
					loopBreak = true;
					break;
				}
			}
			if(loopBreak == true) break;
			answer += currChar;
		}
		if(answer.length() == 0) answer = "-1";
		return answer;
	}

	// TLE - O(nlogn)
	/*
	String longestCommonPrefix(String arr[], int n) {
		Arrays.sort(arr);
		int maxlen = Math.min(arr[0].length(), arr[n-1].length());
		String answer = "";
		for(int itr=0; itr<maxlen; itr++) {
			if(arr[0].charAt(itr) == arr[n-1].charAt(itr)) answer += arr[0].charAt(itr);
			else break;
		}
		if(answer.length() == 0) return "-1";
		return answer;
	}
	*/
}