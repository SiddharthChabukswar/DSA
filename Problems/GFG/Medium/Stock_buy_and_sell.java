package GFG.Medium;

import java.util.ArrayList;
import java.util.List;

/*
https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/0?company[]=Intuit+&page=1&query=company[]Intuit+page1&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=stock-buy-and-sell

The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, the output should be in a single line.

Example 1:

Input:
N = 7
A[] = { 100, 180, 260, 310, 40, 535, 695 }

Output:
(0 3) (4 6)

Explanation 1:
We can buy stock on day 0, 
and sell it on 3rd day, 
which will give us maximum profit.
Example 2:

Input:
N = 10
A[] = {23, 13, 25, 29, 33, 19, 34, 45, 65, 67}

Output:
(1 4) (5 9)

Your Task:
Complete stockBuySell()  function and print all the days with profit in a single line. And if there is no profit then print "No Profit". You do not require to return since the function is void.

Constraints:
1 <= T <= 100
2 <= N <= 104
0 <= Ai <= 104

*/

class Pair {
	int first;
	int second;
	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class Stock_buy_and_sell {

	public void stockBuySell(int[] price, int n) {
		int i, j;
		i = j = 0;
		List<Pair> pairList = new ArrayList<Pair>();
		Pair currPair;
		int first, second;
		while(i<n) {
			j = i+1;
			first = i;
			second = i;
			while(j<n && price[j] > price[j-1]) {
				if(price[j] > price[second]){
					second = j;
				}
				j++;
			}
			if(j==i+1) {
				i = j;
				continue;
			}
			currPair = new Pair(first, second);
			pairList.add(currPair);
			i = j;
		}
		if(pairList.size() == 0) System.out.println("No Profit");
		else{
			for(i=0; i<pairList.size(); i++) {
				System.out.print("(" + pairList.get(i).first + " " + pairList.get(i).second + ") ");
			}
			System.out.println();
		}
	}

}