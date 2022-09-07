package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/lcm-and-gcd4516/1

Given two numbers A and B. The task is to find out their LCM and GCD.

 

Example 1:

Input:
A = 5 , B = 10
Output:
10 5
Explanation:
LCM of 5 and 10 is 10, while
thier GCD is 5.
Example 1:

Input:
A = 14 , B = 8
Output:
56 2
Explanation:
LCM of 14 and 8 is 56, while
thier GCD is 2.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function lcmAndGcd() which takes an Integer N as input and returns a List of two Integers, the required LCM and GCD.

 

Expected Time Complexity: O(log(min(A, B))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= A,B <= 1018

*/

public class LCM_And_GCD {

	static Long getLCM(Long A, Long B) {
		Long LCM = B;
		while((LCM%A)!=0) {
			LCM += B; 
		}
		return LCM;
	}

	static Long[] lcmAndGcd(Long A , Long B) {
		Long[] answer = new Long[2];
		answer[0] = getLCM(Math.min(A, B), Math.max(A, B));
		answer[1] = (A*B)/answer[0];
		return answer;
	}
	
}
