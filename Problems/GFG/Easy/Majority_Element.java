package GFG.Easy;

import java.util.HashMap;

/*

https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=majority-element

Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 

Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation:
Since, each element in 
{1,2,3} appears only once so there 
is no majority element.
Example 2:

Input:
N = 5 
A[] = {3,1,3,3,2} 
Output:
3
Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element.

Your Task:
The task is to complete the function majorityElement() which returns the majority element in the array. If no majority exists, return -1.
 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 

Constraints:
1 ≤ N ≤ 107
0 ≤ Ai ≤ 106

*/

public class Majority_Element {

	// HashMap solution O(n)
	static int majorityElement(int a[], int size) {
		HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		Integer value, answer = -1;
		for(int ele: a) {
			value = frequencyMap.get(ele);
			if(value == null) value = 0;
			frequencyMap.put(ele, ++value); 
		}
		for(Integer key: frequencyMap.keySet()){
			value = frequencyMap.get(key);
			if(value > (size/2)) answer = key;
		}
		return answer;
	}

}