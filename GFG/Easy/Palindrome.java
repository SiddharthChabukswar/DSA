package GFG.Easy;

/*

https://practice.geeksforgeeks.org/problems/palindrome0746/1

Given an integer, check whether it is a palindrome or not.

Example 1:

Input: n = 55555
Output: Yes

Example 2:

Input: n = 123
Output: No
 

Your Task:
You don't need to read or print anything. Your task is to complete the function is_palindrome() which takes the number as input parameter and returns "Yes" if it is palindrome otherwise returns "No"(Without quotes).
 

Expected Time Complexity: O(x)
Expected Space Complexity: O(x) where x is number of digits in n.
 

Constraints:
1 <= n <= 1000

*/

public class Palindrome {
	
	public String is_palindrome(int n){
		int n_curr = n, n_rev = 0;
		while(n_curr != 0) {
			n_rev = (n_rev*10)+(n_curr%10);
			n_curr /= 10;
		}
		if(n_rev == n) return "Yes";
		return "No";
	}
}
