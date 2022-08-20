package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class fivehundredandsix {

	// Sorting O(nlogn)
	public String[] findRelativeRanks(int[] score) {
		int n = score.length;
		int[] sorted_score = score.clone();
		String[] ans = new String[n];
		// Get the sorted array
		Arrays.sort(sorted_score);
		HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
		for(int i=0; i<n; i++)
			rankMap.put(sorted_score[i], n-i);
		Integer rank;
		for(int i=0; i<n; i++){
			rank = rankMap.get(score[i]);
			if(rank == 1)
				ans[i] = "Gold Medal";
			else if(rank == 2)
				ans[i] = "Silver Medal";
			else if(rank == 3)
				ans[i] = "Bronze Medal";
			else
				ans[i] = String.valueOf(rank);
		}
		return ans;
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of elements(n): ");
		int n = sc.nextInt();
		int[] score = new int[n];

		System.out.println("Enter scores one by one: ");
		for(int i=0; i<n; i++)
			score[i] = sc.nextInt();
		fivehundredandsix objFivehundredandsix = new fivehundredandsix();
		String[] ans = objFivehundredandsix.findRelativeRanks(score);
		for(String ele: ans)
			System.out.print(ele + " ");
		sc.close();
	}
}
