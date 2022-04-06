package LeetCode.Easy;

import java.util.Arrays;
import java.util.Scanner;

/*

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

*/


public class fourteen {

	public String longestCommonPrefix(String[] strs) {

		// Array Lexographic sort O(n*logn) - Compare first and last lexographically sorted strings
		String answer = "", first = strs[0], last = strs[0];
		Arrays.sort(strs);
		first = strs[0];
		last = strs[strs.length - 1];
		int minLenString = first.length(), i;
		for(i=0; i<minLenString; i++){
			if(first.charAt(i)!=last.charAt(i)) break;
		}
		answer = first.substring(0, i);

		// Naive: Compare all strings O(n^2)
		/*
		int totalStrings = strs.length, minLenString = 201, tempStrLength = 0, minString = -1;
		for(int i=0; i<totalStrings; i++){
			tempStrLength = strs[i].length();
			if(minLenString>tempStrLength){
				minLenString = tempStrLength;
				minString = i;
			}
		}
		boolean done = false;
		for(int i=0; i<minLenString; i++){
			char curr = strs[minString].charAt(i);
			for(int j=0; j<totalStrings; j++){
				if(strs[j].charAt(i) != curr){
					done = true;
					break;
				}
			}
			if(done == true) break;
			else answer = answer + curr;
		}
		*/
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] strs = new String[n];
		for(int i=0; i<n; i++){
			strs[i] = sc.next();
		}
		fourteen objFourteen = new fourteen();
		System.out.print(objFourteen.longestCommonPrefix(strs));
		sc.close();
	}
	
}
