package CodingNinjas.Medium;

import java.util.ArrayList;
import java.util.Collections;

/*

https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559

*/

public class Aggressive_Cows {

	static boolean isArrangementPossible(ArrayList<Integer> stalls, int k, int dist) {
		Integer prev, cows;
		prev = stalls.get(0);
		cows = 1;
		for(int i=1; i<stalls.size(); i++) {
			if(stalls.get(i)-prev >= dist) {
				cows++;
				prev = stalls.get(i);
			}
		}
		if(cows >= k) return true;
		return false;
	}

	public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
		int low, high, mid, slen = stalls.size();
		if(k > slen) return -1;
		Collections.sort(stalls);
		low = 1;
		high = stalls.get(slen-1) - stalls.get(0);
		while(low <= high) {
			mid = low + (high-low)/2;
			if(isArrangementPossible(stalls, k, mid) == true) low = mid+1;
			else high = mid-1;
		}
		return high;
	}

}