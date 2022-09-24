package GFG.Medium;

import java.util.HashMap;

/*


https://www.geeksforgeeks.org/count-number-subarrays-given-xor/

https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/

Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to B.

Examples:

Input Format:  A = [4, 2, 2, 6, 4] , B = 6
Result: 4
Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Input Format: A = [5, 6, 7, 8, 9], B = 5
Result: 2
Explanation:The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]


*/

public class Count_the_number_of_subarrays_with_given_xor_K {

	static long subarrayXor(int arr[], int n, int m) {
		int i;
		Long numSubarrayXOR = 0l, prefixXOR = 0l, toCheckXOR, value;
		HashMap<Long, Long> xorCountYet = new HashMap<Long, Long>();
		for(i=0; i<n; i++) {
			prefixXOR = prefixXOR ^ (long)arr[i];
			if(prefixXOR == (long)m) numSubarrayXOR++;
			toCheckXOR = prefixXOR ^ (long)m;
			value = xorCountYet.get(toCheckXOR);
			if(value != null) numSubarrayXOR += value;
			value = xorCountYet.get(prefixXOR);
			if(value == null) value = 0l;
			xorCountYet.put(prefixXOR, ++value);
		}
		return numSubarrayXOR;
	}

}