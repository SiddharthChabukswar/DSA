package LeetCode.Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/sort-characters-by-frequency/

451. Sort Characters By Frequency

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:

1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.

*/

public class _451 {

	HashMap<Character, Integer> getFrequencyMap(String s) {
		HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();
		Integer val;
		for(Character key: s.toCharArray()) {
			val = freqMap.get(key);
			if(val == null) val = 0;
			freqMap.put(key, ++val);
		}
		return freqMap;
	}

	PriorityQueue<Character> getKeySortedValQueue(HashMap<Character, Integer> freqMap) {
		PriorityQueue<Character> keySortedValQueue;
		keySortedValQueue = new PriorityQueue<Character>(new Comparator<Character>() {
			@Override
			public int compare(Character key1, Character key2) {
				return freqMap.get(key2) - freqMap.get(key1);
			}
		});
		for(Character key: freqMap.keySet()) keySortedValQueue.offer(key);
		return keySortedValQueue;
	}

	public String frequencySort(String s) {
		HashMap<Character, Integer> freqMap = getFrequencyMap(s);
		PriorityQueue<Character> keySortedValQueue = getKeySortedValQueue(freqMap);
		StringBuilder answerStringBuilder = new StringBuilder();
		Character key;
		Integer val;
		while(keySortedValQueue.isEmpty() == false) {
			key = keySortedValQueue.poll();
			val = freqMap.get(key);
			while(val>0) {
				answerStringBuilder.append(key);
				val--;
			}
		}
		return answerStringBuilder.toString();
	}
	
}
