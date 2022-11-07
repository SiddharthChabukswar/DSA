package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=count-number-of-substrings

Count number of substrings

Given a string of lowercase alphabets, count all possible substrings (not necessarily distinct) that have exactly k distinct characters. 


Example 1:

Input:
S = "aba", K = 2
Output:
3
Explanation:
The substrings are:
"ab", "ba" and "aba".
Example 2:

Input: 
S = "abaaca", K = 1
Output:
7
Explanation:
The substrings are:
"a", "b", "a", "aa", "a", "c", "a". 

Your Task:
You don't need to read input or print anything. Your task is to complete the function substrCount() which takes the string S and an integer K as inputs and returns the number of substrings having exactly K distinct characters.


Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).


Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ 26

*/

public class Count_number_of_substrings {

	long subStrAtmostK(String s, int k) {
		if(k == 0) return 0l;
		long count = 0l;
		int right = 0, left = 0, n = s.length(), size = 0;
		Character key;
		int[] charMap = new int[26];
		for(right = 0; right < n; right++) {
			key = s.charAt(right);
			if(charMap[key - 'a']++ == 0) size++;
			while(size > k) {
				key = s.charAt(left);
				if(--charMap[key - 'a'] == 0) size--;
				left++;
			}
			count += (long) (right-left+1);
		}
		return count;
	}

	long substrCount(String s, int k) {
		return subStrAtmostK(s, k) - subStrAtmostK(s, k-1);
	}

}