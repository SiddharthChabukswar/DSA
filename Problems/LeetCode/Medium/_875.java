package LeetCode.Medium;

/* 

https://leetcode.com/problems/koko-eating-bananas/

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23
 

Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109


*/


public class _875 {

	boolean canEat(int[] piles, int k, int h) {
		long max_k = 0l;
		for(int pile: piles) {
			max_k += (long)(pile/k);
			if(pile%k != 0) max_k++;
		}
		return (max_k <= (long)h)?true:false;
	}

	public int minEatingSpeed(int[] piles, int h) {
		int low = 1, high = Integer.MIN_VALUE, mid;
		for(int pile: piles) high = Math.max(high, pile);
		while(low <= high) {
			mid = low + (high-low)/2;
			if(canEat(piles, mid, h) == true) high = mid-1;
			else low = mid+1;
		}
		return low;
	}
	
}
