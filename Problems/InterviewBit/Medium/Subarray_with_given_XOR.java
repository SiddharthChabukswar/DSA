package InterviewBit.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * https://www.interviewbit.com/problems/subarray-with-given-xor/
 */

/*

Problem Description
 
 

Given an array of integers A and an integer B.

Find the total number of subarrays having bitwise XOR of all elements equals to B.



Problem Constraints
1 <= length of the array <= 105

1 <= A[i], B <= 109



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the total number of subarrays having bitwise XOR equals to B.



Example Input
Input 1:

 A = [4, 2, 2, 6, 4]
 B = 6
Input 2:

 A = [5, 6, 7, 8, 9]
 B = 5


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The subarrays having XOR of their elements as 6 are:
 [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]
Explanation 2:

 The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 
*/

public class Subarray_with_given_XOR {

	public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> xorCount = new HashMap<>();
        Integer currXor = 0, diffXor = 0, count = 0, freq;
        for (Integer a: A) {
            currXor = currXor ^ a;
            if (currXor == B) {
                count++;
            }
            diffXor = currXor ^ B;
            freq = xorCount.get(diffXor);
            if (freq != null) {
                count += freq;
            } 
            freq = xorCount.get(currXor);
            freq = (freq == null) ? 1 : freq+1;
            xorCount.put(currXor, freq);
        }
        return count;
    }

}