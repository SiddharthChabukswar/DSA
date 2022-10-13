package GFG.Medium;

/*

https://practice.geeksforgeeks.org/problems/koko-eating-bananas/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=koko-eating-bananas

Given N piles of bananas, the ith pile has piles[i] bananas and H hours time until guards return (N < H). Find the minimum (S) bananas to eat per hour such that Koko can eat all the bananas within H hours. Each hour, Koko chooses some pile of bananas and eats S bananas from that pile. If the pile has less than S bananas, then she consumes all of them, and wont eat any more bananas during that hour. 

Example 1:
Input:
n = 4
piles = [3, 6, 7, 11]
H = 8
Output:
4
Example 2:
Input:
n = 5
piles = [30, 11, 23, 4, 20]
H = 5
Output:
30
Your Task:
You don't need to read input or print anything. Your task is to complete the function Solve() which takes an integer n and a list of piles and integer H denoting Hour and return the minimum bananas to eat per hour.

Constraint:
1 <= n <= 104 
1 <= piles[i] <= 109 
n <= H <= 104

*/

public class Koko_Eating_Bananas {

	static boolean canEat(int[] piles, int k, int H) {
		int max_k = 0;
		for(int pile: piles) {
			max_k += (pile/k);
			if(pile%k != 0) max_k++;
		}
		return (max_k <= H)?true:false;
	}

	public static int Solve(int N, int[] piles, int H) {
		int low = 1, high = Integer.MIN_VALUE, mid;
		for(int pile: piles) if(pile > high) high = pile;
		while(low <= high) {
			mid = low + (high-low)/2;
			if(canEat(piles, mid, H) == true) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

}