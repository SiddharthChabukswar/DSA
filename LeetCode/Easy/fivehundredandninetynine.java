package LeetCode.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*

https://leetcode.com/problems/minimum-index-sum-of-two-lists/

Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.

 

Example 1:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
Output: ["Shogun"]
Explanation: The only common string is "Shogun".
Example 2:

Input: list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
Output: ["Shogun"]
Explanation: The common string with the least index sum is "Shogun" with index sum = (0 + 1) = 1.
Example 3:

Input: list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
Output: ["sad","happy"]
Explanation: There are three common strings:
"happy" with index sum = (0 + 1) = 1.
"sad" with index sum = (1 + 0) = 1.
"good" with index sum = (2 + 2) = 4.
The strings with the least index sum are "sad" and "happy".
 

Constraints:

1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i] and list2[i] consist of spaces ' ' and English letters.
All the strings of list1 are unique.
All the strings of list2 are unique.

*/

public class fivehundredandninetynine {
	
	// HashMap Approach O(len(list1 + list2))
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> list2_indices_map = new HashMap<String, Integer>();
		for(int index=0; index<list2.length; index++) list2_indices_map.put(list2[index], index);
		int min_index_sum = Integer.MAX_VALUE;
		Integer value = null;
		List<String> answerList = new ArrayList<String>();
		for(int index=0; index<list1.length; index++) {
			value = list2_indices_map.get(list1[index]);
			if(value == null) continue;
			else {
				if(min_index_sum > (index + value)) {
					min_index_sum = index+value;
					answerList.clear();
					answerList = new ArrayList<String>();
				}
				if(min_index_sum == (index + value)) {
					answerList.add(list1[index]);
				}
			}
		}
		String[] answer = new String[answerList.size()];
		answer = answerList.toArray(answer);
		return answer;
	}
}
