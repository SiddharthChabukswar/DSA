package GFG.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*

https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

Job Sequencing Problem
Difficulty: MediumAccuracy: 34.51%Submissions: 274K+Points: 4
You are given three arrays: id, deadline, and profit, where each job is associated with an ID, a deadline, and a profit. Each job takes 1 unit of time to complete, and only one job can be scheduled at a time. You will earn the profit associated with a job only if it is completed by its deadline.

Your task is to find:

The maximum number of jobs that can be completed within their deadlines.
The total maximum profit earned by completing those jobs.
Examples :

Input: id = [1, 2, 3, 4], deadline = [4, 1, 1, 1], profit = [20, 1, 40, 30]
Output: [2, 60]
Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
Input: id = [1, 2, 3, 4, 5], deadline = [2, 1, 2, 1, 1], profit = [100, 19, 27, 25, 15]
Output: [2, 127]
Explanation: Job1 and Job3 can be done with maximum profit of 127 (100+27).
Input: id = [1, 2, 3, 4], deadline = [3, 1, 2, 2], profit = [50, 10, 20, 30]
Output: [3, 100]
Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).
Constraints:
1 <=  id.size() == deadline.size() == profit.size() <= 105
1 <= id[i], deadline[i] <= id.size()
1 <= profit <= 500

*/
public class Job_Sequencing_Problem {

	private class JobDetails implements Comparable<JobDetails> {
		
		int deadline;
		int profit;

		JobDetails(final int deadline, final int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public int compareTo(JobDetails jobDetails) {
			if (this.profit > jobDetails.profit) return -1;
			else if (this.profit < jobDetails.profit) return 1;
			else if (this.deadline > jobDetails.deadline) return -1;
			else return 1;
		}

	}

	public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
		int n = id.length;
		JobDetails[] jobDetailsArr = new JobDetails[n];
		for (int i=0; i<n; i++) {
			jobDetailsArr[i] = new JobDetails(deadline[i], profit[i]);
		}
		Arrays.sort(jobDetailsArr);
		int sumProfit = 0;
		Set<Integer> busyTimes = new HashSet<>();
		JobDetails jobDetails;
		for (int i=0; i<n; i++) {
			jobDetails = jobDetailsArr[i];
			for (int j=jobDetails.deadline; j>0; j--) {
				if (busyTimes.contains(j)) continue;
				else {
					System.out.print("sum profit: " + jobDetails.profit);
					sumProfit += jobDetails.profit;
					busyTimes.add(j);
					break;
				}
			}
		}
		ArrayList<Integer> answerList = new ArrayList<>();
		answerList.add(busyTimes.size());
		answerList.add(sumProfit);
		return answerList;
	}


}