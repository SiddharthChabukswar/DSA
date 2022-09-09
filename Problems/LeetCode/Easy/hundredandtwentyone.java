package LeetCode.Easy;

import java.util.Scanner;

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

*/

public class hundredandtwentyone {

	// Travel from left to right: O(n)
	// set max_answer = MAX(max_answer, prices[i] - buy)
	// update buy = MIN(buy, prices[i])

	public int maxProfit(int[] prices) {
		int buy = prices[0], max_answer = 0, n = prices.length;
		for(int i=0; i<n; i++){
			buy = Math.min(buy, prices[i]);
			max_answer = Math.max(max_answer, (prices[i] - buy));
		}
		return max_answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter length of array: ");
		int n = sc.nextInt();
		int[] prices = new int[n];
		System.out.println("Enter array elements: ");
		for(int i=0; i<n; i++) prices[i] = sc.nextInt();
		hundredandtwentyone objHundredandtwentyone = new hundredandtwentyone();
		int answer = objHundredandtwentyone.maxProfit(prices);
		System.out.println(answer);
		sc.close();
	}
	
}
