package LeetCode.Easy;

// import java.util.ArrayList;
// import java.util.List;

/*

https://leetcode.com/problems/number-complement/

The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

 

Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 

Constraints:

1 <= num < 231
 

Note: This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

*/

public class fourhundredandseventysix {
	
	// Brute force O(n)
	/*
	public int findComplement(int num) {
		int answer = 0;
		List<Integer> bit_array = new ArrayList<Integer>();
		while(num!=0){
			if(num%2 == 0) bit_array.add(1);
			else bit_array.add(0);
			num = num>>1;
		}

		int blen = bit_array.size(), i;
		System.out.println(bit_array.toString());
		for(i = blen-1; i>=0; i--){
			answer += bit_array.get(i);
			answer = answer<<1;
		}
		return answer;
	}
	*/

	// Negate method
	public int findComplement(int num) {
		long pow2 = 1;
		while(pow2 <= num) pow2 *= 2;
		pow2 /= 2;
		pow2 = pow2 - 1;
		return ~num & (int)pow2;
	}
}
