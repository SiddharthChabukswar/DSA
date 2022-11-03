package GFG.Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/* 

Given an array A[] of integers, sort the array according to frequency of elements. That is elements that have higher frequency come first. If frequencies of two elements are same, then smaller number comes first.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
For each testcase, in a new line, print each sorted array in a seperate line. For each array its numbers should be seperated by space.

Constraints:
1 ≤ T ≤ 70
1 ≤ N ≤ 130
1 ≤ Ai ≤ 60 

Example:
Input:
2
5
5 5 4 6 4
5
9 9 9 2 5

Output:
4 4 5 5 6
9 9 9 2 5

Explanation:
Testcase1: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are same then smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6.
The output is 4 4 5 5 6.

Testcase2: The highest frequency here is 3. The element 9 has the highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same frequency. So we print smaller element first.
The output is 9 9 9 2 5.

*/

public class Sorting_Elements_of_an_Array_by_Frequency {

	static HashMap<Integer, Integer> getFrequencyMap(int n, int[] arr) {
		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		Integer key, val;
		for(int i=0; i<n; i++) {
			key = arr[i];
			val = freqMap.get(key);
			if(val == null) val = 0;
			freqMap.put(key, ++val);
		}
		return freqMap;
	}

	static void sortArrayByFrequency(int n, int[] arr) {
		HashMap<Integer, Integer> freqMap = getFrequencyMap(n, arr);
		PriorityQueue<Integer> sortedKeysByValuesQueue;
		sortedKeysByValuesQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer key1, Integer key2) {
				Integer diffInVal = freqMap.get(key2)-freqMap.get(key1);
				if(diffInVal.equals(0) == true) return key1-key2;
				return diffInVal;
			};	
		});
		for(Integer key: freqMap.keySet()) sortedKeysByValuesQueue.offer(key);
		Integer key, val;
		while(sortedKeysByValuesQueue.isEmpty() == false) {
			key = sortedKeysByValuesQueue.poll();
			val = freqMap.get(key);
			while(val>0){
				System.out.print(key + " ");
				val--;
			}
		}
	}

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), arrLen, i;
		int[] arr;
		while(n!=0) {
			arrLen = sc.nextInt();
			arr = new int[arrLen];
			for(i=0; i<arrLen; i++) arr[i] = sc.nextInt();
			sortArrayByFrequency(arrLen, arr);
			System.out.println();
			arr = null;
			n--;
		}
	}

}