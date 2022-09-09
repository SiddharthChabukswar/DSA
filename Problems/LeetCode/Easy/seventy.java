package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45


*/

public class seventy {

	public int climbStairs(int n) {
		int answer = 0;
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 2;

		// Dyanmic Programming approach - Fibonacci series O(n)
		// nth step could be reach from (n-1)th step (one hop) or from (n-2)th step (two hop).
		// Hence if we calculate ways to reach (n-1)th and (n-2)th step we can find steps(n) = steps(n-1) + steps(n-2)
		// Which leads to fibonacci sequence
		int prevprevstep = 1, prevstep = 2, temp = 0;
		for(int i=3; i<=n; i++){
			answer = prevstep + prevprevstep;
			temp = prevstep;
			prevstep = answer;
			prevprevstep = temp;
		}
		
		return answer;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		seventy objSeventy = new seventy();
		System.out.println(objSeventy.climbStairs(n));
		sc.close();
	}

}
