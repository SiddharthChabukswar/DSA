package GFG.Easy;

import java.util.Arrays;

/*

https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

Examples :

Input: start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
Output: 4
Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)
Input: start[] = [10, 12, 20], end[] = [20, 25, 30]
Output: 1
Explanation: Only one meetings can be held with given start and end timings.
Input: start[] = [1, 2], end[] = [100, 99]
Output: 1
Constraints:
1 ≤ n ≤ 105
0 ≤ start[i] < end[i] ≤ 106

*/

public class N_meetings_in_one_room {

	private class MeetingDetails implements Comparable<MeetingDetails> {
		
		int start;
		int end;

		MeetingDetails(final int start, final int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(MeetingDetails meetingDetails) {
			if (this.end < meetingDetails.end) {
				return -1;
			} else if (this.end > meetingDetails.end) {
				return 1;
			} else {
				if (this.start <= meetingDetails.start) return -1;
				else return 1;
			}
		}
	}

	// Function to find the maximum number of meetings that can
    // be performed in a meeting room.
	public int maxMeetings(int start[], int end[]) {
		
		int answer = 1, n = start.length;
		if (n==0) return 0;
		MeetingDetails[] meetingDetailsList = new MeetingDetails[n];
		MeetingDetails meetingDetails;
		for (int i=0; i<n; i++) {
			meetingDetails = new MeetingDetails(start[i], end[i]);
			meetingDetailsList[i] = meetingDetails;
		}

		Arrays.sort(meetingDetailsList);
		int prevEndTime = meetingDetailsList[0].end;
		for (int i=1; i<n; i++) {
			if (meetingDetailsList[i].start > prevEndTime) {
				prevEndTime = meetingDetailsList[i].end;
				answer++;
			}
		}
		return answer;
    }

}